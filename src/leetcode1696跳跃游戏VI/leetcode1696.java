package leetcode1696跳跃游戏VI;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class leetcode1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n]; // 这个score本质就是个dp[]
        score[0] = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // 对分数进行降序排列
        pq.add(new int[]{score[0], 0});
        for (int i = 1; i < n; i++) {
            while (i - pq.peek()[1] > k) pq.poll(); // 用while弹出所有越界的
            score[i] = nums[i] + score[pq.peek()[1]];
            pq.offer(new int[]{score[i], i});
        }
        return score[n - 1];
    }

    // 有问题
//    public int maxResult01(int[] nums, int k) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        Deque<Integer> q = new ArrayDeque<>();
//        q.offerLast(0);
//        for (int i = 0; i < n - 1; i++) {
//            while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst(); // 越界 弹左
//            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) q.pollLast(); // monotonic属性
//            q.offerLast(i);
//            dp[i + 1] = dp[q.peekFirst() + nums[i + 1]];
//        }
//        return dp[n - 1];
//    }
}
