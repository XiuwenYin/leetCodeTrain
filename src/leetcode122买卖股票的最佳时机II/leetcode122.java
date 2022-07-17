package leetcode122买卖股票的最佳时机II;

public class leetcode122 {
    /**
     * 这个贪心可以说是和121几乎一毛一样
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 除了这里，要用dp[i - 1][0] - prices[i]，由于多次交易需要带上之前的收益
        }
        return dp[n - 1][0];
    }
}
