package leetcode200岛屿数量;

public class leetcode200 {
    public int numIslands(char[][] grid) {
        // 获取长度
        int m = grid.length, n = grid[0].length;
        int res = 0;
        // 遍历整个grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 对于当前格子，如果不是1，则直接下一个格子；如果是1，则对当前格子进行dfs
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    // 每次对于一个格子进行dfs结束后，岛屿数量加1
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        // 如果dfs的过程中超出了grid的边界，则退出dfs
        if (r >= m || c >= n || r < 0 || c < 0) return;
        // 如果dfs的过程中到了不是1的格子，则直接返回
        if (grid[r][c] != '1') return;

        // 将经历过的格子改为2，表示经历过这里了
        grid[r][c] = '2';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    /**
     * 并查集 union find
     */
    int[][] dirts = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands01(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        DSU dsu = new DSU(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    for (int[] dirt : dirts) {
                        int x = i + dirt[0], y = j + dirt[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            if (dsu.find(x * n + y) != dsu.find(i * n + j)) res--;
                            dsu.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }
        return res;
    }

    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
