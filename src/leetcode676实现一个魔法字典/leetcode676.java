package leetcode676实现一个魔法字典;

public class leetcode676 {

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

/**
 * 暴力破解
 * 由于测试用例不多，所以暴力反而效率高
 * 对比每一个字符串中的字符是否和searchWord匹配，如果不匹配则计数+1；最后看计数是否为1，则返回true；不是，则返回false
 */
class MagicDictionary {
    public String[] words;
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        words = dictionary;
    }

    public boolean search(String searchWord) {
        outer : for (String x : words) {
            if (x.length() != searchWord.length()) continue;
            int diff = 0;
            for (int i = 0; i < x.length(); i++) {
                char c1 = x.charAt(i), c2 = searchWord.charAt(i);
                if (c1 != c2) {
                    diff++;
                    if (diff > 1) continue outer;
                }
            }
            if (diff == 1) return true;
        }
        return false;
    }
}