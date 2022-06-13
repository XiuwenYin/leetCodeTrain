package leetcode1143最长公共子序列;

public class leetcode1143 {
    /*
    和 115 类似
    转移方程只能从 左上 来

    如果不同：取最大
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;

        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
