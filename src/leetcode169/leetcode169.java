package leetcode169;
// 多数元素
public class leetcode169 {
    /**
     * 投票法
     * 每次遇到了相同的数字就把票数+1，不同就-1，直到0就换成下一个数字
     * 最优
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int x : nums) {
            if (count == 0) candidate = x;
            count += (candidate == x) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * 分治
     * @param nums
     * @return
     */
    public int majorityElement01(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        int leftRes = divide(nums, left, mid);
        int rightRes = divide(nums, mid + 1, right);
        if (leftRes == rightRes) return leftRes;
        int leftCount = conquer(nums, leftRes, left, right);
        int rightCount = conquer(nums, rightRes, left, right);
        return leftCount > rightCount ? leftRes : rightRes;
    }

    private int conquer(int nums[], int target, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) count++;
        }
        return count;
    }
}
