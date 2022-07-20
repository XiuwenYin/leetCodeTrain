package leetcode1260二维网格迁移;

import java.util.ArrayList;
import java.util.List;

public class leetcode1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int rMove = k / n, cMove = k % n;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                level.add(0);
            }
            res.add(level);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = (i * n + j + k) % (m * n);
                res.get(idx / n).set(idx % n, grid[i][j]);
            }
        }
        return res;
    }
}
