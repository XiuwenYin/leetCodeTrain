package leetcode204计数质数;

import java.util.Arrays;

public class leetcode204 {

    /**
     * 朴素计数（超时）
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrime(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) { // 注意 i 遍历到最大sqrt(n)即可
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 埃氏筛
     * 初始化长度 O(n) 的标记数组，表示这个数组是否为质数。数组初始化所有的数都是质数.
     * 从 2 开始将当前数字的倍数全都标记为合数。标记到 sqrt(n) 时停止即可
     * 注意每次找当前素数 x 的倍数时，是从 x^2 开始的。
     * 因为如果 x > 2，那么 2*x 肯定被素数 2 给过滤了，最小未被过滤的肯定是 x^2
     */
    public int countPrimes01(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
