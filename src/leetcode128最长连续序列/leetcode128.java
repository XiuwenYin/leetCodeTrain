package leetcode128最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode128 {
    /**
     * Set去重
     * 每次找x前一位
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int res = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) { // 这里很巧妙，先寻找x - 1是否存在
                int cur = x; // 不存在的话可以将cur作为连续的开头
                int level = 1;

                while (set.contains(cur + 1)) { // 每当找到一个cur + 1，即可把当前的最大长度++
                    cur++;
                    level++;
                }
                res = Math.max(res, level); // 每次if结束前res取最大
            }
        }
        return res;
    }
}

