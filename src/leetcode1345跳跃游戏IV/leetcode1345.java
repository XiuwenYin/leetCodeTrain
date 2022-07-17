package leetcode1345跳跃游戏IV;

import java.util.*;

public class leetcode1345 {
    final int INF = 0x3f3f3f3f;
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i++) {
            int num = arr[i];
            List<Integer> temp = map.getOrDefault(num, new ArrayList<>());
            temp.add(i);
            map.put(num, temp);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);
        dist[0] = 0;
        while (!deque.isEmpty()) {
            int temp = deque.pollFirst();
            int step = dist[temp];
            int num = arr[temp];
            if (temp == n - 1) return step;
            if (temp + 1 < n && dist[temp + 1] == INF) {
                deque.offer(temp + 1);
                dist[temp + 1] = step + 1;
            }
            if (temp - 1 >= 0 && dist[temp - 1] == INF) {
                deque.offer(temp - 1);
                dist[temp + 1] = step + 1;
            }
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            for (int x : list) {
                if (dist[x] == INF) {
                    deque.offerLast(x);
                    dist[x] = step + 1;
                }
            }
            map.remove(num);
        }
        return -1;
    }
}
