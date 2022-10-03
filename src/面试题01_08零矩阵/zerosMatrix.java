package 面试题01_08零矩阵;

import java.util.ArrayDeque;
import java.util.Queue;

public class zerosMatrix {
    /**
     * 朴素bfs
     */
    int[][] dirts = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            int[] temp = q.poll();
            int x = temp[0], y = temp[1];
            for (int[] dirt : dirts) {
                int nx = x + dirt[0], ny = y + dirt[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    matrix[nx][ny] = 0;
                    nx += dirt[0];
                    ny += dirt[1];
                }
            }
        }
    }


    /**
     * 标记行列法
     *
     * @param matrix
     */
    public void setZeroes01(int[][] matrix) {
        //标记行列法
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        //处理标记为true的数据
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
