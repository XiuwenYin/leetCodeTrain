package leetcode221;

public class leetcoode221 {
    /**
     * dp 具体定义：dp[i + 1][j + 1] 表示 以第 i 行、第 j 列为右下角的正方形的最大边长
     * 每次当前格子都是从左、上、左上中取最小 + 1
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[m + 1][n + 1]; // dp，长度为m、n各加1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') { // 先找到1
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i][j])) + 1;
                    maxLen = Math.max(maxLen, dp[i + 1][j + 1]); // 更新最大边长
                }
            }
        }
        return maxLen * maxLen;
    }
}
