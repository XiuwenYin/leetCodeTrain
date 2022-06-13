package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode5235 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        Map<Integer, Integer> hashMap0 = new HashMap<>(); // key 数字，val 次数；
        Map<Integer, Integer> hashMap1 = new HashMap<>(); // key 数字，val 次数；
        for (int[] x : matches) {
            hashMap0.put(x[0], hashMap0.getOrDefault(x[0], 0) + 1);
            hashMap1.put(x[1], hashMap1.getOrDefault(x[1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap0.entrySet()) {
            if (!hashMap1.containsKey(entry.getKey())) {
                level.add(entry.getKey());
            }
        }
        res.add(level);
        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
            if (hashMap1.get(entry.getKey()) == 1) {
                level1.add(entry.getKey());
            }
        }
        res.add(level1);
        return res;
    }


}
