package leetcode224基本计算器;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode224 {
    /**
     * 栈模拟
     * 遇到括号的情况将res和sign都压入
     * 比较容易理解
     */
    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1, res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                // 如果当前数字的下一位仍然是数字，那么就把当前数字 * 10 并上下一位的数字
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) cur = cur * 10 + s.charAt(++i) - '0';
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
