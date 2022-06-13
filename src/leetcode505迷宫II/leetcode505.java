package leetcode505迷宫II;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode505 {
    int[][] dirts = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] dist : distance) Arrays.fill(dist, Integer.MAX_VALUE); // 先填充满 MAX_VALUE

        distance[start[0]][start[1]] = 0; // 初始化起点距离为0
        dijkstra(maze, start, distance);
        int res = distance[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res; // 如果仍然为 MAX_VALUE说明到达不了返回-1
    }

    private void dijkstra(int[][] maze, int[] start, int[][] distance) {
        int m = maze.length, n = maze[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 按照距离小顶堆
        heap.offer(new int[]{start[0], start[1], 0}); // 放入 x，y，距离
        while (!heap.isEmpty()) { // 一般bfs模板
            int[] cur = heap.poll();
            for (int[] dirt : dirts) {
                int x = cur[0] + dirt[0];
                int y = cur[1] + dirt[1];
                int count = 0;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dirt[0];
                    y += dirt[1];
                    count++; // 每走一格就增加一次count
                }
                x -= dirt[0]; // 和490题一样退出循环后需要往回走一格，不然就在非法格子上
                y -= dirt[1];
                if (distance[cur[0]][cur[1]] + count < distance[x][y]) { // 更新distance，一开始的值是MAX_VALUE
                    distance[x][y] = distance[cur[0]][cur[1]] + count;
                    heap.offer(new int[]{x, y, distance[x][y]}); // 加入heap
                }
            }
        }
    }
}
