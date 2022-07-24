package leetcode402移掉K位数字;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            //不等于0可以添加进去,
            //等于0，栈不为空可以填进去，
            if (c != '0' || !stack.isEmpty()) {
                stack.push(c);
            }
        }
        //123456这种情况，前面一直比后面小，那就去除栈顶，谁让栈顶最大
        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }
        if (stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        //从后往前添加所以我们要逆序
        return sb.reverse().toString();
    }


    /**
     * 最快，最省空间
     */
    public String removeKdigits01(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        int n = num.length();
        int remain = n - k;
        int top = -1;
        char[] res = new char[n];
        for (char c : num.toCharArray()) {
            while (k > 0 && top >= 0 && c < res[top]) {
                top--;
                k--;
            }
            top++;
            res[top] = c;
        }
        int j = 0;
        while (j < remain - 1 && res[j] == '0') j++;
        return new String(res, j, remain - j);
    }
}
