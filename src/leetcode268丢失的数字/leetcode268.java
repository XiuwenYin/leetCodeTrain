package leetcode268丢失的数字;

public class leetcode268 {
    /**
     * 异或
     * On O1
     * 朴素遍历也可以，但会慢
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) ans ^= i;
        for (int i : nums) ans ^= i;
        return ans;
    }
}
