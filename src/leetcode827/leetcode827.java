package leetcode827;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode827 {
    public int largestIsland(int[][] grid) {
        int res = 0;
        int maxArea = 0;
        // index为了避免重复，从2开始
        int index = 2;
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 计算岛屿面积
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfsIsland(grid, i, j, index);
                    maxArea = Math.max(res, area);
                    hashMap.put(index, area);
                    index++;
                }
            }
        }

        int plusRes = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历海洋
                if (grid[i][j] == 0) {
                    int plusArea = plusArea(grid, i, j, hashMap);
                    plusRes = Math.max(plusArea, plusRes);
                }
            }
        }
        // 如果没有海洋的话
        plusRes = Math.max(maxArea, plusRes);
        return plusRes;
    }

    private static int plusArea(int[][] grid, int r, int c, Map<Integer, Integer> map) {
        if (!isArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 0) {
            return 0;
        }
        Integer size = 0;
        //叠加面积很关键的一步，记得去重，因为海洋四周接壤的土地有可能是同一块陆地
        Set<Integer> set = new HashSet<Integer>();
        if (isArea(grid, r - 1, c) && grid[r - 1][c] >= 2) {
            set.add(grid[r - 1][c]);
        }
        if (isArea(grid, r + 1, c) && grid[r + 1][c] >= 2) {
            set.add(grid[r + 1][c]);
        }
        if (isArea(grid, r, c - 1) && grid[r][c - 1] >= 2) {
            set.add(grid[r][c - 1]);
        }
        if (isArea(grid, r, c + 1) && grid[r][c + 1] >= 2) {
            set.add(grid[r][c + 1]);
        }
        for (Integer s : set) {
            size += map.get(s);
        }
        //海洋变土地，+1
        ++size;
        return size;
    }

    private int dfsIsland(int[][] grid, int r, int c, int index) {
        if (!isArea(grid, r, c)) return 0;
        if (grid[r][c] != 1) return 0;

        grid[r][c] = index;
        return 1 +
                dfsIsland(grid, r + 1, c, index) +
                dfsIsland(grid, r - 1, c, index) +
                dfsIsland(grid, r, c + 1, index) +
                dfsIsland(grid, r, c - 1, index);
    }

    private static boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

}
