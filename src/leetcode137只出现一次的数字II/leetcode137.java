package leetcode137只出现一次的数字II;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class leetcode137 {
    /**
     * 位运算（记不住的，老老实实计数法吧）
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

    /**
     * 哈希表计数，也没慢到哪去
     * On On
     */
    public int singleNumber01(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                return res;
            }
        }
        return res;
    }
}
