package leetcode735行星碰撞;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode735 {
    /**
     * 单调栈
     * 但和其他单调栈要从后向前不一样
     * 由于流星拥有方向（正负）所以可以直接遍历
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<Integer>();
        /* 先分两种情况：
        * 1. 如果x为正数，则直接压入单调栈
        * 2. 如果x为负数，则进一步判断：
        *     2.1 如果当前stack非空，则判断x的绝对值大小和stack顶部的值，如果大于，则弹出所有符合条件的元素，直到stack为空或者栈顶元素要比x的绝对值大
        *     2.2 如果当前stack非空，则判断x的绝对值大小和stack顶部的值，如果等于，则弹出当前栈顶元素（仅仅弹出一个）
        *     2.3 如果当前stack非空，或者栈顶元素的值为负数，则直接压入当前x
        */
        for (int x : asteroids) {
            if (x > 0) {
                stack.push(x);
            }else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(x) > stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(x)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0){
                    stack.push(x);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
