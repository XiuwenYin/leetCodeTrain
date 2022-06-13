package leetcode136;
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
}
