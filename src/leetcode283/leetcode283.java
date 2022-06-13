package leetcode283;

public class leetcode283 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        if (nums.length < 1) {
            return;
        }
        for (; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (i < j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
