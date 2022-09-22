package leetcode1608特殊数组的特征值;

import java.util.Arrays;

public class leetcode1608 {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < 1010; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= i) right = mid;
                else left = mid + 1;
            }
            if (nums[right] >= i && i == n - right) return i;
        }
        return -1;
    }
}
