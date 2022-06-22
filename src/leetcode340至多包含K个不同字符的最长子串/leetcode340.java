package leetcode340至多包含K个不同字符的最长子串;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class leetcode340 {
    /**
     * 滑动窗口 | 高频
     * map<Character, Integer>，每次放入增加数量
     * 如果map大小超过了k，代表越界了（个数越界），
     * 此时此刻抛出在left位置上的c，每次更新res的长度
     * @param s
     * @param k
     * @return
     */
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

    /**
     * 练习
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct01(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int res = 0;
        char[] arr = s.toCharArray();
        int left = 0;
        for (int i = 0; i < n; i++) {
            char cur = arr[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > k) {
                char c = arr[left];
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    /**
     * 本题的follow up，如果输入改为流，且过长的情况下；或者是插拔硬盘形成的数据流
     * 使用 TreeMap 或者 LinkedHashMap
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct02(String s, int k) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int n = s.length();
        char[] arr = s.toCharArray();
        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            char cur = arr[i];
            map.remove(cur); // 先清除上一位的位置
            map.put(cur, i); // 放入最新的cur的位置
            if (map.size() > k) {
                char c = map.keySet().iterator().next();
                int idx = map.get(c);
                j = idx + 1;
                map.remove(c);
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}
