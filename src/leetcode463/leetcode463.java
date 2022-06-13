package leetcode463;

public class leetcode463 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int dis = dfs(grid, i, j);
                return dis;
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (!isArea(grid, r, c)) return 1;
        if (grid[r][c] == 0) return 1;
        if (grid[r][c] != 1) return 0;

        grid[r][c] = 2;
        return dfs(grid, r + 1, c) +
                dfs(grid, r - 1, c) +
                dfs(grid, r, c + 1) +
                dfs(grid, r, c - 1);
    }

    private boolean isArea(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
