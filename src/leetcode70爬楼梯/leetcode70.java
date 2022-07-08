package leetcode70爬楼梯;

import java.util.ArrayList;
import java.util.List;

public class leetcode70 {
    /*
    dp
    动态转移方程：f(x) = f(x - 2) + f(x - 1)
    此时的数量等于：之前迈过两级台阶到这一层的 + 之前迈过一级台阶到这一层的
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
