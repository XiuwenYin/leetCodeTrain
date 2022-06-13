package leetcode873;

import java.util.HashMap;
import java.util.Map;

public class leetcode873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int res = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], i);
        }

        for (int k = 2; k < n; k++) {
            for (int j = k - 1; j > 0; j--) {
                int iValue = arr[k] - arr[j];
                if (hashMap.containsKey(iValue)) {
                    int i = hashMap.get(iValue);
                    if (i < j) {
                        dp[j][k] = Math.max(dp[i][j] + 1, dp[j][k]);
                        res = Math.max(dp[j][k] + 2, res);
                    }
                }
            }
        }
        return res;
    }
}
