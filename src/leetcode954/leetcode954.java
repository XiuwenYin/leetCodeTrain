package leetcode954;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode954 {
    int N = 100010, M = N * 2;
    int[] cnts = new int[M * 2];
    public boolean canReorderDoubled(int[] arr) {
        Arrays.fill(cnts, 0);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));
        for (int x : arr) {
            heap.add(x);
        }
        while (!heap.isEmpty()) {
            int x = heap.poll();
            int t = x * 2;
            if (cnts[x + M] != 0 && --cnts[x + M] >= 0) {
                continue;
            }
            cnts[t + M]++;
        }
        for (int i = 0; i < M * 2; i++) {
            if (cnts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
