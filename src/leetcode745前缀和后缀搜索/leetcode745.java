package leetcode745前缀和后缀搜索;

import java.util.ArrayList;
import java.util.List;

public class leetcode745 {
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */

/**
 * 暴力破解
 */
class WordFilter {
    String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String pref, String suff) {
        int n1 = pref.length(), n2 = suff.length();
        outer:
        for (int k = words.length - 1; k >= 0; k--) { // 由于题目要求如果有重复要取最大，所以直接从后向前
            String cur = words[k];
            int len = cur.length();
            if (len < n1 || len < n2) continue; // 先判断pref和suff长度是否超过当前遍历的cur的长度，如果是，则无需后续判断直接continue
            boolean ok = true;
            for (int i = 0; i < n1 && ok; i++) {
                char c1 = cur.charAt(i), c2 = pref.charAt(i);
                if (c1 != c2) continue outer;
            }
            for (int i = 0; i < n2 && ok; i++) {
                char c1 = cur.charAt(len - 1 - i), c2 = suff.charAt(n2 - 1 - i);
                if (c1 != c2) continue outer;
            }
            return k; // 如果能到这里表示满足条件，之间返回当前index
        }
        return -1;
    }
}

/**
 * 字典树Trie
 */
class WordFilter01 {

    class TrieNode {
        List<Integer> list = new ArrayList<>();
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode prefix = new TrieNode();
    private TrieNode suffix = new TrieNode();

    public WordFilter01(String[] words) {
        build(prefix, words, true);
        build(suffix, words, false);
    }

    public int f(String pref, String suff) {
        List<Integer> prefList = query(prefix, pref, true);
        List<Integer> suffList = query(suffix, suff, false);
        int i = prefList.size() - 1, j = suffList.size() - 1;
        while (i >= 0 && j >= 0) {
            // 注意：比较 Integer 类变量最好不要直接比较，自动拆箱成 int 后再比较
            int l1 = prefList.get(i), l2 = suffList.get(j);
            if (l1 == l2) return l1;
            else if (l1 > l2) i--;
            else j--;
        }
        return -1;
    }

    /**
     * 构造字典树
     */
    private void build(TrieNode root, String[] words, boolean isPref) {
        for (int i = 0; i < words.length; i++) {
            TrieNode ptr = root;
            int len = words[i].length();
            for (int j = isPref ? 0 : len - 1; j >= 0 && j < len; j = isPref ? j + 1 : j - 1) {
                int cur = words[i].charAt(j) - 'a';
                if (ptr.children[cur] == null) ptr.children[cur] = new TrieNode();
                ptr = ptr.children[cur];
                ptr.list.add(i);
            }
        }
    }

    /**
     * 利用字典树进行前缀和后缀的遍历查找
     */
    private List<Integer> query(TrieNode root, String s, boolean isPref) {
        TrieNode ptr = root;
        int len = s.length();
        for (int i = isPref ? 0 : len - 1; i >= 0 && i < len; i = isPref ? i + 1 : i - 1) {
            int cur = s.charAt(i) - 'a';
            if (ptr.children[cur] == null) return new ArrayList<>();
            ptr = ptr.children[cur];
        }
        return ptr.list;
    }
}