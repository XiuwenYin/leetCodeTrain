package leetcode953;

import java.util.HashMap;
import java.util.Map;

// 验证外星语词典
public class leetcode953 {
    public boolean isAlienSorted(String[] words, String order) {
        // 创建order的字母表
        int[] arr = new int[26];
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }
        search:
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (arr[word1.charAt(j) - 'a'] > arr[word2.charAt(j) - 'a']) {
                        return false;
                    }
                    continue search;
                }
            }
            if (word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAlienSorted01(String[] words, String order) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            hashMap.put(c, i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String pre = words[i];
            String cur = words[i + 1];
            boolean smaller = false;
            int minLen = Math.min(pre.length(), cur.length());
            for (int j = 0; j < minLen; j++){
                if (hashMap.get(pre.charAt(j)) < hashMap.get(cur.charAt(j))) {
                    smaller = true;
                    break;
                } else if (hashMap.get(pre.charAt(j)) > hashMap.get(cur.charAt(j))) {
                    return false;
                }
            }
            if (!smaller && pre.length() > cur.length()) {
                return false;
            }
        }
        return true;
    }
}
