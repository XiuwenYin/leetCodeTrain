package leetcode703;

import java.util.PriorityQueue;

public class leetcode703 {

}

class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int x : nums) {
            heap.offer(x);
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}