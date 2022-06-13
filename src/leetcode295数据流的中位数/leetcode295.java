package leetcode295数据流的中位数;

import java.util.PriorityQueue;

public class leetcode295 {

}

class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

    }

    public void addNum(int num) {
        if (minHeap.size() != maxHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() != maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // 保证返回的是一个double
        }
    }
}
