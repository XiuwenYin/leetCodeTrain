package leetcode172阶乘后的零;

public class leetcode172 {
    /**
     * 数学
     *
     * 2 * 5 = 10，才会在末尾贡献 0
     * 答案为 n! 中因子 2 的数量和因子 5 的数量的最小值
     * 阶乘中因子 5 的数量一定小于因子 2 的数量
     * 先从 1 - n 中的： 1 * 5, 2 * 5, ..., x * 5 每个拿出一个因子 5，有 x = n / 5 个数可以拿出
     * 拿完后剩下 1, 2, 3, ..., x; 重复上一步
     */
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
}
