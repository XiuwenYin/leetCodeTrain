package leetcode1345跳跃游戏IV;

import java.util.*;


/**
 * bfs
 */
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
            /* 每次while有三步，
            1. 找temp +- 1：检查越界、temp + 1位是没遍历过得，加入deque、修改dist[temp + 1]的值为当前步数 + 1
            2. 对当前temp拉扯map中的val(list)，看看是否还有更远的相同的值，如果有且未遍历过，则加入deque并修改dist位置的值
            3. 对map剪枝 */
            int temp = deque.pollFirst(), step = dist[temp];
            if (temp == n - 1) return step;
            if (temp + 1 < n && dist[temp + 1] == INF) {
                deque.addLast(temp + 1);
                dist[temp + 1] = step + 1;
            }
            if (temp - 1 >= 0 && dist[temp - 1] == INF) {
                deque.addLast(temp - 1);
                dist[temp - 1] = step + 1;
            }
            List<Integer> list = map.getOrDefault(arr[temp], new ArrayList<>());
            for (int ne : list) {
                if (dist[ne] == INF) {
                    deque.addLast(ne);
                    dist[ne] = step + 1;
                }
            }
            map.remove(arr[temp]); // 重点，剪枝，能够移除多余的部分防止重复遍历
        }
        return -1; // never
    }
}
