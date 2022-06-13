package leetcode1312让字符串成为回文串的最少插入次数;

public class leetcode1312 {
    /*
    dp
    类似 1143 题、 516 题
    从右侧开始留下一位
    i左移，j右移
     */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
