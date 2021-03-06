package leetcode887鸡蛋掉落;

public class leetcode887 {
    public int superEggDrop(int k, int n) {
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            if (dp[i][k] >= n) return i;
        }
        return -1;
    }
    /**
     * 反过来想这个问题：如果我们可以做 t 次操作，而且有 k 个鸡蛋，那么我们能找到答案的最高的 n 是多少？
     * 我们设 f(t, k) 为在上述条件下的 n。如果我们求出了所有的 f(t, k)，那么只需要找出最小的满足 f(t, k) >= n 的 t。
     *
     * 那么我们如何求出 f(t, k)f(t,k) 呢？我们还是使用动态规划。
     * 因为我们需要找出最高的 nn，因此我们不必思考到底在哪里扔这个鸡蛋，我们只需要扔出一个鸡蛋，看看到底发生了什么：
     *
     * 如果鸡蛋没有碎，那么对应的是 f(t - 1, k)f(t−1,k)，也就是说在这一层的上方可以有 f(t - 1, k)f(t−1,k) 层；
     *
     * 如果鸡蛋碎了，那么对应的是 f(t - 1, k - 1)f(t−1,k−1)，也就是说在这一层的下方可以有 f(t - 1， k - 1)f(t−1，k−1) 层。
     *
     * 因此我们就可以写出状态转移方程：
     * f(t, k) = 1 + f(t-1, k-1) + f(t-1, k)
     * f(t,k)=1+f(t−1,k−1)+f(t−1,k)
     *
     * 边界条件为：当 t >= 1 的时候 f(t, 1) = t，当 k >= 1 时，f(1, k) = 1
     *
     * 那么问题来了：tt 最大可以达到多少？由于我们在进行动态规划时，tt 在题目中并没有给出，那么我们需要进行到动态规划的哪一步呢？可以发现，操作次数是一定不会超过楼层数的，因此 t \leq nt≤n，我们只要算出在 f(n, k)f(n,k) 内的所有 ff 值即可。
     */
}
