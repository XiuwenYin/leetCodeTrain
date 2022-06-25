package leetcode490迷宫;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode490 {
    int[][] dirts = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true; // 一般来说判断条件放在 出queue的地方就可以
            for (int[] dirt : dirts) {
                int x = cur[0] + dirt[0];
                int y = cur[1] + dirt[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) { // 如果不出界并且是能走的方框，就继续走下去走到头
                    x += dirt[0];
                    y += dirt[1];
                }
                // 这里 x和y各退一步，因为此时已经在非法的格子上了，所以才退出循环
                x -= dirt[0];
                y -= dirt[1];
                if (!visited[x][y]) {
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

    public boolean hasPath01(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        if (maze[start[0]][start[1]] == 0) {
            q.offer(new int[]{start[0], start[1]});
        } else {
            return false;
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (Arrays.equals(cur, destination)) return true;
            for (int[] dirt : dirts) {
                int x = cur[0] + dirt[0];
                int y = cur[1] + dirt[1];
                while (x >= 0 && x < m && y >=0 && y < n && maze[x][y] != 1) {
                    x += dirt[0];
                    y += dirt[1];
                }
                x -= dirt[0];
                y -= dirt[1];
                if (!visited[x][y]) {
                    q.offer(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

}
