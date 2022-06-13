package leetcode1037有效的回旋镖;

public class leetcode1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        int[] v1 = new int[]{x2 - x1, y2 - y1};
        int[] v2 = new int[]{x3 - x1, y3 - y1};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
