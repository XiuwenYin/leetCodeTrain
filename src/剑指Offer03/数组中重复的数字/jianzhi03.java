package 剑指Offer03.数组中重复的数字;

public class jianzhi03 {
    /**
     * 原地哈希
     */
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) return nums[i];
            swap(nums, i, nums[i]); // 只要当前位置的数字没有归位，就一直交换，直到满足上面的条件

        }
        return -1;
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
