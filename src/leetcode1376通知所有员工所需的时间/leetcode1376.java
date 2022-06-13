package leetcode1376通知所有员工所需的时间;

public class leetcode1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        int[] dp = new int[n]; // dp数组存的为从根节点通知到该节点所耗费的时间
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(manager, dp, informTime, i));
        }
        return res;
    }
    private int dfs(int[] manager, int[] dp, int[] informTime, int cur) {
        if (manager[cur] == -1) return 0; // 如果是head则跳过不计算
        if (dp[manager[cur]] != 0) return (dp[cur] = dp[manager[cur]] + informTime[manager[cur]]);
        return (dp[cur] = dfs(manager, dp, informTime, manager[cur]) + informTime[manager[cur]]);
    }
}
