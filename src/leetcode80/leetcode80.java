package leetcode80;
// 删除有序数组中的重复项 II
public class leetcode80 {
    /**
     * 双指针
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        // 如果长度小于2则不用考虑，
        // 若长度大于2则前两位必定保留，所以指针初始从2开始
        int i = 2, j = 2;
        while (j < n) {
            // 如果前2位i的值不等于目前j的值，则此时i的值等于j的值，两指针后移
            if (nums[i - 2] != nums[j]) {
                nums[i++] = nums[j++];
                // 若相等，则快指针j后移，i不动
            } else {
                j++;
            }
        }
        return i;
    }

    /*
    练习
     */
//    public int removeDuplicates01(int[] nums) {
//        int n = nums.length;
//        int i = 2, j = 2;
//        while (j < nums.length) {
//            if (nums[j] != nums[i - 2]) {
//                nums[i++] = nums[j++];
//            } else {
//                j++;
//            }
//        }
//        return i;
//    }
}
