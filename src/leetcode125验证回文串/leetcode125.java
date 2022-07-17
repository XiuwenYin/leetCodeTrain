package leetcode125验证回文串;

import java.util.Locale;

public class leetcode125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
