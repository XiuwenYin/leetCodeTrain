package leetcode46全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode46 {
    /**
     * 回溯
     * 这种写法更高效
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
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

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(res, nums, index + 1);
            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }


    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> permute01(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(res, nums, new ArrayList<>());
        return res;

    }

    private void backTracking(List<List<Integer>> res, int[] nums, List<Integer> level) {
        if (level.size() == nums.length) {
            res.add(new ArrayList<>(level));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (level.contains(nums[i])) continue; // 此处去重，但很慢，此处O(n)
            level.add(nums[i]);
            backTracking(res, nums, level);
            level.remove(level.size() - 1);
        }
    }
}
