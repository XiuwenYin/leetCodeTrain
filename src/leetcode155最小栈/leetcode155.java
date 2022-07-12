package leetcode155最小栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode155 {

}

class MinStack {

    // 数组栈, [当前值, 当前最小值]
    private Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        } else {
            stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}