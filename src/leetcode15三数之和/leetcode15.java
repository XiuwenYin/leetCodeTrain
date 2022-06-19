package leetcode15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 在 i + 1 ... nums.length - 1 中查找相加等于 -nums[i] 的两个数
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum01(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // skip上一步和这一步相同的数字
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int cur = nums[i] + nums[left] + nums[right];
                if (cur == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    // skip相同的数字
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (cur < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}

