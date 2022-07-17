package leetcode6164数位和相等数对的最大和;

import java.util.HashMap;
import java.util.Map;

public class leetcode6164 {
    /**
     * https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
     * 此答案不对，还有待改进
     * @param nums
     * @return
     */
    public int maximumSum(int[] nums) {
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int sumBit = getSumBit(x);
            map.put(sumBit, map.getOrDefault(sumBit, 0) + x);
            if (map.get(sumBit) > x) res = Math.max(res, map.get(sumBit));
        }
        return res;
    }
    public int getSumBit(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
