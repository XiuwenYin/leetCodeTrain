package leetcode121;

// 买卖股票的最佳时机
public class leetcode121 {
    // 动态规划
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        /*
        dp[i][0]: 表示 i天时不持股
        dp[i][1]: 表示 i天时持股
         */
        int[][] dp = new int[n][2];
        // 初始化
        dp[0][0] = 0; // 第一天不持股手中现金
        dp[0][1] = -prices[0]; // 第一天持股手中现金

        for(int i = 1; i < n; i++) {
            // 今天不持股：比较昨天不持股（今天不卖出）、昨天持股（今天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天持股：比较今天买入、昨天持股（今天不卖出），如果昨天不持股则没有比较意义
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        // 返回最后一天不持股的现金数量
        return dp[n - 1][0];
    }
}
