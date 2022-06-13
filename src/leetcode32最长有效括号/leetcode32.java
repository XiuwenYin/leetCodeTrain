package leetcode32最长有效括号;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode32 {
    /**
     * 栈辅助法
     * 官解的图示很有用
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1); // 先在栈中压入-1
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int localLen = 0;
            if (c == '(') stack.push(i); // 如果当前char为(，则直接压入栈中
            else { // 如果不是，则弹出当前栈顶元素
                stack.pop();
                if (stack.isEmpty()) { // 如果弹出后栈为空，则压入当前坐标（用于表示分割和之前的最长距离）
                    stack.push(i);
                } else { // 如果不为空，则计算当前局部最长，再和max取最大
                    /* !!重点在这!! */
                    localLen = i - stack.peek();
                    maxLen = Math.max(maxLen, localLen);
                }
            }
        }
        return maxLen;
    }
}
