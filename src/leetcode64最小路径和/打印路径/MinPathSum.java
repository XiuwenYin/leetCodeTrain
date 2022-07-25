package leetcode64最小路径和.打印路径;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPathSum minPathSum = new MinPathSum();
        minPathSum.minPathSumPrintPath(grid);
    }

    public int minPathSumPrintPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] path = new int[m * n][2];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            savePath(path, i, 0, n, i - 1, 0);
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
            savePath(path, 0, j, n, 0, j - 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    savePath(path, i, j, n, i - 1, j);
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    savePath(path, i, j, n, i, j - 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int x = m - 1, y = n - 1;
        sb.append("(").append(x).append(",").append(y).append(")");
        while (x != 0 || y != 0) {
            int idx = x * n + y;
            x = path[idx][0];
            y = path[idx][1];
            sb.append("->").append("(").append(x).append(",").append(y).append(")");
        }
        System.out.println(sb.toString());
        return dp[m - 1][n - 1];
    }

    public void savePath(int[][] path, int r,  int c, int n, int x, int y) {
        int idx = r * n + c; // 用每次传过来的r和c计算是总共的第几个位置
        path[idx][0] = x;
        path[idx][1] = y;
    }
}
