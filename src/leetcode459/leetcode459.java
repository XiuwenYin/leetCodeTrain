package leetcode459;
// 重复的子字符串
public class leetcode459 {
    /**
     * kmp
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 0) {
            return false;
        }
        int[] next = getNext(s);
        int maxLen = next[n - 1] + 1;
        if (maxLen == 0 || s.charAt(n - 1) != s.charAt(n - 1 - maxLen)) {
            return false;
        }
        return n % (n - maxLen) == 0;
    }


    public int[] getNext(String p) {
        int m = p.length();
        int i = 0, j = -1;
        int[] next = new int[m];
        next[0] = -1;
        while (i < m) {
            if (j == -1 && p.charAt(j) == p.charAt(i)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
