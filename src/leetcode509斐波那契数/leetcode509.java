package leetcode509斐波那契数;

public class leetcode509 {
    /**
     * 朴素递归
     * 两个返回条件，然后直接递归（由上到下）
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 迭代
     * 最优，自底向上
     * @param n
     * @return
     */
    public int fib01(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int pre1 = 0, pre2 = 1, res = 0;
        for (int i = 2; i <= n; i++) { // 注意这里，i 的起始值为2
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}
