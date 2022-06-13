package leetcode1696跳跃游戏VI;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class leetcode1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{nums[0], 0});
        for (int i = 1; i < n; i++) {
            while (i - pq.peek()[1] > k) pq.remove();
            score[i] = nums[i] + score[pq.peek()[1]];
            pq.add(new int[]{score[i], i});
        }
        return score[n - 1];
    }

    public int maxResult01(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);
        for (int i = 0; i < n - 1; i++) {
            while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) q.pollLast();
            q.offerLast(i);
            dp[i + 1] = dp[q.peekFirst() + nums[i + 1]];
        }
        return dp[n - 1];
    }
}
