package leetcode542_01矩阵;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode542 {
    int[][] dirts = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    List<Integer> x = new ArrayList<>();
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) { // 先找到0的格子，放入q中，全部标记为visited
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int cost = 0; // 定义cost，0的格子自然为0；然后每层找1的格子，cost增加1并放入res
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] temp = queue.poll();
                int x = temp[0], y = temp[1];
                if (matrix[x][y] == 1) {
                    res[x][y] = cost;
                }
                for (int[] dirt : dirts) {
                    int nx = x + dirt[0], ny = y + dirt[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            cost++;
        }
        return res;
    }
}
