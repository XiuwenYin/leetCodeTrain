package leetcode1231分享巧克力;

public class leetcode1231 {
    /*
    二分查找
    贪心
     */
    public int maximizeSweetness(int[] sweetness, int k) {
        // 二分查找范围：从甜度0 到 甜度最大即甜度和除以k+1
        int left = 1, right = 0;
        for (int x : sweetness) {
            right += x;
        }
        right /= (k + 1);
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int piece = split(sweetness, mid);
            if (piece >= k + 1) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int split(int[] sweetness, int maxIntervalSum) {
        int piece = 0, curIntervalSum = 0;
        for (int x : sweetness) {
            curIntervalSum += x;
            if (curIntervalSum >= maxIntervalSum) {
                curIntervalSum = 0;
                piece++;
            }
        }
        return piece;
    }
}
