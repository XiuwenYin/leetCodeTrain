package leetcode873最长的斐波那契子序列的长度;

import java.util.HashMap;
import java.util.Map;

public class leetcode873 {
    /**
     * 动态规划 + 哈希表
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        /* 二维动态数组，一维不够存储足量的情况；dp[i][j]表示 arr[i] 为斐波那契数列的最后一位，
         使用 arr[j] 为倒数第二位（即 arr[i] 的前一位）时的最长数列长度*/
        int[][] dp = new int[n][n];
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arr[i], i); // 用哈希表，存储 arr的value映射所在的index（arr是不重复单调递增数组）
        for (int i = 2; i < n; i++) { // 从2起
            for (int j = i - 1; j > 0; j--) { // j从i的前一位往左走
                int val = arr[i] - arr[j]; // 求差值，用于验证是否存在于map中
                if (map.containsKey(val)) { // 如果存在，则获取idx
                    int idx = map.get(val);
                    if (idx < j) { // 如果idx大于j，则重复了，所以剪枝不考虑；
                        dp[i][j] = Math.max(dp[j][idx] + 1, dp[i][j]);
                        res = Math.max(dp[i][j] + 2, res);
                    }
                }
            }
        }
        return res;
    }
}
