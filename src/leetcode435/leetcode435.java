package leetcode435;

import java.util.Arrays;

public class leetcode435 {
    /**
     * 贪心思想
     * 先排序子区间的第[1]位，也就是右边，选取最小的右边所在的子区间作为right标记
     *     ！！因为按照结束时间排序的话，会预留更多空间给子数组！！
     * 依次比较其他子区间的[0]位和right，如果大于等于说明没有重叠，则结果++，反之不用管
     * 然后返回总区间数 - 结果区间数量
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int n = intervals.length;
        int right = intervals[0][1];
        int res = 1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }
        return n - res;
    }
}
