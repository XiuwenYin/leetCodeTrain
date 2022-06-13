package leetcode53;

import java.util.Arrays;
import java.util.OptionalInt;

public class leetcode53 {
    // 动态规划，遍历时每次都更新当前数据
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
