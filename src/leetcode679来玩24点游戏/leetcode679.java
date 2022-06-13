package leetcode679来玩24点游戏;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

public class leetcode679 {
    private static final int TARGET = 24;
    private static final double EPSLION = 1e-6;

    /**
     * 回溯
     * n个数字加减乘除是否能得到24
     * @param cards
     * @return
     */
    public boolean judgePoint24(int[] cards) {
        return backtrack(new double[]{cards[0], cards[1], cards[2], cards[3]});
    }

    private boolean backtrack(double[] nums) {
        if (nums.length == 1) return Math.abs(nums[0] - TARGET) < EPSLION;
        // 每次选择两个不同的数进行回溯
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 将选择出来的两个数的计算结果和原数组剩下的数加入 next 数组
                double[] next = new double[nums.length - 1];
                int pos = 0;
                // 举例：在i = 0, j = 1, 将next的第0位放入num的第3位的数字（next长度为3）
                for (int k = 0; k < nums.length; k++) {
                    if (k != i && k != j) next[pos++] = nums[k];
                }
                // 将next的最后一位放入nums[i]和nums[j]的某个计算答案（加减乘除），并回溯判断
                for (double num : calculate(nums[i], nums[j])) {
                    next[next.length - 1] = num;
                    if (backtrack(next)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> calculate(double a, double b) {
        List<Double> list = new ArrayList<>();
        list.add(a + b);
        list.add(a - b);
        list.add(b - a);
        list.add(a * b);
        if (!(Math.abs(b) < EPSLION)) list.add(a / b);
        if (!(Math.abs(a) < EPSLION)) list.add(b / a);
        return list;
    }
}