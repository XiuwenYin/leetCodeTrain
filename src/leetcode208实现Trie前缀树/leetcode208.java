package leetcode208实现Trie前缀树;

public class leetcode208 {

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * 创建字典树
 */
class Trie {
    /*创建字典树节点类*/
    class TrieNode {
        // 创建字典树节点数组，用于存储26个字母，每个位置中都可以包含26个不同的字典树节点类，相当于一个26叉树
        TrieNode[] tns = new TrieNode[26];
        boolean end; // 记录结束节点，用于记录当前节点是否是字符串的末尾
    }

    // 创建全局变量
    TrieNode root;

    public Trie() { // 在构造函数中实例化
        root = new TrieNode();
    }

    // 插入函数
    public void insert(String word) {
        TrieNode p = root; // 先定义指针
        int n = word.length();
        for (int i = 0; i < n; i++) { // 对字符串进行遍历
            int c = word.charAt(i) - 'a'; // 对每一位字符进行 - 'a'用于变成int存储进字典树数组中对应的位置
            if (p.tns[c] == null) p.tns[c] = new TrieNode(); // 如果发现当前tns在c的位置为空，则在这里创建一个字典树节点
            p = p.tns[c]; // 移动指针到当前字符的节点
        }
        p.end = true; // 遍历完成后在最末尾修改判断为true，表示字符串在这里结尾
    }

    // 查找函数，逻辑类似
    public boolean search(String word) {
        TrieNode p = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int c = word.charAt(i) - 'a';
            if (p.tns[c] == null) return false; // 如果当前字典树数组的位置为空，则代表这个字符在字典树中不存在，进而表示不存在这个字符串，所以返回false
            p = p.tns[c];
        }
        return p.end; // 遍历完成后查看当前节点是否为结束节点
    }

    // 搜索前缀函数
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            int c = prefix.charAt(i) - 'a';
            if (p.tns[c] == null) return false;
            p = p.tns[c];
        }
        return true; // 对于前缀搜索无需判断是否为结束节点
    }
}
