package leetcode871最低加油次数;

import java.util.PriorityQueue;

public class leetcode871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = stations.length, idx = 0;
        int remain = startFuel, loc = 0, ans = 0;
        while (loc < target) {
            if (remain == 0) {
                if (!pq.isEmpty() && ++ans >= 0) remain += pq.poll();
                else return -1;
            }
            loc += remain;
            remain = 0;
            while (idx < n && stations[idx][0] <= loc) pq.add(stations[idx++][1]);
        }
        return ans;
    }
}
