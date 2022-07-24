package leetcode120;

import java.util.ArrayList;
import java.util.List;

public class leetcode120 {
    /**
     * dp
     * 从下向上
     * 将三角形左对齐，会发现最左边这一个格子只能从 下 或者 右下 到达
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j + 1], dp[i + 1][j]) + temp.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * dp
     * 从上到下
     */
    public int minimumTotal01(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

    /**
     * 记忆化搜索
     * 最佳（最好用，推荐记住这个）
     */
    Integer[][] memo;
    public int minimumTotal02(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return dfs(triangle, 0, 0);
    }
    public int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) return 0;
        if (memo[i][j] != null) return memo[i][j];
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j + 1), dfs(triangle, i + 1, j)) + triangle.get(i).get(j);
    }
}
