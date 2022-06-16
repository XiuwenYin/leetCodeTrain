package leetcode560和为K的子数组;

import java.util.HashMap;
import java.util.Map;

public class leetcode560 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 练习
     * 1. o(n2)时间复杂度的前缀和
     * 练手而已没必要写
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum01(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefix[j] - prefix[i] == k) res++;
            }
        }
        return res;
    }

    /**
     * 2. o(n)时间复杂度
     * two sum写法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum02(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 此处放的是 prefix sum 和 frequency
        for (int x : nums) {
            sum += x;
            if (map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
