package leetcode252会议室;

import java.util.Arrays;

public class leetcode252 {
    /*
    数组排序，根据子数组第二位
     */
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        if (n == 0 || n == 1) return true;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] > temp) {
                return false;
            }
            temp = intervals[i][1];
        }
        return true;
    }

    /*
    数组排序，根据子数组第一位
     */
    public boolean canAttendMeetings01(int[][] intervals) {
        int n = intervals.length;
        if (n == 0 || n == 1) return true;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }

}
