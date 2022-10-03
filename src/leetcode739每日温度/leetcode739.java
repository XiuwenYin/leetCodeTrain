package leetcode739每日温度;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode739 {
    /**
     * 标准单调栈用法
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // 1. 创建stack 和 数组结果集
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        // 2. 倒序遍历数组
        for (int i = temperatures.length - 1; i >= 0; i--) {
            // 3. 当栈非空，并且当前遍历到的数组的值 大于等于 栈顶index位置的值 的时候，弹出栈顶值（保证单调性）
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop(); // pop和poll都行，pop弹出栈顶，poll拉出队列第一位，接口是Deque 实现类是LinkedList或者ArrayDeque都适用
            }
            // 4. 填入结果集，如果栈为空，则结果集此处为0；如果栈不为空，则当前结果集的值为 栈顶值减去当前index
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i; // 注意这里，栈顶元素要减去i
            // 5. 栈中填入下一位值
            stack.push(i);
        }
        return res;
    }
}