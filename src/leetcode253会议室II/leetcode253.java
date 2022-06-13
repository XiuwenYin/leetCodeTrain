package leetcode253会议室II;

import java.util.*;

public class leetcode253 {
    /*
    思路：对于数组集中的子数组，进行对于第0位的排序，表示按照开会开始的时间由小到大排列（升序）
    而设定最小堆的思路则是，对于数组集中的子数组，进行对第1位的排序，表示按照开会的结束时间由小到大排列（升序）
    先将一个会议（子数组）存入，然后比较下一个子数组和当前堆顶数组的结束时间（第1位）
    如果不重叠，则弹出堆顶子数组（表示会议开完了，下一场会议进入）
    如果重叠，则需要重新开启一个会议房间（minHeap的 size()增加）
    最后统计一共有多少个房间，即 minHeap 的 size()
     */
    public int minMeetingRooms(int[][] intervals) {
        // 创建minHeap，基于存入数组的第1位进行排序
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // sort这个interval中所有的数组，基于数组的第0位进行排序（升序）
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 将interval中第0位的数组存入minHeap中
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (minHeap.size() > 0 && minHeap.peek()[1] <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i]);
        }
        return minHeap.size();
    }

    /*
    权重法
     */
    public int minMeetingRooms01(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] x : intervals) {
            // 开始时，即x[0]权重为1；结束时，即x[1]权重为-1
            list.add(new int[]{x[0], 1});
            list.add(new int[]{x[1], -1});
        }
        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0, level = 0;
        for (int[] x : list) {
            level += x[1]; // 此处x[1]代表list中添加数组元素第二位，也就是对应的 1 或 -1
            res = Math.max(res, level);
        }
        return res;
    }

    /*
    扫描线法
     */
    public int minMeetingRooms02(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0, levelEnd = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] < end[levelEnd]) {
                res++;
            } else {
                levelEnd++;
            }
        }
        return res;
    }

}
