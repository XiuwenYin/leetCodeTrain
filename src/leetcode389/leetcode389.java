package leetcode389;

import java.util.HashMap;
import java.util.Map;
// 找不同
public class leetcode389 {
    /**
     * 求和字符串，差值为不同字符的ASCII码
     */
    public char findTheDifference(String s, String t) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < s.length(); i++) {
            sum1 += s.charAt(i);
        }
        for (int i = 0; i< t.length(); i++) {
            sum2 += t.charAt(i);
        }
        return (char)(sum2 - sum1);
    }

    /**
     * 使用位运算：异或
     */
    public char findTheDifference01(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }
        return (char)res;
    }
}
