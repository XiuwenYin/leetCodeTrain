package leetcode209长度最小的子数组;

public class leetcode209 {
    /**
     * 滑动窗口 简单
     * O(n)时间复杂度
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res + 1; // 长度需要加1
    }
}
