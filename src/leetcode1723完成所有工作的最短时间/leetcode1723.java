package leetcode1723完成所有工作的最短时间;

import java.util.Arrays;

public class leetcode1723 {
    int[] jobs;
    int k;
    int n;
    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.n = jobs.length;
        this.jobs = jobs;
        this.k = k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0);
        return res;
    }

    /**
     * idx   : 当前处理到那个 job
     * used  : 当前分配给了多少个工人了
     * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
     * max   : 当前的「最大工作时间」
     */
    private void dfs(int idx, int used, int[] sum, int max) {
        if (max > res) return;
        if (idx == n) {
            res = max;
            return;
        }
        /*相比与朴素dfs，这里优先分配给未有工作的工人，即优先分配给「空闲工人」*/
        if (used < k) {
            sum[used] = jobs[idx];
            dfs(idx + 1, used + 1, sum, Math.max(max, sum[used]));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[idx];
            dfs(idx + 1, used, sum, Math.max(max, sum[i]));
            sum[i] -= jobs[idx];
        }
    }


}
