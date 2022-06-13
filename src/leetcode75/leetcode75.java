package leetcode75;

public class leetcode75 {
    /*
    双指针
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        // 左右指针
        int left = 0, right = n -1;
        // 一次遍历
        for (int i = 0; i <= right; i++) {
            // 由于数组中只存在 0 1 2，所以各个指针分别指代一个数字
            //
            while (i <= right && nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
