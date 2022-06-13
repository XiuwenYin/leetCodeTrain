package leetcode785判断二分图;

public class leetcode785 {
    /*
    dfs
    每次翻转颜色，判断是否相同
     */
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        // 创建查重数组
        int[] visited = new int[m];
        // 对于每个节点进行dfs，graph 中的 index 就是节点的值
        for (int i = 0; i < m; i++) {
            // 判断节点是否染色，如果未染色，则从此节点继续新一轮dfs
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int v, int color, int[] visited) {
        // 每次判断是否节点被染色，如果是的话，则判断染色是否正确
        if (visited[v] != 0) {
            return visited[v] == color;
        }
        // 染色
        visited[v] = color;
        // 对于当前节点的每一个相邻接点都进行dfs
        for (int x : graph[v]) {
            if (!dfs(graph, x, -color, visited)) {
                return false;
            }
        }
        return true;
    }
}
