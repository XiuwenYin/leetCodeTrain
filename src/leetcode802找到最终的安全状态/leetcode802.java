package leetcode802找到最终的安全状态;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class leetcode802 {
    /**
     * 拓扑排序
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> rev = new ArrayList<>();
        int[] inDegree = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) rev.add(new ArrayList<Integer>());

        for (int i = 0; i < n; ++i) {
            for (int j : graph[i]) rev.get(j).add(i);
            inDegree[i] = graph[i].length;
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int x : rev.get(temp)) {
                if (--inDegree[x] == 0) q.offer(x);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }


    /**
     * dfs + 剪枝
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes01(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] visited = new int[n]; // 0表示未访问过，1表示访问中，2表示是安全点
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, visited)) res.add(i);
        }
        return res;
    }
    private boolean dfs(int[][] graph, int idx, int[] visited) {
        // 不是0，说明被访问过，判断是否为2，判断是否在环内
        if (visited[idx] != 0) return visited[idx] == 2;

        visited[idx] = 1;
        for (int x : graph[idx]) {
            // DFS过程中再次遇到相同的节点，说明有环，即为不安全，直接返回false
            if (!dfs(graph, x, visited)) return false;
        }
        // 下游节点全部遍历完成，都是安全的，说明当前节点安全，返回true
        visited[idx] = 2;
        return true;
    }

}
