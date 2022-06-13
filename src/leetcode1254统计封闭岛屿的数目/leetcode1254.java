package leetcode1254统计封闭岛屿的数目;


public class leetcode1254 {

    private int val;

    public int closedIsland(int[][] grid) {
        int closedLandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    val = 1;
                    dfs(grid, i, j);
                    closedLandNum += val;
                }
            }
        }
        return closedLandNum;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            val = 0;
            return;
        }
        if (grid[i][j] != 0) return;
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
