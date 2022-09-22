package leetcode768最多能完成排序的块II;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode768 {
    /**
     * 巧妙运用单调栈
     * 保持栈从底到顶为单调递增（或从左到右单调递增，左为底）
     *
     */
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;
        int head = 0; // 用于记录当前区间最大值
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek() > arr[i]) { // 一旦遇到比顶点小的num，开始记录head
                head = stack.pop();
                while (!stack.isEmpty() && stack.peek() > arr[i]) stack.pop(); // 不断pop直到栈顶元素小于等于当前num，表示这一区间结束
                stack.push(head); // 放回当前区间的最大值head，标记为一个区间结束
            } else {
                stack.push(arr[i]);
            }
        }
        return stack.size(); // stack的大小即为分割了多少块
    }
}
