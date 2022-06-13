package leetcode986;

import java.util.ArrayList;
import java.util.List;

public class leetcode986 {
    /**
     * 归并区间
     * 此题和 1229题基本一致
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int m = firstList.length, n = secondList.length;
        while (i < m && j < n) {
            int intervalStart = Math.max(firstList[i][0], secondList[j][0]);
            int intervalEnd = Math.min(firstList[i][1], secondList[j][1]);
            if (intervalEnd - intervalStart >= 0) {
                res.add(new int[]{intervalStart, intervalEnd});
            }
            // Remove the interval with the smallest endpoint
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
