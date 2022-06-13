package leetcode47全排列II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode47 {
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
}
