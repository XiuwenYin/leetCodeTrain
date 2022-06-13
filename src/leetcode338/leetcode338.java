package leetcode338;

public class leetcode338 {
    /*
    dp + 位运算
    偶数的 1 数量和 偶数 / 2 相同
    奇数的 1 数量和 奇数 / 2 + 1 相同
    使用 i & 1 判断奇偶性
    状态转移方程：dp[i] = dp[i >> 1] + (i & 1)
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
