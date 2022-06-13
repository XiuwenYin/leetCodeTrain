package leetcode1588;
// 所有奇数长度子数组的和a

/**
 * 前缀和
 */
public class leetcode1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        // 前缀和模板 n + 1
        int n = arr.length;
        int[] preFix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preFix[i + 1] = preFix[i] + arr[i];
        }
        int res = 0;
        // 遍历前缀和 preFix
        // 从前缀和左边开始
        for (int left = 0; left < n + 1; left++) {
            // 定义长度
            for (int length = 1; left + length <= n; length +=2) {
                int right = left + length - 1;
                // 差值等于以length位长度分割arr的子数组的和
                res += preFix[right + 1] - preFix[left];
            }
        }
        return res;
    }
}
