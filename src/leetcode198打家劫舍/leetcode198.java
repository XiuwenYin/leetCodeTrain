package leetcode198打家劫舍;

public class leetcode198 {
    /**
     * dp，隔一位收取一次，1维数组中两个状态
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, nums[i]);
            }
            return res;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
