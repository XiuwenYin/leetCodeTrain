package leetcode416分割等和子集;

import java.util.Arrays;

public class leetcode416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n % 2 != 0) return false;
        int sum = Arrays.stream(nums).sum();
        sum /= 2;

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
