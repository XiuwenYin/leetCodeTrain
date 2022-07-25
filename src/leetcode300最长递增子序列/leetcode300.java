package leetcode300最长递增子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode300 {
    /**
     * dp
     * O(n2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 注意这里
        int res = 1;
        for (int i = 1; i < n; i++) { // 注意限制条件
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]); // 注意这里
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    /**
     * 构造sub-sequence
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS01(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (cur > sub.get(sub.size() - 1)) sub.add(cur);
            else {
                int j = 0;
                while (cur > sub.get(j)) j++; // 找到第一位比cur大的数字的位置
                sub.set(j, cur); // 替换这个位置为cur
            }
        }
        return sub.size(); // 构造出来的长度是final answer 但具体内容并不是，仅仅只是长度相同
    }

    /**
     * 构造sub-sequence + 二分查找
     * 前面都一样
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS02(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (cur > sub.get(sub.size() - 1)) sub.add(cur);
            else {
                int j = binarySearch(sub, cur);
                sub.set(j, cur);
            }
        }
        return sub.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = list.get(mid);
            if (cur < target) {
                left = mid + 1;
            } else if (cur >= target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }


    /**
     * 用这个
     * 通过把每次后面更大的调到前面
     */
    public int lengthOfLIS03(int[] nums) {
        int n = nums.length;
        int left = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[left]) {
                nums[++left] = nums[i];
            } else {
                int k = left;
                while (k >= 0 && nums[k] >= nums[i]) {
                    k--;
                }
                nums[k + 1] = nums[i];
            }
        }
        return left + 1;
    }

}
