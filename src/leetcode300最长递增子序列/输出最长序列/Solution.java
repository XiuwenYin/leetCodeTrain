package leetcode300最长递增子序列.输出最长序列;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // f[i] 表示以下标i结尾的最长上升子序列的长度
        // g[i] 表示以下标i结尾的最长上升子序列是从哪个下标转移过来的
        int[] dp = new int[n], graph = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            graph[i] = -1;  // -1表示这个序列只有一个数，没有转移
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        graph[i] = j;   // 更新长度的同时，记录转移来源
                    }
                }
            }
        }

        // 用k来记录最长上升子序列结尾数字的下标
        // ans 是最长上升子序列的长度
        int ans = 1, k = 0;
        for (int i = 0; i < n; i++) {
            k = dp[k] < dp[i] ? i : k;
            ans = dp[k];
        }

        // 下面是逆序输出最长子序列
        // 当 k=-1 的时候，表示该数是序列中的第一个数，输出到此为止
        while (k >= 0) {
            System.out.print(nums[k] + " ");
            k = graph[k];
        }
        System.out.println();

        return ans;
    }
}
