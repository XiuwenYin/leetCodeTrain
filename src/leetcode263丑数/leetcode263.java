package leetcode263丑数;

public class leetcode263 {
    /**
     * 数学
     * 为判断 nn 是否满足上述形式，可以对 nn 反复除以 2,3,52,3,5，直到 nn 不再包含质因数 2,3,52,3,5。若剩下的数等于 11，则说明 nn 不包含其他质因数，是丑数；否则，说明 nn 包含其他质因数，不是丑数。

     */
    public boolean isUgly(int n) {
        if (n <= 0) return false; // 负数或者0直接返回false
        int[] p = new int[]{2, 3, 5};
        for (int x : p) {
            while (n % x == 0) {
                n /= x;
            }
        }
        return n == 1;
    }
}
