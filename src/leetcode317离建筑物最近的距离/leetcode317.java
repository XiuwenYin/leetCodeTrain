package leetcode317离建筑物最近的距离;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode317 {
    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    // 思路：
    //  (1) 从每一个建筑物开始进行广度优先搜索
    //  (2) 在搜索的同时计算每一个空格到这个建筑物的距离
    //  (3) 在搜索的同时将每一个空格到每一个建筑物的距离进行累加，得到每个空格到所有建筑物的距离
    //  (4) 取空格到所有建筑物的最小距离
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;

        int[][] totalDist = new int[m][n];
        int res = Integer.MAX_VALUE;
        // 用于标记空地
        int mark = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // (1) 从每一个建筑物开始进行广度优先搜索
                if (grid[i][j] == 1) {
                    res = bfs(grid, m, n, i, j, mark, totalDist);
                    // 每次遍历搜索完一个建筑物，这个标记减一，表示所有空地被遍历一次了
                    mark--;
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int m, int n, int i, int j, int mark, int[][] totalDist) {
        int res = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        // 队列中每个数组有 3 个元素，分别表示：
        // 第一个元素和第二个元素表示坐标值
        // 第三个元素表示当前坐标到建筑物的距离
        // 第三个元素的初始值为 0 的原因是：一开始的时候从当前建筑物到当前建筑物的距离是 0
        queue.add(new int[]{i, j, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currDist = curr[2];
            for (int[] dir : dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == mark) {
                    // (2) 在搜索的同时计算每一个空格到这个建筑物的距离
                    int dist = currDist + 1;
                    // (3) 在搜索的同时将每一个空格到每一个建筑物的距离进行累加
                    totalDist[row][col] += dist;
                    // (4) 取空格到所有建筑物的最小距离
                    res = Math.min(res, totalDist[row][col]);

                    queue.add(new int[]{row, col, dist});
                    // 和 mark 标识对应
                    grid[row][col]--;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    /**
     * 练习
     */
    public int shortestDistance01(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] tolalDist = new int[m][n];
        int mark = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = bfs01(grid, i, j, mark, tolalDist);
                    mark--;
                }
            }
        }
        return res;
    }

    private int bfs01(int[][] grid, int r, int c, int mark, int[][] totalDist) {
        int m = grid.length, n = grid[0].length;
        int res = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curDist = cur[2];
            a : for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != mark) continue a;
                int dist = curDist + 1;
                totalDist[nx][ny] += dist;
                res = Math.min(res, totalDist[nx][ny]);
                q.offer(new int[]{nx, ny, dist});
                grid[nx][ny]--;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
