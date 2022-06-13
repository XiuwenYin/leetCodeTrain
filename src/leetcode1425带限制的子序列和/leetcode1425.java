package leetcode1425带限制的子序列和;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] sum = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            if (!deque.isEmpty()) {
                sum[i] += sum[deque.peekFirst()];
            }
            res = Math.max(res, sum[i]); // 取解

            // 左出q
            if (!deque.isEmpty() && i - deque.peek() >= k) {
                deque.pollFirst();
            }

            // 右出q
            while (!deque.isEmpty() && sum[deque.peekLast()] <= sum[i]) {
                deque.pollLast();
            }

            // 进q
            if (sum[i] > 0) {
                deque.offerLast(i);
            }
        }
        return res;
    }
}
