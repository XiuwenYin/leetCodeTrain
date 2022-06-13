package leetcode1335;

import java.util.Arrays;

public class leetcode1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[n][n];
        int[][] ans = new int[d][n];
        for (int i = 0; i < d; i++) Arrays.fill(ans[i], Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j){
                    dp[i][j] = jobDifficulty[j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], jobDifficulty[j]);
                }
            }
        }
        for (int i = 0; i < n - d; i++) {
            ans[0][i] = dp[0][i];
        }

        for (int i = 1; i < d; i++) {
            for (int j = i; j < n - (d - i); j++) {
                for (int k = i - 1; k <= j - 1; k++) {
                    // <第 i-1 天分配到 k 的最小值> 加上 <第 k+1 到 j 的工作最大值>, 与 <当前最小 ans[i][j]> 相比
                    ans[i][j] = Math.min(ans[i - 1][k] + dp[k + 1][j], ans[i][j]);
                }
            }
        }
        return ans[0][n];
    }
}
