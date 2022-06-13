package leetcode286墙与门;

import java.util.ArrayDeque;
import java.util.Queue;

public class leetcode286 {
    private int[][] dirts = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int INF = 2147483647;

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] dirt : dirts) {
                int r = row + dirt[0];
                int c = col + dirt[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != INF) {
                    continue;
                }
                // 精髓：对所有门同时加入队列，每次bfs同时都走了1步，先到达的就是距离短的
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[]{r, c});
            }
        }
    }
}