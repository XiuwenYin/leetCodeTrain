package leetcode264丑数II;

public class leetcode264 {
    /**
     * 动态规划 + 指针
     *
     * 1. 任意丑数乘以2，3，5还是丑数，这个很好理解
     * 2. 题目要求的是递增的丑数，已知有两个丑数n1 < n2，当n1 * 2 没有被计入结果集里时，n2 * 2不用考虑。
     * 3. 根据以上两点，假设当前的 dp = [ ······ n1, n2, ······ ], 现在p2指向n1。当n1 * 2 被计入结果，p2 向后移动，n2 * 2才被考虑。p3、p5同理。
     * 4. p2 p3 p5 都不是数值，指针！！它们是指向当前已经加入结果集dp[ ]里的数。
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1; // 指针都从1起
        for (int i = 2; i <= n; i++) { // 从2起到n结束，[2, n]
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5)); // 每次三者取最小才是当前位置的丑数
            if (dp[i] == num2) p2++; // 只有当前结果被记入时，对应的指针才+1
            if (dp[i] == num3) p3++;
            if (dp[i] == num5) p5++;
        }
        return dp[n];
    }
}