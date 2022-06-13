package leetcode1162地图分析;

import java.util.ArrayDeque;
import java.util.Queue;

public class leetcode1162 {
    private int[][] dirts = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * bfs
     * 每一次while循环的时候在之前的基础上+1
     * temp放在循环外用于最后取答案时
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) q.offer(new int[]{i, j});
            }
        }
        boolean isOcean = false;
        int[] temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            int x = temp[0], y = temp[1];
            for (int[] dirt : dirts) {
                int nx = x + dirt[0], ny = y + dirt[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0) continue;
                grid[nx][ny] = grid[x][y] + 1;
                isOcean = true;
                q.offer(new int[]{nx, ny});
            }
        }
        if (temp == null || !isOcean) return -1;
        return grid[temp[0]][temp[1]] - 1;
    }
}
