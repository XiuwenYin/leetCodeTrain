package leetcode218天际线;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode218 {
    /**
     * 不要把此题看做太复杂的重叠问题
     * 此题和数飞机还有会议室II问题一样
     * 只不过，把楼层高度看做飞机数量而已
     * 对权重进行调整
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] building : buildings) {
            height.add(new int[] {building[0], -building[2]}); // 房子的起点高度为负数，sort后先访问
            height.add(new int[] {building[1], building[2]});  // 房子的终点高度为正数，sort后后访问
        }
        height.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // 创建大顶堆，存放高度，因为矮的地方被覆盖了，所以不用考虑
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.offer(0);
        int pre = 0;
        for (int[] h : height) {
            if (h[1] < 0) { // 遇到新房子，加入heap，其中高度由大到小
                heap.offer(-h[1]);
            } else { // 遇到旧房子，拿掉
                heap.remove(h[1]); // 此处的时间复杂度很高，priorityQueue删除一个值
            }
            int cur = heap.peek();
            if (cur != pre) {
                List<Integer> level = new ArrayList<>();
                level.add(h[0]);
                level.add(cur);
                res.add(level);
                pre = cur;
            }
        }
        return res;
    }
}
