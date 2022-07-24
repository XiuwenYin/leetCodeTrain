package leetcode946验证栈序列;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode946 {
    /**
     * 直接使用栈
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && i < n && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return i == n;
    }

    // 牛
    // 构造辅助栈
    // 模拟入栈顺序，符合弹出序列顺序的栈顶元素全部弹出，若辅助栈为空，则合法
    // 时复：1 空复：N
    public boolean validateStackSequences01(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int num : pushed) {
            pushed[i] = num; // 每次要更新pushed在idx位置元素
            // i一定大于等于0
            while (i >= 0 && pushed[i] == popped[j]) {
                j++;
                i--;
            }
            i++;
        }
        return i == 0;
    }


}
