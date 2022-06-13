package leetcode759;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode759 {
    /**
     * 堆排序，归并区间
     *
     * @param schedule
     * @return
     */
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        // 使用堆排序，对于区间第一位（start）实现小顶堆
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> a.start - b.start);
        // 遍历，并放入堆
        for (List<Interval> x : schedule) {
            for (Interval interval : x) {
                heap.offer(interval);
            }
        }
        // 取出第一位作为比较对象
        Interval cur = heap.poll();
        while (!heap.isEmpty()) {
            // 当当前的元素的结束值要大于等于堆顶元素的起点时，就代表当前元素和对顶元素重叠；此时要更新当前元素的end值（选取最大的一方）
            if (cur.end >= heap.peek().start ) {
                cur.end = Math.max(cur.end, heap.poll().end); // 注意这里，是从堆中拿出堆顶元素，即代表更新了堆顶元素（变成了下一位）
            } else { // 如果不是，那么证明两者没有重叠，此时放入结果集（当前的结束作为结果集中的起始，堆顶元素的起始作为结果集中的结束）
                res.add(new Interval(cur.end, heap.peek().start));
                cur = heap.poll(); // 更新当前元素
            }
        }
        return res;
    }
}


class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};