package leetcode1184公交站间的距离;

public class leetcode1184 {
    /**
     * 一次遍历
     * 记得先对start和destination的顺位做判断
     * 如果在[start, destination)中则left += distance[i]; 反之则right加
     * 最后返回min
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (i >= start && i < destination) left += distance[i];
            else right += distance[i];
        }
        return Math.min(left, right);
    }
}
