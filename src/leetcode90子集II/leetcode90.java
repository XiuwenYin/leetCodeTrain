package leetcode90子集II;

import java.util.*;

public class leetcode90 {
    /**
     * dfs 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 先排序，去重会用到
        backTrack(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, int[] nums, List<Integer> level, int index) {
        res.add(new ArrayList<>(level));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i + 1]) { // 保证不是新一轮的开头，并且当前值和前一轮遍历的值相同时，跳过此处（去重）
                continue;
            }
            level.add(nums[i]);
            backTrack(res, nums, level, i + 1);
            level.remove(level.size() - 1);
        }
    }
}
