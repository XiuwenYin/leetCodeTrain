package leetcode875爱吃香蕉的珂珂;

public class leetcode875 {
    /**
     * 二分查找，左边为1，右边为max
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0, tol = 0;
        for (int x : piles) {
            max = Math.max(max, x);
            tol += x;
        }
        int left = max, right = tol;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int split = splits(piles, mid);
            if (split > h) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int splits(int[] piles, int midSpeed) {
        int split = 0;
        for (int pile : piles) {
            // 每堆香蕉吃完的耗时 = 这堆香蕉的数量 / 珂珂一小时吃香蕉的数量  上取整可以这样写
            split += (pile + midSpeed - 1) / midSpeed;
        }
        return split;
    }
}
