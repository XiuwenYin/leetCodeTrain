package leetcode238;

public class leetcode238 {
    /**
     * 前缀积和后缀积
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums;
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return res;
    }
}
