package leetcode35搜索插入位置;

public class leetcode35 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
