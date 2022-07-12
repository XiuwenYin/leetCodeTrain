package leetcode5最长回文子串;

public class leetcode5 {
    /**
     * 动态规划
     * dp[i][j]表格表示字符串s 从 i 到 j 区间是否为回文
     * 然后如果一段子字符串左右两头字符不相等，则这个子字符串不是回文
     * 先填写列，再填写行
     * 每个单元格都取决于左下方的 T or F，如果是T则是T，反之则是F
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        // 先对动态规划表格进行主对角线的true填充（因为一个子字符串中，若是dp[i][j]中i == j，则此子字符串必定是回文字符串）
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        char[] cArray = s.toCharArray();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (cArray[i] != cArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome01(String s) {
        int n = s.length();
        if (n == 0) return "";
        String lps = s.substring(0, 1);
        boolean[][] dp = new boolean[n][n];

        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            dp[i][i] = true;
            dp[i][i - 1] = true;
        }

        for (int left = 2; left <= n; left++) { // 此处边界都是 <=
            for (int i = 0; i <= n - left; i++) {
                int j = i + left - 1; // 子串右边界
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]; // 左右各向内集中一格
                if (dp[i][j]) {
                    lps = s.substring(i, j + 1);
                }
            }
        }
        return lps;
    }

    public String longestPalindrome02(String s) {
        if (s.length() < 2) return s;
        int n = s.length();
        int start = 0;  //最长回文串的起点
        int end = 0;    //最长回文串的终点
        int len = 1;  //最长回文串的长度
        boolean[][] dp = new boolean[n][n];

        for (int right = 1; right < n; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > len) {
                        len = right - left + 1;
                        start = left;
                        end = right;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
