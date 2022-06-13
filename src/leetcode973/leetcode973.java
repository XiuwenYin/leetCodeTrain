package leetcode973;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode973 {
    /**
     * 排序法，求出两个点分别到原点的距离（x^2 + y^2），再升序排列
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int dis1 = a[0] * a[0] + a[1] * a[1];
                int dis2 = b[0] * b[0] + b[1] * b[1];
                return dis1 - dis2;
            }
        });
        return Arrays.copyOfRange(points, 0, k);
    }

    /**
     * 或者短小精悍点（用λ表达式）
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest01(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points,0, k);
    }
}
