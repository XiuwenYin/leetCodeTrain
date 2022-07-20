package leetcode33搜索旋转排序数组;

public class leetcode33 {
    /**
     * 二分
     * 分段讨论
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int left = 0, right = len - 1;
        while (left <= right) {
            // 1. 首先明白，旋转数组后，从中间划分，一定有一边是有序的。
            // 2. 由于一定有一边是有序的，所以根据有序的两个边界值来判断目标值在有序一边还是无序一边
            // 3. 这题找目标值，遇到目标值即返回
            // 4. 注意：由于有序的一边的边界值可能等于目标值，所以判断目标值是否在有序的那边时应该加个等号
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid; // 找到目标值，返回
            if (nums[mid] < nums[right]) { // 如果是右边单调递增的情况
                if (target > nums[mid] && target <= nums[right]) { // 如果target在(mid, right]之间
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 如果是左边单调递增的情况
                if (target >= nums[left] && target < nums[mid]) { // 如果target在[left, mid)之间
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
