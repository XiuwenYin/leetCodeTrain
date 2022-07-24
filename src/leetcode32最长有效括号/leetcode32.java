package leetcode32最长有效括号;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode32 {
    /**
     * 栈辅助法
     * 官解的图示很有用
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1); // 先在栈中压入-1
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int local = 0;
            if (c == '(') stack.push(i); // 如果当前char为(，则直接压入栈中
            else { // 如果不是，则弹出当前栈顶元素
                stack.pop();
                if (stack.isEmpty()) { // 如果弹出后栈为空，则压入当前坐标（用于表示分割和之前的最长距离）
                    stack.push(i);
                } else { // 如果不为空，则计算当前局部最长，再和max取最大
                    /* !!重点在这!! */
                    local = i - stack.peek();
                    max = Math.max(max, local);
                }
            }
        }
        return max;
    }

    /**
     * 辅助计数
     * 不使用额外空间
     *
     * 在此方法中，我们利用两个计数器 left 和 right 。
     * 首先，我们从左到右遍历字符串，对于遇到的每个 ‘(’，我们增加 left 计数器，
     * 对于遇到的每个 )’ ，我们增加 right 计数器。
     * 每当 left 计数器与 right 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。
     * 当 right 计数器比 left 计数器大时，我们将 left 和 right 计数器同时变回 0。
     *
     * 这样的做法贪心地考虑了以当前字符下标结尾的有效括号长度，
     * 每次当右括号数量多于左括号数量的时候之前的字符我们都扔掉不再考虑，重新从下一个字符开始计算，
     * 但这样会漏掉一种情况，就是遍历的时候左括号的数量始终大于右括号的数量，即 (() ，这种时候最长有效括号是求不出来的。
     *
     * 解决的方法也很简单，我们只需要从右往左遍历用类似的方法计算即可，只是这个时候判断条件反了过来：
     * 当 left 计数器比 ight 计数器大时，我们将 left 和 right 计数器同时变回 0
     * 当 left 计数器与 right 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串
     *
     * 比较简单
     */
    public int longestValidParentheses01(String s) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
}
