package leetcode64最小路径和;

public class leetcode64 {
    public int minPathSum(int[][] grid) {
        /**
         * 动态规划
         * 经典左上到右下找最大/最小
         * 朴素dp，可简化为一维dp
         */
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n]; // 定义二维dp数组
        dp[0][0] = grid[0][0]; // 赋初始值，即左上角格子的值
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0]; // 先对row进行遍历赋值，即第一列（idx为0的列）
        for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j]; // 再对col进行遍历赋值，即第一行（idx为0的行）
        for (int i = 1; i < m; i++) { // 双重遍历，每次取最小的dp加上本次的格子的值
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1]; // 最终返回即为最小
    }

    /**
     * 空间压缩dp
     * 根据公式 dp[i][j] = dp[i-1][j] + dp[i][j-1]，我们可以知道，当我们要计算第 i 行的值时，除了会用到第 i - 1 行外，
     * 其他第 1 至 第 i-2 行的值我们都是不需要用到的，也就是说，对于那部分用不到的值我们还有必要保存他们吗？
     * 答是没必要，我们只需要用一个一维的 dp[] 来保存一行的历史记录就可以了。然后在计算机的过程中，不断着更新 dp[] 的值 （来自知乎帅地）
     * @param grid
     * @return
     */
    public int minPathSum01(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) dp[j] = dp[j - 1] + grid[0][j];
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
            }
        }
        return dp[n - 1];
    }
}
