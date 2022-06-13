package leetcode239滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode239 {
    /**
     * 单调队列
     * 最经典的题目
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new ArrayDeque<>(); // queue中存储的是index；而不是nums数组中的数字
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            int startWindowIndex = i - k + 1;
            // 左出queue，如果queue非空且如果queue长度超过k，则弹出First，保证窗口大小等于k - 1
            while (!queue.isEmpty() && i - queue.peekFirst() >= k) queue.pollFirst();
            // 右出queue，保证递减队列
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) queue.pollLast();
            // 进queue，此时queue.size() == k
            queue.offerLast(i);
            if (startWindowIndex >= 0) res[startWindowIndex] = nums[queue.peekFirst()]; // 放入queue左边最大值
        }
        return res;
    }
}
