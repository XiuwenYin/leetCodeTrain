package leetcode332;

import java.util.*;

public class leetcode332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> edge : tickets) {
            // 如果有没有这个key，则创建一个新的优先队列并存放数据
            map.computeIfAbsent(edge.get(0), k -> new PriorityQueue<>()).offer(edge.get(1));
        }
        List<String> res = new ArrayList<>();
        dfs(res, map, "JFK");

        return res;
    }

    private void dfs(List<String> res, Map<String, PriorityQueue<String>> map, String cur) {
        // 代表cur当前飞的全部目的地，如果没有飞出去的飞机，直接添加空优先队列
        PriorityQueue<String> neigh = map.getOrDefault(cur, new PriorityQueue<>());
        while (!neigh.isEmpty()) {
            dfs(res, map, neigh.poll()); // 拉出neighbor中的一个再次进行dfs
        }
        res.add(0, cur); // 0 表示添加在最前面
    }

}
