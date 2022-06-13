package leetcode1288;

import java.util.Arrays;

public class leetcode1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        // 排序，左边从小到大，如果左边相同，则按照右边从大到小，而不是一般的从小到大
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int cur = 0, prev = 0, res = 0;
        for (int[] x : intervals) {
            cur = x[1];
            if (prev < cur) {
                res++;
                prev = cur;
            }
        }
        return res;
    }
}
