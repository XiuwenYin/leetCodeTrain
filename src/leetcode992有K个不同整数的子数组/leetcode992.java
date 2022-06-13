package leetcode992有K个不同整数的子数组;

import java.util.HashMap;
import java.util.Map;

public class leetcode992 {
    /**
     * 滑动窗口
     * exactly k = at most k times - at most (k - 1) times
     * @param nums
     * @param k
     * @return
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0, res = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(nums[i], 0) == 0) k--;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (k < 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) k++;
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}
