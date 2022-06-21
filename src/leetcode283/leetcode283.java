package leetcode283;

public class leetcode283 {
    /**
     * 效率更高
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        if (nums.length < 1) {
            return;
        }
        while (j < nums.length) {
            if (nums[j] != 0) {
                if (i < j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
            j++;
        }
    }

    public void moveZeroes01(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < n) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                    j++;
                }
            }
        }
    }
}
