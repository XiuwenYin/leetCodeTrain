package leetcode153寻找旋转排序数组中的最小值;

public class leetcode153 {
    /**
     * 二分
     * 并非传统二分，针对题目进行了改造，不过结果和朴素二分（基本）没有区别
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) { // 不可用古城第三个板子，即 <= 不可用
            int mid = left + ((right - left) >> 1);
            // 如果右边有序，则不用找右边（因为右边单调递增，最小值必定在[left, mid]）；由于寻找最小值，所以倾向左边寻找，判断右边有序
            if (nums[mid] < nums[right]) {
                right = mid;
            } else { // 反之也一样
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
