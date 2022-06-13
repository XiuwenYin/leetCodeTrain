package leetcode994腐烂的橘子;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode994 {
    private static final int[][] dirts = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        int cost = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) count++;
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty() && count > 0) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                for (int[] dir : dirts) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] != 0) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                        count--;
                    }

                }
            }
            cost++;
        }
        return count == 0 ? cost : -1;
    }

    /**
     * 练习
     * @param grid
     * @return
     */
    public int orangesRotting01(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int cnt = 0, cost = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) cnt++;
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty() && cnt > 0) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] temp = queue.poll();
                int i = temp[0], j = temp[1];
                for (int[] dirt : dirts) {
                    int x = i + dirt[0];
                    int y = j + dirt[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                        cnt--;
                    }
                }
            }
            cost++;
        }
        return cnt == 0 ? cost : -1;
    }


    /**
     * 练习
     * @param grid
     * @return
     */
    public int orangesRotting02(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        int count = 0, cost = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) count++;
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty() && count > 0) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] temp = q.poll();
                int i = temp[0], j = temp[1];
                for (int[] dirt : dirts) {
                    int x = i + dirt[0], y = j + dirt[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && visited[x][y] == false) {
                        count--;
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            cost++;
        }
        return count == 0 ? cost : -1;
    }















}
