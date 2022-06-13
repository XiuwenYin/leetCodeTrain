package leetcode402;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode402 {
    public String removeKdigits(String num, int k) {
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
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        //从后往前添加所以我们要逆序
        return sb.reverse().toString();
    }
}
