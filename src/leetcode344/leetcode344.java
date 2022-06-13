package leetcode344;

public class leetcode344 {
    /**
     * 贪心思想
     * 维护两个指针，first和second，其中first永恒小于second
     * 一次遍历，如果指针位数字大于second，则返回true，
     * 如果小于second大于first，更新second为此位置，
     * 如果小于first，则更新first为此位置
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second) {
                return true;
            }else if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }
        return false;
    }
}
