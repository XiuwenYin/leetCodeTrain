package leetcode225用队列实现栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode225 {
}

/**
 * 用一个队列实现栈，计数法
 */
class MyStack {
    Deque<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        q.offer(x);
    }

    public int pop() {
        int size = q.size();
        int idx = 0;
        while (idx != size - 1) {
            q.offer(q.poll());
            idx++;
        }
        return q.poll();
    }

    public int top() {
        int size = q.size();
        int idx = 0;
        int res = 0;
        while (idx != size - 1) {
            q.offer(q.poll());
            idx++;
        }
        res = q.peek();
        q.offer(q.poll());
        return res;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */