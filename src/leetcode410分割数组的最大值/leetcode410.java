package leetcode410分割数组的最大值;

public class leetcode410 {
    /*
    二分查找
     */
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;

        // 获取 数组中的最大值 和 数组的总和，这就是二分的区间
        // 因为如果每个数组中的数字都分割，则数组最大值是数组最大值
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // 通常二分模板
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int split = splits(nums, mid);
            // 如果分割次数大于了目标次数m，则说明 「子数组的各自的和的最大值太小」，需要将子数组各自的和的最大值调大
            // 下一次分割区间是[mid + 1, max]
            if (split > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * @param nums           原数组
     * @param maxIntervalSum 子数组各自的和的最大值
     * @return 满足不超过「子数组各自的和的最大值」的分割数
     */
    public int splits(int[] nums, int maxIntervalSum) {
        // 最小分割为1
        int split = 1;

        // 当前区间的和
        int currIntervalSum = 0;
        for (int num : nums) {
            // 看看当前遍历的数字与当前区间和相加是否大于最大子数组区间和
            // 超过了就不添加，并把当前区间的和归零（另开区间），并且分割值增加
            if (currIntervalSum + num > maxIntervalSum) {
                currIntervalSum = 0;
                split++;
            }
            // 无论朝不超过都需要在现在的区间中加入当前遍历的数字
            currIntervalSum += num;
        }
        return split;
    }


    /*
    dp + 前缀和 （记忆）
     */
    Integer[][] dp;
    int[] prefix;

    public int splitArray01(int[] nums, int m) {
        int n = nums.length;
        // 创建dp，创建前缀和
        dp = new Integer[m + 1][n + 1];
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
        return dfs(nums, m, n);
    }

    private int dfs(int[] nums, int m, int n) {
        // 如果 m = 1，代表只分成1份 = 没有分割直接返回sum(nums)等于返回前缀和[n]
        if (m == 1) return prefix[n];
        // 如果分割份数大于数组长度，则无法完成，直接返回 -1
        if (m > n) return -1;
        // 如果当前位置已经处理过了则直接返回 dp[m][n]
        if (dp[m][n] != null) return dp[m][n];

        // 初始化 res 为Integer最大值
        int res = Integer.MAX_VALUE;
        // 直接对 n 进行遍历
        for (int i = 0; i < n; i++) {
            // 左半边递归
            int left = dfs(nums, m - 1, i);
            // 如果左边违法，则直接下一轮循环
            if (left == -1) continue;
            // 如果左边不违法，则用当前 i 和 n 求出右侧和
            int right = prefix[n] - prefix[i];
            // left 和 right 取最大
            int level = Math.max(left, right);
            // res 取最小
            res = Math.min(res, level);
        }
        // 判断 res 是否违法
        res = res == Integer.MAX_VALUE ? -1 : res;
        return dp[m][n] = res;
    }

    /*
    正向dp
     */
    public int splitArray02(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[1][i + 1] = dp[1][i] + nums[i];
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k < j; k++) {
                    int left = dp[i - 1][k];
                    int right = dp[1][j] - dp[1][k];
                    int level = Math.max(left, right);
                    dp[i][j] = Math.min(dp[i][j], level);
                }
            }
        }
        return dp[m][n];
    }
}
