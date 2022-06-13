package leetcode675为高尔夫比赛砍树;

import java.util.*;

public class leetcode675 {
    // 四个方向
    int[][] dirts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * bfs
     * 本题中，0代表障碍，不可越过
     *
     * @param forest
     * @return
     */
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> tree = new ArrayList<>();
        int row = forest.size();
        int col = forest.get(0).size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1) tree.add(new int[]{i, j});
            }
        }
        // 将树从小到大排序
        Collections.sort(tree, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));

        // 从坐标(0, 0)开始进行bfs
        int cx = 0, cy = 0, ans = 0;
        for (int i = 0; i < tree.size(); i++) {
            int steps = bfs(forest, cx, cy, tree.get(i)[0], tree.get(i)[1]);
            if (steps == -1) return -1;
            ans += steps;
            cx = tree.get(i)[0];
            cy = tree.get(i)[1];
        }
        return ans;
    }

    private int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return 0;

        int row = forest.size();
        int col = forest.get(0).size();
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int cx = cell[0], cy = cell[1];
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dirts[j][0];
                    int ny = cy + dirts[j][1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                            if (nx == tx && ny == ty) return step;
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }


    /**
     * dijkstra's 算法
     *
     * @param forest
     * @return
     */
    public int cutOffTree01(List<List<Integer>> forest) {
        List<int[]> tree = new ArrayList<>();
        int row = forest.size(), col = forest.get(0).size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1) tree.add(new int[]{i, j});
            }
        }
        Collections.sort(tree, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));

        int cx = 0, cy = 0, ans = 0;
        for (int i = 0; i < tree.size(); i++) {
            int step = dijkstra(forest, cx, cy, tree.get(i)[0], tree.get(i)[1]);
            if (step == -1) return -1;
            ans += step;
            cx = tree.get(i)[0];
            cy = tree.get(i)[1];
        }
        return ans;
    }

    private int dijkstra(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return 0;

        int row = forest.size(), col = forest.get(0).size();
        // 每次对队列中优先选择最短路径的元素
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[row][col];
        pq.offer(new int[]{0, sx * col + sy}); // x * col + y：用一个数字存储坐标
        visited[sx][sy] = true;

        while (!pq.isEmpty()) {
            // 每次从队列中取出当前从起点开始的最少步数的点
            int[] arr = pq.poll();
            int dist = arr[0];
            int loc = arr[1];
            // 对于下一个要处理的每个节点，查看他们的四个方向上相邻的点，如果相邻的点没有被遍历过且不是障碍，将其加入到队列中，直到找到终点为止
            for (int j = 0; j < 4; j++) {
                int nx = loc / col + dirts[j][0];
                int ny = loc % col + dirts[j][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                        if (nx == tx && ny == ty) return dist + 1;
                        pq.offer(new int[]{dist + 1, nx * col + ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }


    /**
     * A* 启发式搜索算法
     *
     * @param forest
     * @return
     */
    public int cutOffTree02(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<int[]>();
        int row = forest.size();
        int col = forest.get(0).size();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));

        int cx = 0;
        int cy = 0;
        int ans = 0;
        for (int i = 0; i < trees.size(); ++i) {
            int steps = aStar(forest, cx, cy, trees.get(i)[0], trees.get(i)[1]);
            if (steps == -1) {
                return -1;
            }
            ans += steps;
            cx = trees.get(i)[0];
            cy = trees.get(i)[1];
        }
        return ans;
    }

    public int aStar(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }

        int row = forest.size();
        int col = forest.get(0).size();
        int[][] costed = new int[row][col];
        for (int i = 0; i < row; ++i) {
            Arrays.fill(costed[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        costed[sx][sy] = Math.abs(sx - tx) + Math.abs(sy - ty);
        pq.offer(new int[]{costed[sx][sy], 0, sx * col + sy});

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int cost = arr[0], dist = arr[1], loc = arr[2];
            int cx = loc / col;
            int cy = loc % col;
            if (cx == tx && cy == ty) {
                return dist;
            }
            for (int i = 0; i < 4; ++i) {
                int nx = cx + dirts[i][0];
                int ny = cy + dirts[i][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && forest.get(nx).get(ny) > 0) {
                    int ncost = dist + 1 + Math.abs(nx - tx) + Math.abs(ny - ty);
                    if (ncost < costed[nx][ny]) {
                        pq.offer(new int[]{ncost, dist + 1, nx * col + ny});
                        costed[nx][ny] = ncost;
                    }
                }
            }
        }
        return -1;
    }
}
