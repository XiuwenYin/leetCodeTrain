package leetcode154寻找旋转排序数组中的最小值II;

public class leetcode154 {
    /**
     * 二分
     * 与上一题极为类似
     * 都是特化二分，倾向于mid和right的比较，判断右侧是否单调递增（寻找最小向左），从而truncate
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right--; // 重点，由于有重复元素的存在，所以当 nums[mid] = nums[right]时，仅仅right--就够了
        }
        return nums[left];
    }
}
