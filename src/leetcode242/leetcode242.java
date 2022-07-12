package leetcode242;


import java.util.Arrays;
// 有效的字母异位词
public class leetcode242 {
    /**
     * sort，用Arrays.equals();
     */
    public boolean isAnagram(String s, String t) {
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    /**
     * 字母表（哈希表简单版，对于延伸考虑则使用哈希表存储）
     */
    public boolean isAnagram02(String s, String t) {
        int[] alArray = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            alArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alArray[t.charAt(i) - 'a']--;
            if (alArray[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * 位运算：异或
     * 无法通过
     */
    public boolean isAnagram03(String s, String t) {
        int res = 0;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        if (c1.length != c2.length) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            res ^= c1[i];
            res ^= c2[i];
        }

        return res == 0;
    }
}
