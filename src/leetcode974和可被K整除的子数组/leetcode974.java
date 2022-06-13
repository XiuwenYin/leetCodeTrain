package leetcode974和可被K整除的子数组;

import java.util.HashMap;
import java.util.Map;

public class leetcode974 {
    /**
     * twoSum法
     * 如果两个elements的preFixSum的余数相同，则代表这中间出现了可被整除的连续子串
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // 存储的是preFix和frequency
        int res = 0;
        int preFix = 0;
        map.put(0, 1); // 初始化
        for (int x : nums) {
            preFix = (preFix + x % k + k) % k; // 防止x为负数的情况
            res += map.getOrDefault(preFix, 0);
            map.put(preFix, map.getOrDefault(preFix, 0) + 1);
        }
        return res;
    }
}
