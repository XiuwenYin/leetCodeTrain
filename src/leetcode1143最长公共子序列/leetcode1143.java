package leetcode1143最长公共子序列;

import java.math.BigInteger;

public class leetcode1143 {
    /**
     * 和 115 类似
     * 转移方程只能从 左上 来
     *
     * 如果不同：取最大
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequence01(String text1, String text2) {
        char[] sc1 = text1.toCharArray();
        char[] sc2 = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n+1];
        for (char c : sc1) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                int next = dp[i+1];
                if (c == sc2[i]) {
                    dp[i+1] = curr + 1;
                } else {
                    dp[i+1] = Math.max(dp[i], dp[i+1]);
                }
                curr = next;
            }
        }
        return dp[n];
    }
}
