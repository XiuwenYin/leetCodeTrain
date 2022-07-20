package leetcode136只出现一次的数字;

import java.util.Arrays;

// 只出现一次的数字
public class leetcode136 {
    /**
     * 位运算：异或
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res ^= x;
        }
        return res;
    }

    /**
     * 一行异或
     * 娱乐向（太慢）
     * @param nums
     * @return
     */
    public int singleNumber01(int[] nums) {
        return Arrays.stream(nums).reduce((a, b)->a^b).getAsInt();
    }
}
