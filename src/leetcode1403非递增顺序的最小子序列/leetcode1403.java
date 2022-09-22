package leetcode1403非递增顺序的最小子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode1403 {
    /**
     * 排序后倒序选择
     *
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0, cur = 0;
        for (int x : nums) sum += x;

        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            sum -= x;
            cur += x;
            res.add(x);
            if (cur > sum) break;
        }
        return res;
    }
}
