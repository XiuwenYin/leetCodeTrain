package leetcode1340跳跃游戏V;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 递归 + dp
 * dp[i]表示当前能跳跃的最大次数，由MAX(dp[left], dp[right]) + 1得到
 */
public class leetcode1340 {
    int[] arr; // 写好全局变量就不用传参写那么多了
    int d;
    int[] dp;
    int n;
    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.n = arr.length;
        this.d = d;
        dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, getMax(i));
        }
        return res;
    }

    public int getMax(int idx) {
        if (dp[idx] != 0) return dp[idx]; // 去重
        int leftMax = 0, left = 1; // leftMax表示左边能达到的max跳跃次数，left表示此时跳跃多少格子
        while (idx - left >= 0 && left <= d) { // 循环不能越界，并且left不能大于最大跳跃距离
            if (arr[idx - left] >= arr[idx]) { // 如果遇到更高的柱子，break
                break;
            } else {
                if (dp[idx - left] == 0) dp[idx - left] = getMax(idx - left); // 如果idx-left未被遍历过，递归寻找
                leftMax = Math.max(leftMax, dp[idx - left]);
                left++;
            }
        }
        int rightMax = 0, right = 1;
        while (idx + right < n && right <= d) {
            if (arr[idx + right] >= arr[idx]) {
                break;
            } else {
                if (dp[idx + right] == 0) dp[idx + right] = getMax(idx + right);
                rightMax = Math.max(rightMax, dp[idx + right]);
                right++;
            }
        }
        dp[idx] = Math.max(leftMax, rightMax) + 1; // 左右取最大并加上当前的跳跃次数
        return dp[idx];
    }
}
