package leetcode6120数组能形成多少数对;

import java.util.HashMap;
import java.util.Map;

public class leetcode6120 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int[] res = new int[2];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (((entry.getValue() & 1) != 0)) res[1]++;
            res[0] += entry.getValue() / 2;
        }
        return res;
    }
}
