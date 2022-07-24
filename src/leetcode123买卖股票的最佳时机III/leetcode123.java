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

    /**
     * 最快
     * buy1代表第一次买，任何时候的转态转移都是基于之前的buy1和当前的-price[i]进行的
     * sell1代表第一次卖，是基于存在buy1的状态下在任意一天卖的状态，所以状态转移中会出现buy1
     * buy2代表第二次买，是基于存在sell1的状态下在任意一天买的状态，所以状态转移中存在sell1
     * sell2代表第二次卖，是基于存在buy2的状态下在任意一天卖的状态，所以转态转移中存在buy2
     *
     * 而由于存在同一天买同一天卖，所以最终sell1和sell2会被状态压缩至相同，所以只用返回sell2即可
     */
    public int maxProfit01(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
