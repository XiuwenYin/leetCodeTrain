package leetcode772基本计算器III;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode772 {
    /**
     * 栈 + 递归 + 模拟
     * On On
     * @param s
     * @return
     */
    public int calculate(String s) {
        int[] result = calc(s, 0);
        return result[0];
    }

    public int[] calc(String s, int idx) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[2]; // 第0位装载的是当前结果，第1位装载的是index
        char presign = '+';
        int n = s.length();
        int num = 0;
        for (int i = idx; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                // 这一步很关键，是将从左括号下一位放入递归中，计算出括号内的结果并返回结果和idx给当前
                int[] numNext = calc(s, i + 1);
                num = numNext[0];
                i = numNext[1];
            }
            //对于末尾结束时 或 不是数字字符且字符不为'('时，对num进行处理
            if (i == n - 1 || !Character.isDigit(c) && c != '(') { // 如果当前是倒数第一位，或者是计算符号
                switch (presign) {
                    case '+': // 默认是加号，把当前数字压入stack中不会对后续结果产生影响
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                        break;
                }
                //如果结束是右括号，那么就记录位置结束循环。
                if (c == ')') {
                    result[1] = i;
                    break;
                }
                presign = c; // 将计算符号从上一位符号切换到当前的符号
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            result[0] += stack.pop();
        }
        return result;
    }
}
