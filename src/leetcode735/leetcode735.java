package leetcode735;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<Integer>();
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
