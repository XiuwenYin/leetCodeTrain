package leetcode47全排列II;

import java.util.*;

public class leetcode47 {
    /**
     * dfs + set去重
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index) {
        if (index >= nums.length) {
            List<Integer> level = new ArrayList<>();
            for (int x : nums) {
                level.add(x);
            }
            res.add(level);
        }

        Set<Integer> hashSet = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            if (hashSet.add(nums[index])) {
                dfs(res, nums, index + 1);
            }
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    /**
     * 练习剪枝
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique01(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs01(res, nums, 0);
        return res;
    }

    private void dfs01(List<List<Integer>> res, int[] nums, int index) {
        int n = nums.length;
        if (index >= n) {
            List<Integer> level = new ArrayList<>();
            for (int x : nums) {
                level.add(x);
            }
            res.add(level);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            swap01(nums, i, index);
            if (set.add(nums[index])) {
                dfs01(res, nums, index + 1);
            }
            swap01(nums, i, index);
        }
    }

    private void swap01(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    /**
     * dfs + 剪枝优化
     */
    public List<List<Integer>> permuteUnique02(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> level, int[] nums, boolean[] used) {
        int n = nums.length;
        if (level.size() == n) {
            res.add(new ArrayList<>(level));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            level.add(nums[i]);
            used[i] = true;
            backtrack(res, level, nums, used);
            level.remove(level.size() - 1);
            used[i] = false;
        }
    }
}
