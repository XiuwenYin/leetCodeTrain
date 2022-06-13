package leetcode934最短的桥;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode934 {
    /**
     * dfs+bfs
     * 先用dfs将其中一个岛全部标记为2
     * 初始化，遍历标记为1的小岛，将其边界添加到队列中
     * 再使用bfs寻找两个岛之间的最短距离
     */
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        // 标记是否找到第一个小岛了
        boolean findIsland = false;
        // 记录第一个小岛的边界
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m && !findIsland; i++) {
            for (int j = 0; j < n && !findIsland; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    mark(grid, i, j, 2, m, n, visited, q);
                    findIsland = true;
                }
            }
        }
        // 记录距离
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int x = temp[0], y = temp[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        // 如果接触到了第二个小岛，那么直接返回距离计数器 ans
                        if (grid[nx][ny] == 1) return ans;
                        else q.add(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        return ans;
    }

    /**
     * 对 grid 中的一个小岛进行标记
     */
    public void mark(int[][] grid, int r, int c, int color, int m, int n, boolean[][] visited, Queue<int[]> q) {
        grid[r][c] = color;
        // 判断是不是边界，是的话就直接放到队列中
        if (r == 0 || c == 0 ||
                r == m - 1 || c == n - 1 ||
                grid[r - 1][c] == 0 || grid[r + 1][c] == 0 ||
                grid[r][c - 1] == 0 || grid[r][c + 1] == 0) {
            q.add(new int[]{r, c});
        }
        for (int[] dir : dirs) {
            int nx = r + dir[0], ny = c + dir[1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && grid[nx][ny] == 1) {
                visited[nx][ny] = true;
                mark(grid, nx, ny, color, m, n, visited, q);
            }
        }
    }
}

