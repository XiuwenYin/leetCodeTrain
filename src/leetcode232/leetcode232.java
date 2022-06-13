package leetcode232;

import java.util.Deque;
import java.util.LinkedList;
// 用栈实现队列

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class leetcode232 {

    private Deque<Integer> st1;
    private Deque<Integer> st2;
    private int front = 0;
    public leetcode232() {
        this.st1 = new LinkedList<>();
        this.st2 = new LinkedList<>();
    }

    public void push(int x) {
        if (st1.isEmpty()) {
            front = x;
        }
        st1.push(x);
    }

    public int pop() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    public int peek() {
        if (!st2.isEmpty()) {
            return st2.peek();
        }
        return front;

    }

    public boolean empty() {
        if(st2.isEmpty()){
            return st1.isEmpty();
        }
        return false;
    }
}
