package leetcode357;

public class leetcode357 {
    /**
     * 动态规划 dp
     * 动态转移方程： dp[i] = dp[i-1] + (dp[i-1] - dp[i-2])*(10-(i-1))
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i -1] - dp[i - 2]) * (10 - i + 1);
        }
        return dp[n - 1];
    }
}
