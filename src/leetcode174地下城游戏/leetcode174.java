package leetcode174地下城游戏;

public class leetcode174 {
    /**
     * 之所以要倒dp是因为正dp的破坏了无后效性,具体体现在，
     * 我们无法直接确定到达某一点的方案，因为有两个重要程度相同的参数同时影响后续的决策。
     * 分别是：剩余血量与到达当前点所需要的最小初始化血量共同影响着后面一步的结果
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        // 设置最后一个值。
        dp[m - 1][n - 1] = Math.max(0, -dungeon[m - 1][n - 1]);

        // 设置最后一列的值
        for (int i = m - 2; i >= 0; --i) {
            int needMin = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
        for (int i = n - 2; i >= 0; --i) {
            int needMin = dp[m - 1][i + 1] - dungeon[m - 1][i];
            dp[m - 1][i] = Math.max(0, needMin);
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        return dp[0][0] + 1; // 保证在最后房间有1滴血
    }
}
