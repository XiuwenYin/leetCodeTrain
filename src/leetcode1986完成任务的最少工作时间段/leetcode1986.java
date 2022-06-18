package leetcode1986完成任务的最少工作时间段;

import java.util.Arrays;

public class leetcode1986 {
    /**
     * dfs + 剪枝优化
     * 同1723题
     */
    int res, maxSessionTime;
    int[] tasks, sessions;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks); // 剪枝，从小到大排序，然后dfs从最后到最初
        int n = tasks.length;
        this.res = n;
        this.maxSessionTime = sessionTime;
        this.tasks = tasks;
        this.sessions = new int[n];
        dfs(n - 1, 0);
        return res;
    }

    private void dfs(int idx, int sessionCount) {
        if (sessionCount > res) return; // 剪枝，global min
        if(idx < 0) {
            res = Math.min(res, sessionCount);
            return;
        }

        for (int i = 0; i < sessionCount; i++) {
            if (sessions[i] + tasks[idx] <= maxSessionTime) { // 将当前工作放入旧的session
                sessions[i] += tasks[idx];
                dfs(idx - 1, sessionCount);
                sessions[i] -= tasks[idx];
            }
        }
        // 将当前工作放入新的session（新开工人）
        sessions[sessionCount] += tasks[idx];
        dfs(idx - 1, sessionCount + 1);
        sessions[sessionCount] -= tasks[idx];
    }
}
