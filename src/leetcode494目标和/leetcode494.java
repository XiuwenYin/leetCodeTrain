package leetcode494目标和;

public class leetcode494 {
    /**
     * 可以看做二叉树的dfs
     * 慢，但好用
     */
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int len, int cur) {
        int n = nums.length;
        if (len == n) return cur == target ? 1 : 0;

        int left = dfs(nums, target, len + 1, cur + nums[len]);
        int right = dfs(nums, target, len + 1, cur - nums[len]);
        return left + right;
    }

    /**
     * 本题可以转换成0-1背包问题，相当于装满容量为P的背包，sum(P) = (target + sum(nums) / 2),有多少种方法?
     */
    public int findTargetSumWays01(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum < target || (sum + target) % 2 == 1 || sum + target < 0) return 0;

        int p = (target + sum) / 2;

        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = p; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[p];
    }
}
