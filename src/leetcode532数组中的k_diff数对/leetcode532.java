package leetcode532数组中的k_diff数对;

import java.util.HashMap;
import java.util.Map;

public class leetcode532 {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : nums) {
            if (map.get(x) == 0) continue;
            if (k == 0) {
                if (map.get(x) > 1) res++;
            } else {
                int temp1 = x + k;
                int temp2 = x - k;
                if (map.getOrDefault(temp1, 0) > 0) res++;
                if (map.getOrDefault(temp2, 0) > 0) res++;
            }
            map.put(x, 0);
        }
        return res;
    }
}
