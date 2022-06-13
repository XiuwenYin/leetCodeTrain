package leetcode56;

import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class leetcode56 {
    public int[][] merge(int[][] intervals) {
        // 1. 对区间左边的值进行比较
        Arrays.sort(intervals, new Comparator<int[]>() { // 重写 Comparator接口
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // 对两个区间的第一个值进行比较，前者比后者大，结果为正；前者比后者小，结果为负
            }
        });

        // 2. 初始化 outputs，存储合并区间之后的区间的动态数组
        ArrayList<int[]> outputs = new ArrayList<>();

        // 3. 遍历处理每一个区间
        for (int i = 0 ; i < intervals.length ; i++) {
            int[] currIntervals = intervals[i];
            if (outputs.isEmpty()) {
                outputs.add(currIntervals);
            } else { // 判断是否有重叠，有就合并
                int[] outputLastIntervals = outputs.get(outputs.size() - 1);
                int outputLastIntervalsRight = outputLastIntervals[1];
                int currLeft = currIntervals[0];
                if (currLeft > outputLastIntervalsRight) { // 无重叠
                    outputs.add(currIntervals);
                } else { // 重叠情况，合并
                    int currRight = currIntervals[1];
                    outputLastIntervals[1] = Math.max(currRight, outputLastIntervalsRight);
                }

            }
        }
        return outputs.toArray(new int[outputs.size()][]);
    }
}
