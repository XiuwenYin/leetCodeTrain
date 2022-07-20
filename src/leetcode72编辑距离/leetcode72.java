package leetcode72编辑距离;

public class leetcode72 {
    /**
     * 动态规划（自底向上）
     * dp[i][j]表示在word1到i位置，变成word2到j位置的最小步数
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if (n1 * n2 == 0) return n1 + n2; // 判断一方长度为0

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) dp[i][0] = i; // 对第一列进行赋值
        for (int j = 0; j <= n2; j++) dp[0][j] = j; // 对第一行进行赋值

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                // 每次如果不一致，则从左，上，左上找到min，并加上1（表示当前修改的一步）
                if (c1 != c2) dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                else dp[i][j] = dp[i - 1][j - 1]; // 如果一致，则直接等于左上
            }
        }
        return dp[n1][n2];
    }
}
