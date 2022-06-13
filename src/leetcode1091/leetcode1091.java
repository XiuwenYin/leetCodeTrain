package leetcode1091;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode1091 {
    int[][] dirts = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
//        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int cost = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) return cost;
                for (int[] dirt : dirts) {
                    int nr = cur[0] + dirt[0];
                    int nc = cur[1] + dirt[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 0) {
                        continue;
                    }

                    grid[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
            cost++;
        }
        return-1;
    }

    /**
     * 练习
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix01(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        Queue<int[]> q = new ArrayDeque<>();
//        boolean[][] visited = new boolean[m][n];
        int step = 0;
        q.offer(new int[]{0, 0});
//        visited[0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] temp = q.poll();
                if (temp[0] == m - 1 && temp[1] == n - 1) return step;
                for (int[] dirt : dirts) {
                    int nx = temp[0] + dirt[0], ny = temp[1] + dirt[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0) continue;
                    grid[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
            step++;
        }
        return -1;
    }

}

