package leetcode209长度最小的子数组;

public class leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, res = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
