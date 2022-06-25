package leetcode438找到字符串中所有字母异位词;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode438 {
    /**
     * 滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 用于返回字母异位词的起始索引
        List<Integer> res = new ArrayList<>();
        // 用 map 存储目标值中各个单词出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        // 用另外一个 map 存储滑动窗口中有效字符出现的次数
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0; // 左指针
        int right = 0; // 右指针
        int valid = p.length(); // 只有当 valid == 0 时，才说明 window 中包含了目标子串
        while (right < s.length()) {
            char c = s.charAt(right);
            // 如果目标子串中包含了该字符，才存入 window 中
            if (map.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 只有当 window 中该有效字符数量不大于map中该字符数量，才能算一次有效包含
                if (window.get(c) <= map.get(c)) {
                    valid--;
                }
            }
            // 如果 window 符合要求，即两个 map 存储的有效字符相同，就可以移动左指针了
            // 但是只有二个map存储的数据完全相同，才可以记录当前的起始索引，也就是left指针所在位置
            while (valid == 0) {
                char cur = s.charAt(left);
                if (right - left + 1 == p.length()) res.add(left);
                // 如果左指针指的是有效字符,需要更改 window 中的 key 对应的 value
                // 如果 有效字符对应的数量比目标子串少，说明无法匹配了
                if (map.containsKey(cur)) {
                    window.put(cur, window.get(s.charAt(left)) - 1);
                    if (window.get(cur) < map.get(cur)) {
                        valid++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
