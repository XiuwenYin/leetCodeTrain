package leetcode395至少有K个重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class leetcode395 {
    public int longestSubstring(String s, int k) {
        int res = 0, n = s.length();
        for (int unique = 0; unique <=26; unique++) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0, validCount = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == k) validCount++;
                while (map.keySet().size() > unique) {
                    char leftChar = s.charAt(left);
                    if (map.getOrDefault(leftChar, 0) == k) validCount--;
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    if (map.get(leftChar) == 0) map.remove(leftChar);
                    left++;
                }
                int count = map.keySet().size();
                if (count == unique && count == validCount) res = Math.max(res, i - left + 1);
            }
        }
        return res;
    }
}
