package leetcode135分发糖果;

import java.util.Arrays;

public class leetcode135 {
    /**
     * 类似第42题接雨水
     * 双dp
     * 射线法：左面一条线扫向右侧，每次比较两个孩子大小，大了就dp[i - 1] + 1，小了就dp[i]; 右侧类似
     * left[] 和right[]初始填充1
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1); // dp初始化
        Arrays.fill(right, 1);
        int res = 0;
        for (int i = 1; i < n; i++) left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : left[i];
        for (int i = n - 2; i >= 0; i--) right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : right[i];
        for (int i = 0; i < n; i++) res += Math.max(left[i], right[i]); // res取二者最大后加和
        return res;
    }

    /**
     * 贪心，单数组dp
     */
    public int candy01(int[] ratings) {
        //贪心算法 局部最优到全局最优
        int[] candy = new int[ratings.length];
        int sum = 0;
        // 首先将dp所有元素赋值为1
        for (int i = 0; i < ratings.length; ++i) {
            candy[i] = 1;
        }
        // 扫描线从左边来
        for (int i = 0; i < ratings.length - 1; ++i) {
            if (ratings[i + 1] > ratings[i]) {
                candy[i + 1] = candy[i] + 1;
            }
        }
        // 扫描线从右边来
        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i] < ratings[i - 1] && candy[i - 1] <= candy[i]) {
                candy[i - 1] = candy[i] + 1;
            }
        }
        // 取值相加就是结果
        for (int i = 0; i < ratings.length; ++i) {
            sum += candy[i];
        }
        return sum;
    }
}
