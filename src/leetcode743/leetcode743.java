package leetcode743;

import java.util.Arrays;

public class leetcode743 {
    int N = 110, M = 6010;
    // dist[x] = y 表示从 起点 出发到 x 的最短距离为y
    int[] dist = new int[N];
    // 邻接矩阵数组：w[u][v] = c 表示从u到v有权重为c的边
    int[][] w = new int[N][N];
    boolean[] visited = new boolean[N];
    int INF = Integer.MAX_VALUE / 2;
    int n, k;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.n = n;
        this.k = k;
        // 初始化邻接矩阵
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        // 存图
        for (int[] t : times) {
            int u = t[0], v = t[1], c = t[2];
            // 从 u 到 v 要消耗 c 的时间
            w[u][v] = c;
        }
        dijkstra();
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res > INF ? -1 : res;

    }

    private void dijkstra() {
        // 将访问填充为都未访问过，所有距离填充为无限距离
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
        // 起点的最短距离是0
        dist[k] = 0;
        // 对于 n个节点迭代N 次
        for (int s = 0; s < n; s++) {
            // 每次找到「最短距离最小」且「未被更新」的点 t
            int t = -1;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && (t == -1 || dist[i] < dist[t])) {
                    t = i;
                }
            }
            visited[t] = true;
            // 用点 t 的「最小距离」更新其他点
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
            }
        }

    }

}
