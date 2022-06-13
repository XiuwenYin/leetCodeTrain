package leetcode296最佳的碰头地点;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode296 {
    /**
     * 排序法
     * 时间复杂度： O(mn \log mn)O(mnlogmn) 。
     * 最多会有 m \times nm×n 个点，因此排序所需的时间是 O(mn \log mn)O(mnlogmn) 。
     * 空间复杂度： O(mn)O(mn) 。
     *
     * @param grid
     * @return
     */
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        int row = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);
        return minDist1D(rows, row) + minDist1D(cols, col);
    }

    private int minDist1D(List<Integer> list, int origin) {
        int dist = 0;
        for (int x : list) {
            dist += Math.abs(x - origin);
        }
        return dist;
    }

    /**
     * 双指针法
     * 但实际上也是排序
     * 按顺序收集坐标
     *
     * @param grid
     * @return
     */
    public int minTotalDistance01(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        return minDistance1D(rows) + minDistance1D(cols);
    }

    private int minDistance1D(List<Integer> points) {
        int distance = 0;
        int i = 0;
        int j = points.size() - 1;
        while (i < j) {
            distance += points.get(j) - points.get(i);
            i++;
            j--;
        }
        return distance;
    }

    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }
        return rows;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        return cols;
    }
}
