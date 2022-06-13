package leetcode695;

import java.time.LocalDateTime;

public class leetcode695 {
    int res = Integer.MIN_VALUE;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n) return 0;
        if (grid[r][c] != 1) return 0;

        grid[r][c] = 2;
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
}
