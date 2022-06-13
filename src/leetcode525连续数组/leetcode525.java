package leetcode525连续数组;

import java.util.HashMap;
import java.util.Map;

public class leetcode525 {
    /**
     * twoSum类型
     * 将0翻转为-1，利用-1 + 1 = 0 的特性来找出最大值
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) res = Math.max(res, i - map.get(sum));
            else map.put(sum, i);
        }
        return res;
    }
}
