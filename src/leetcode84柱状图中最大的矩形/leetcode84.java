package leetcode84柱状图中最大的矩形;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode84 {
    /**
     * 分治
     *  ！！超时，不能通过全部测试用例！！
     *  O(nlogn)
     *  O(n2)worst case
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        return calculate(heights, 0, heights.length);
    }

    private int calculate(int[] height, int start, int end) {
        int n = height.length;
        if (start > end) return 0;
        int minHeightIndex = start;
        for (int i = start; i <= end; i++) {
            if (height[minHeightIndex] > height[i]) minHeightIndex = i;
        }
        int cur = height[minHeightIndex] * (end - start + 1);
        int left = calculate(height, start, minHeightIndex - 1);
        int right = calculate(height, minHeightIndex + 1, end);
        return Math.max(cur, Math.max(left, right));
    }

    /**
     * 单调栈
     * @param heights
     * @return
     */
    public int largestRectangleArea01(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        int res = 0;
        Deque<Integer> stack = new LinkedList<>(); // 栈中压入idx
        for (int i = 0; i < n; i++) {
            // 注意这里的判断条件，当发生当前高度要低于栈顶元素高度时，就会发生如果当前元素压入栈会导致面积减小，所以开始计算当前栈内局部最大面积
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int pre = heights[stack.pop()];
                int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1); // 弹出前一位也没关系，宽度由idx计算
                res = Math.max(res, pre * width);
            }
            stack.push(i);
        }
        // 如果栈内还有元素剩余，则再次判断
        while (!stack.isEmpty()) {
            int pre = heights[stack.pop()];
            int width = heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1);
            res = Math.max(res, pre * width);
        }
        return res;
    }

}
