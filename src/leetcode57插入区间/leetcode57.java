package leetcode57插入区间;

import java.util.ArrayList;
import java.util.List;

public class leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) return intervals;
        if (intervals.length == 0) return new int[][]{newInterval};

        List<int[]> res = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        int len = intervals.length, j = 0;
        while (j < len && intervals[j][1] < left) res.add(intervals[j++]);      //重叠前直接加入List
        while (j < len && intervals[j][0] <= right) {     //处理重叠区域
            left = Math.min(left, intervals[j][0]);
            right = Math.max(right, intervals[j++][1]);
        }
        res.add(new int[]{left, right});
        while (j < len) res.add(intervals[j++]);     //不会再出现重叠区域，直接加入List
        return res.toArray(new int[res.size()][]);
    }
}
