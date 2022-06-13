package leetcode523连续的子数组和;

import java.util.HashMap;
import java.util.Map;

public class leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // 存储的是preFix和frequency
        int res = 0;
        int preFix = 0;
        map.put(0, -1); // 初始化
        for (int i = 0; i < n; i++) {
            preFix += nums[i];
            if (k != 0) preFix %= k;
            if (map.containsKey(preFix)) {
                if (i - map.get(preFix) > 1) return true;
            } else {
                map.put(preFix, i);
            }
        }
        return false;
    }
}
