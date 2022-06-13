package leetcode383;

import java.util.HashMap;
import java.util.Map;
// 赎金信
public class leetcode383 {
    /**
     * 使用哈希表记录字符次数
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length();
        int n = magazine.length();
        if (m > n) {
            return false;
        }
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) - 1);
            if (hashMap.containsValue(-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode383 test = new leetcode383();
        test.canConstruct("aa", "aab");
//        String a = "abc";
//        String b = "cba";
//        System.out.println(a ^ b);
    }
}
