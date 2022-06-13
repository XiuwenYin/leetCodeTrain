package leetcode1926迷宫中离入口最近的出口;

import java.util.ArrayDeque;
import java.util.Queue;

public class leetcode1926 {
    private static final int[][] dirts = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});
//        int step = 0;
        maze[entrance[0]][entrance[1]] = '+';
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0], y = temp[1], step = temp[2];
            if (!(x == entrance[0] && y == entrance[1]) && (x == 0 || x == m - 1 || y == 0 || y == n - 1) ) return step;
            for (int[] dirt : dirts) {
                int nx = temp[0] + dirt[0];
                int ny = temp[1] + dirt[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || maze[nx][ny] == '+') continue;
                q.offer(new int[]{nx, ny, step + 1});
                maze[nx][ny] = '+';
            }
//            step++;
        }
        return -1;
    }
}
