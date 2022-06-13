package leetcode123买卖股票的最佳时机III;

public class leetcode123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        // dp[x][y] 表示：x = 0，不持有股票；x = 1，持有股票；y 为交易次数，dp[x][y] 表示在x状态时有y次交易的股票盈利
        int[][] dp = new int[2][3];
        dp[1][1] = -prices[0];
        dp[1][2] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[0][j] = Math.max(dp[0][j], dp[1][j] + prices[i]);
                dp[1][j] = Math.max(dp[1][j], dp[0][j - 1] - prices[i]);
            }
        }
        return dp[0][2];
    }
}
