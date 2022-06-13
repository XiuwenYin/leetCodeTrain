package leetcode1438绝对差不超过限制的最长连续子数组;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode1438 {
    /**
     * 维护两个双端队列，一个最大一个最小
     * 分别放入后比较顶端，如果超过limit，就下一位并对两个队列pollFirst
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int left = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!maxd.isEmpty() && maxd.peekLast() < nums[i]) maxd.pollLast();
            while (!mind.isEmpty() && nums[i] < mind.peekLast()) mind.pollLast();
            maxd.add(nums[i]);
            mind.add(nums[i]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[left]) maxd.poll();
                if (mind.peek() == nums[left]) mind.poll();
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
