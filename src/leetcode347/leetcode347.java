package leetcode347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int x : nums) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        // 创建堆，创建Comparator
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        // 将 hashMap中的所有数据添加入heap中
        heap.addAll(hashMap.entrySet());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}
