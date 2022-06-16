package leetcode719找出第K小的数对距离;

import java.util.Arrays;

public class leetcode719 {
    /**
     * 给定距离mid，计算所有距离小于等于mid的数对数目cnt可以使用双指针：
     * 初始左端点i=0，我们从小到大枚举所有数对的右端点j，移动左端点直到 nums[j] - nums[i] ≤ mid，
     * 那么右端点为 j 且距离小于等于 mid 的数对数目为 j - i，计算这些数目之和。
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = nums[n - 1] - nums[0];
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            int cnt = 0;
            for (int i = 0, j = 0; i < n; i++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                cnt += j - i;
            }
            if (cnt >= k) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
