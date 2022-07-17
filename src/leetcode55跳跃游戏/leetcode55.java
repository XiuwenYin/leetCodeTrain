package leetcode55跳跃游戏;

public class leetcode55 {
    /**
     * 贪心
     * 和45题跳跃游戏II不同，由于不一定每一个格子都能走到，所以需要判断 i <= cur, 保证当前位置是可以到达的
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int cur = 0; // 当前位置
        for (int i = 0; i < n; i++) {
            // 如果cur比当前i大，证明这一步能走到，然后在这区间里找最大的并赋给cur，好让cur能走得更远
            if (i <= cur) cur = Math.max(cur, i + nums[i]);
            if (cur >= n - 1) return true; // 如果cur已经超出边界了，就true
        }
        return false;
    }

}
