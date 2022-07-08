package leetcode648单词替换;

import java.util.*;

public class leetcode648 {
    /**
     * 利用set的contains方法，获取每次temp的substring进行对比
     * 比较容易想到
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] arr = sentence.split(" ", -1);
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            int n = temp.length();
            for (int j = 0; j < n; j++) {
                if (set.contains(temp.substring(0, j))) {
                    arr[i] = temp.substring(0, j);
                    break;
                }
            }
        }
        return String.join(" ", arr);
    }

    /**
     * 字典树
     *用 dictionary 中所有词根构建一棵字典树，并用特殊符号标记结尾。在搜索前缀时，只需在字典树上搜索出一条最短的前缀路径即可
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords01(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    private String findRoot(String word, Trie trie) {
        StringBuilder root = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }

    class Trie {
        Map<Character, Trie> children;

        public Trie() {
            children = new HashMap<>();
        }
    }
}
