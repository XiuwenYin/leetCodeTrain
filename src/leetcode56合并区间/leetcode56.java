package leetcode56合并区间;

import java.util.*;

public class leetcode56 {
    /**
     * 先对区间进行排序
     * 再合并添加或者直接添加进结果集
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // 对二维数组进行排序，对于输入的 v1 v2, 对v1[0] v2[0] 进行升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // new结果集，由于res长度不可能超过原数组，所以设定res长度为n
        int[][] res = new int[n][2];
        // 定义指针
        int idx = -1;
        for (int[] x : intervals) {
            // 如果指针指向-1 或者 当前子区间的头位比结果集子区间的末尾位要大，则证明两区间不重叠，将当前子区间添加入结果集中，并右移idx指针
            if (idx == -1 || x[0] > res[idx][1]) {
                res[++idx] = x;
            } else {
                // 反之 则合并两子区间，通过对比 当前子区间的第一位 和 结果集中前一位子区间的第一位，取最大值为新的结果集子区间第一位的值
                res[idx][1] = Math.max(res[idx][1], x[1]);
            }

        }
        // 返回结果集的一个 对于idx指针+1长度的新结果集
        return Arrays.copyOf(res, idx + 1);
    }

    public int[][] merge01(int[][] intervals) {
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

    /**
     * 和上面类似，但更推荐这种做法，更容易懂
     * 扫描线
     *
     * @param intervals
     * @return
     */
    public int[][] merge02(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        // 先对数组进行第一位排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 将数组第一个子数组当做对照组（指针）
        int[] cur = intervals[0];
        for (int[] x : intervals) {
            // 如果重叠，判断两者谁的右侧（第二位）更大
            if (cur[1] >= x[0]) {
                cur[1] = Math.max(cur[1], x[1]);
            } else {
                // 不符合的时候直接将当前指针加入结果集
                res.add(cur);
                // 更新指针
                cur = x;
            }
        }
        // 将最后一位指针结果加入结果集
        res.add(cur);
        return res.toArray(new int[0][]); // 注意这里的是0
    }
}
