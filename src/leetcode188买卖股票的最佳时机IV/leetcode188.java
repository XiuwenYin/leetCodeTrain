package leetcode188买卖股票的最佳时机IV;

public class leetcode188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        if (k >= n / 2) {
            int max = 0;
            for (int i = 0; i < n - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    max += prices[i + 1] - prices[i];
                }
            }
            return max;
        }
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int x = 1; x < j; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][x] + prices[j - 1] - prices[x - 1]);
                }
            }
        }
        return dp[k][n];
    }
}
