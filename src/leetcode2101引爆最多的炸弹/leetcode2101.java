package leetcode2101引爆最多的炸弹;

import java.util.Arrays;

public class leetcode2101 {
    int max = 1;
    boolean[] memo;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        memo = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(bombs, i);
            // 所有炸弹置还原为未引爆状态
            Arrays.fill(memo, false);
        }
        return max;
    }
    private int dfs(int[][] bombs, int idx) {
//        int m = bombs.length, n = bombs[0].length;
        if (memo[idx]) return 0;
        memo[idx] = true;
        int res = 1;
        // 遍历所有炸弹，判断是否会连带引爆
        for (int i = 0; i < bombs.length; i++) {
            if (memo[i]) continue;
            if (can(bombs, idx, i)) {
                // i爆炸之后，会带动其他的炸弹爆炸，继续dfs
                res += dfs(bombs, i);
            }
        }
        max = Math.max(max, res);
        return res;
    }

    private boolean can(int[][] bombs, int i, int j) {
        int[] b1 = bombs[i];
        int[] b2 = bombs[j];
        long x1 = b1[0], x2 = b2[0];
        long y1 = b1[1], y2 = b2[1];
        long r = b1[2];

        // 三角函数
        long len = (y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1);
        if (len >= r * r) return true;
        return false;
    }
}
