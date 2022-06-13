package leetcode387;

import java.util.HashMap;
import java.util.Map;
// 字符串中的第一个唯一字符
public class leetcode387 {
    /**
     *  用哈希表存储每个字符出现次数（存储频数）
     *  两次遍历
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
