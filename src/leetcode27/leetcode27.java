package leetcode27;
// 移除元素
public class leetcode27 {
    /**
     * 双指针
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        // i慢 j快
        int i = 0, j = 0;
        for (; j < n; j++) {
            // 当j位置不等于目标值时，将j位置的值赋给i，j和i同时++
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
