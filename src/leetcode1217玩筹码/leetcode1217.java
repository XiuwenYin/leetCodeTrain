package leetcode1217玩筹码;

public class leetcode1217 {
    /**
     * 贪心
     * 统计一下奇偶数各有多少，返回最小的就行
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int n = position.length;
        int cnt1 = 0, cnt2 = 0;
        for (int x : position) {
            if (x % 2 != 0) cnt1++;
            else cnt2++;
        }
        return Math.min(cnt1, cnt2);
    }
}
