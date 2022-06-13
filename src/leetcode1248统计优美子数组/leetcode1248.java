package leetcode1248统计优美子数组;

public class leetcode1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    private int atMost(int[] nums, int k) {
        int left = 0, res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            k -= nums[i] % 2;
            while (k < 0) {
                k += nums[left] % 2;
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}
