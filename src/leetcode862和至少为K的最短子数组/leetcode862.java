package leetcode862和至少为K的最短子数组;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode862 {
    /**
     * 前缀和 + 单调队列（滑动窗口样式）
     *
     * @param nums
     * @param k
     * @return
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = n + 1;
        long[] sum = new long[n + 1]; // 极端测试用例通过要用long[]而不是int[]
        for (int i = 0; i < n; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            // 左出queue，统计窗口大小（并不是真正的大小）
            while (!queue.isEmpty() && sum[i] - sum[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst()); // 取解；当前位置i 到queue头部的距离和res取最小
            }
            // 右出queue，保证递增队列
            while (!queue.isEmpty() && sum[queue.peekLast()] >= sum[i]) {
                queue.pollLast();
            }
            queue.offerLast(i); // 进queue
        }
        return res <= n ? res : -1;
    }


    /**
     * 练习
     *
     * @param nums
     * @param k
     * @return
     */
    public int shortestSubarray01(int[] nums, int k) {
        int n = nums.length;
        int res = n + 1;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = nums[i] + sum[i];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            // 左出
            while (!q.isEmpty() && sum[i] - sum[q.peekFirst()] >= k) res = Math.min(res, i - q.pollFirst());
            // 右出
            while (!q.isEmpty() && sum[q.peekLast()] >= sum[i]) q.pollLast();
            q.offerLast(i); // 进queue
        }
        return res <= n ? res : -1;
    }
}
