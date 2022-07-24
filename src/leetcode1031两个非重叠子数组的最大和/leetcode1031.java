package leetcode1031两个非重叠子数组的最大和;

public class leetcode1031 {
    /**
     * 前缀和 + 滑动窗口
     * 在前缀和上滑动找寻最大
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] preFix = new int[nums.length];
        preFix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preFix[i] = nums[i] + preFix[i - 1]; // 构建等长前缀和数组
        }
        int res = preFix[firstLen + secondLen - 1]; // 取出在len1 + len2 - 1位置的和
        int max1 = preFix[firstLen - 1];
        int max2 = preFix[secondLen - 1];
        for (int i = firstLen + secondLen; i < n; i++) {
            // 分别以first在前second在后，second在前first在后两种方式，滑动窗口，每次移动一格。
            max1 = Math.max(max1, preFix[i - secondLen] - preFix[i - secondLen - firstLen]);
            max2 = Math.max(max2, preFix[i - firstLen] - preFix[i - firstLen - secondLen]);

            //                            前面是 first + 当前的 second                前面是 second + 当前的 first
            res = Math.max(res, Math.max(max1 + preFix[i] - preFix[i - secondLen], max2 + preFix[i] - preFix[i - firstLen]));
        }
        return res;
    }
}
