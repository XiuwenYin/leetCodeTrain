package leetcode115;

public class leetcode115 {
    /**
     * 和 1143 类似
     * 左上角开始到右下角
     * 转移方程只能通过 左边 和 左上 转移而来
     * 如果不同：取左
     */
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = t.charAt(i - 1);
                char c2 = s.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
