package leetcode877;

public class leetcode877 {
    /*
    dp
    先填充对角线 dp[i][i] = piles[i]
    从右侧头开始留出两位
    分出sub array，左边界是i，右边界是j
    动态转移方程
    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
     */
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i <= n; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n] > 0;
    }
}
