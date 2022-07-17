package 周赛;

public class leetcode6034 {
    int res;
    public int triangularSum(int[] nums) {
        int m = nums.length;
        if (m == 1) return nums[0];
        getOne(nums);
        return res;
    }

    private void getOne(int[] nums) {
        if (nums.length == 0) return;

        int[] temp = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i] + nums[i + 1];
            if (num >= 10) {
                num %= 10;
            }
            temp[i] = num;
            res = temp[0];
        }
        getOne(temp);
    }
}
