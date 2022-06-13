package leetcode1905统计子岛屿;

public class leetcode1905 {
    /**
     * dfs 叠图
     * 用图1叠上图2
     * 如果是2则是陆地，如果是0则是海洋，如果是1则说明grid1是陆地但2是海洋或者反之（这种情况取false）
     * @param grid1
     * @param grid2
     * @return
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) grid2[i][j] += grid1[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 2 && dfs(grid2, i, j)) res++;
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return true;
        }
        if (grid[i][j] != 2) {
            return grid[i][j] == 0;
        }
        grid[i][j] = 0;
        boolean down = dfs(grid, i - 1, j);
        boolean up = dfs(grid, i + 1, j);
        boolean right = dfs(grid, i, j - 1);
        boolean left = dfs(grid, i, j + 1);
        return down & up & right & left;
    }
}
