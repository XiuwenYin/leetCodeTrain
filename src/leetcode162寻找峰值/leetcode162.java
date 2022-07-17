package leetcode162寻找峰值;

public class leetcode162 {
    /**
     * 一次遍历
     * On O1
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) { // 具体来说只要找到比左边大的数值就变成这个
                idx = i;
            }
        }
        return idx;
    }

    /**
     * 直接二分
     * @param nums
     * @return
     */
    public int findPeakElement01(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid+1]) { // 看这里，这里的目的是为了找到下降点；这个操作可以让答案不断逼近山峰，这才是这个二分的重点
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
