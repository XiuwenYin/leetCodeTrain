package leetcode343整数拆分;

public class leetcode343 {
    /*
    dp
    状态转移方程：dp[i] = MAX{MAX[j * (i - j), j * dp[i - j]], curMax}
    四挡板：2, j, i, n：在j时，i - j可拆分可不拆分，
    不拆分就是 j * (i - j)
    拆分就是 j * dp[i - j]
    在这两者中取Max，并与上一层的Max比较
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
//        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            int max1 = 0;
            for (int j = 1; j < i; j++) {
                int max2 = Math.max(j * (i - j), j * dp[i - j]);
                max1 = Math.max(max1, max2);
            }
            dp[i] = max1;
        }
        return dp[n];
    }
}
