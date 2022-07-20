package leetcode152乘积最大子数组;

import java.util.Arrays;

public class leetcode152 {
    /**
     * 动态规划
     * 但没有用到动态数组，每次取max, min就可以
     * 由于有负数参与，所以需要两个状态
     * 而且每次生成负数时需要交换max和min
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);

            res = Math.max(res, max);
        }
        return res;
    }
}
