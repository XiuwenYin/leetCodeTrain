package leetcode352;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class leetcode352 {

}

class SummaryRanges {
    // 基本结构：使用TreeSet（底层可以理解为红黑树实现）
    TreeSet<int[]> treeSet = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    public SummaryRanges() {

    }

    public void addNum(int val) {
        int[] interval = new int[]{val, val};
        if (treeSet.contains(interval)) return;

        int[] low = treeSet.lower(interval);
        int[] high = treeSet.higher(interval);
        if (high != null && high[0] == val) {
            return;
        }
        if (low != null && low[1] + 1 == val && high != null && high[0] - 1 == val) { // 新加入的刚好在low[1]和high[0]之间
            low[1] = high[1];
            treeSet.remove(high);
        } else if (low != null && low[1] + 1 >= val) { // 新加入的在low的右边但够不到high的左边
            low[1] = Math.max(low[1], val);
        } else if (high != null && high[0] - 1 == val) { // 新加入的在刚好在high的左边但不满足上一条
            high[0] = val;
        } else { // 新加入的孤立
            treeSet.add(interval);
        }
    }

    public int[][] getIntervals() {
        // 直接遍历treeSet添加入动态数组
        List<int[]> res = new ArrayList<>();
        for (int[] x : treeSet) {
            res.add(x);
        }
        return res.toArray(new int[res.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
