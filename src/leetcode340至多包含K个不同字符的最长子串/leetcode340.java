package leetcode340至多包含K个不同字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class leetcode340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
