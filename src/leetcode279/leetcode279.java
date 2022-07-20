package leetcode279;

public class leetcode279 {
    /**
     * dp
     * 动态转移方程：dp[i] = Math.min(dp[i], dp[i - j * j])
     * 可以看做是背包问题（类似322零钱兑换）
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) { // 从[1, j^2 = i]遍历
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

    /**
     * 数学：四平方和定理
     * 1. 任何正整数都可以拆分成不超过4个数的平方和 ---> 答案只可能是1,2,3,4
     * 2. 如果一个数最少可以拆成4个数的平方和，则这个数还满足 n = (4^a)*(8b+7) ---> 因此可以先看这个数是否满足上述公式，如果不满足，答案就是1,2,3了
     * 3. 如果这个数本来就是某个数的平方，那么答案就是1，否则答案就只剩2,3了
     * 4. 如果答案是2，即n=a^2+b^2，那么我们可以枚举a，来验证，如果验证通过则答案是2
     * 5. 只能是3
     */
    public int numSquares01(int n) {
        if (isPerfectSquare(n)) { // 首先判断本身是否为平方数字，如果是，则返回
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
}
