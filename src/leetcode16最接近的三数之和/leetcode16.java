package leetcode16最接近的三数之和;

import java.util.Arrays;

public class leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[n - 1];
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(res - target) > Math.abs(sum - target)) res = sum;

                if (sum < target) left++;
                else right--;
            }
        }
        return res;
    }
}
