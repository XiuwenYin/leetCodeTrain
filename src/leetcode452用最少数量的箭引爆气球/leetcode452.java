package leetcode452用最少数量的箭引爆气球;

import java.util.Arrays;

public class leetcode452 {
    /**
     * 贪心 + 排序
     * 以右边界为升序排列，设置默认right挡板是points[0][1]
     * 遍历数组，如果当前左边界超出了挡板（在挡板右侧）则需要重新设置挡板，并且结果++
     * 如果在左挡板内，则进行下一组遍历
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] < b[1] ? -1 : 1); // 由于负数参与，所以排序要这么写
        int res = 1, right = points[0][1];
        int n = points.length;
        for (int i = 0; i < n; i++) {
            if (points[i][0] <= right) {
                continue;
            }
            right = points[i][1];
            res++;

        }
        return res;
    }
}
