package leetcode120;

import java.util.ArrayList;
import java.util.List;

public class leetcode120 {
    /*
    dp
    从下向上
    将三角形左对齐，会发现最左边这一个格子只能从 下 或者 右下 到达
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j + 1], dp[i + 1][j]) + temp.get(j);
            }
        }
        return dp[0][0];
    }
}
