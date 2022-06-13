package leetcode76最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class leetcode76 {
    /**
     * 滑动窗口经典题目
     * @param s
     * @param t target
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        // 将target所有字符统计并放入map中，map的作用类似一个投票箱（remaining character）
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            /*如果map中包含这个字符，则计数器count++，并且同时这个字符在map中的value要减去1
            * 类似投票法，出现一个对应的字符就将box中的数量-1*/
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count++;
                map.put(c, map.get(c) - 1); // 此处map中的v可能很小，到-10或-20之类的（为了解释下面的count--）
            }
            // 当现在的区间valid的话，找寻最小值
            while (count == t.length()) {
                if (i - left + 1 < minLen) { // 更新最短区间的逻辑，由于需要提取substring，使得Math.min()不好用，此处直接用if判断
                    minLen = i - left + 1;
                    minStart = left;
                }
                // 这下面的逻辑是吐出来（更新长度后）
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count--; // 仅当valid count变为正数时，count才--
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen);
    }
}
