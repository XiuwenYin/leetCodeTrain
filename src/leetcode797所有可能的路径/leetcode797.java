package leetcode797所有可能的路径;

import java.util.*;

public class leetcode797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, res, new LinkedList<>(Arrays.asList(0)), 0);
        return res;
    }

    private void dfs(int[][] graph, List<List<Integer>> res, Deque<Integer> path, int x) {
        if (x == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[x]) {
            path.add(next);
            dfs(graph, res, path, next);
            path.removeLast();
        }
    }
}
