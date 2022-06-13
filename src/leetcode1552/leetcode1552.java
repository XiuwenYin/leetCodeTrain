package leetcode1552;

import java.util.Arrays;

public class leetcode1552 {
    /**
     * 二分查找
     * 读题（题目难懂）
     * @param position
     * @param m
     * @return
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0];
        int res = -1;
        while (left <= right) { // 用的是古城第三个二分模板，用res记录下答案
            int mid = left + (right - left) / 2;
            if (check(position, mid, m)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean check (int[] position, int max, int m){
        int pre = position[0];
        int cnt = 1;
        for (int i = 0; i < position.length; i++) {
            if (position[i] - pre >= max) {
                pre = position[i];
                cnt++;
            }
        }
        return cnt >= max;
    }
}
