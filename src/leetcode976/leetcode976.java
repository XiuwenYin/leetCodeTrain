package leetcode976;

import java.util.Arrays;

public class leetcode976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, temp = 0, max = 0;
        if (n < 3) {
            return 0;
        }
        /*
        贪心，先假设最后一位能够组成三角形，
        不能的话再向前枚举，直到倒数第三位（i >= 2）
        if 判断 两边之和大于第三边（第三边必定为i边（最大），因为数组已经排序）
         */
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i] < (nums[i - 1] + nums[i - 2])) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }

        }
        return 0;
    }
}
