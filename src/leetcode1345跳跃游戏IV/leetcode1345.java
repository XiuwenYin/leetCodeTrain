package leetcode1345跳跃游戏IV;

import java.util.*;

public class leetcode1345 {
    int INF = 0x3f3f3f3f;
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 倒序插入 list，相当于给 deque 增加一个同层「下标越大，优先出队」的作用
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        dist[0] = 0;
        while (!deque.isEmpty()) {
            int t = deque.pollFirst(), step = dist[t];
            if (t == n - 1) return step;
            if (t + 1 < n && dist[t + 1] == INF) {
                deque.addLast(t + 1);
                dist[t + 1] = step + 1;
            }
            if (t - 1 >= 0 && dist[t - 1] == INF) {
                deque.addLast(t - 1);
                dist[t - 1] = step + 1;
            }
            List<Integer> list = map.getOrDefault(arr[t], new ArrayList<>());
            for (int ne : list) {
                if (dist[ne] == INF) {
                    deque.addLast(ne);
                    dist[ne] = step + 1;
                }
            }
            map.remove(arr[t]); // 重点，剪枝，能够移除多余的部分防止重复遍历
        }
        return -1; // never
    }
}
