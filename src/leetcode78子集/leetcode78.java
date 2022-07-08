package leetcode78子集;

import java.util.ArrayList;
import java.util.List;

public class leetcode78 {
    /**
     * dfs
     * 这样空集为res的最后一位元素
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> cur, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[index]);
        dfs(res, nums, cur, index + 1);

        cur.remove(cur.size() - 1);
        dfs(res, nums, cur, index + 1);
    }


    /**
     * 同一种dfs
     * 这样是空集为res的第一个元素
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets01(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs01(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs01(List<List<Integer>> res, int[] nums, List<Integer> level, int index) {
        res.add(new ArrayList<>(level));
        for (int i = index; i < nums.length; i++) {
            level.add(nums[i]);
            dfs(res, nums, level, i + 1);
            level.remove(level.size() - 1);
        }
    }

    /**
     * mask
     * 这个顺序和结果顺序一样，子集元素数量少在前，元素数量多在后
     */
    public List<List<Integer>> subsets02(int[] nums) {
        int totalNum = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int mask = 0; mask < totalNum; mask++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((mask & (1 << j)) != 0) {
                    level.add(nums[j]);
                }
            }
            res.add(level);
        }
        return res;
    }
}
