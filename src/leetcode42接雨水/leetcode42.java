package leetcode42接雨水;

import java.util.Deque;
import java.util.LinkedList;

// 接雨水
public class leetcode42 {
    /**
     * 一列一列求解
     * 对height进行遍历
     * 在第i位置时，找到左边最高（0 ~ i），再找到右边最高（i ~ height.length）
     * 取两者最小值，再和height[i]对比
     * 如果大于，则能盛水；如果小于，则不能盛水
     * 能盛水的情况下，两者最小值减去height[i]就是盛水量，+=到答案中即可
     * 时间复杂度：数组本质遍历2次，On2
     * 空间复杂度：1
     */
    public int trap01(int[] height) {
        int sum = 0;
        // 两端不会有水，所以必定不用考虑（i从1起，到长度-1结束）
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i - 1; j >= 0; j--) { // 左挡板最大
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) { // 右挡板最大
                maxRight = Math.max(maxRight, height[j]);
            }
            int min = Math.min(maxLeft, maxRight); // 木桶原理，两挡板取最小
            if (min > height[i]) { // 最小要是比当前i位置挡板要矮的话就没有意义了（盛不了水，根本不是凹陷）
                sum += min - height[i];
            }
        }
        return sum;
    }


    /**
     * DP
     *  !!理解这个最好，也容易理解!!
     * 使用两个数组，分别表示第i位置左边或者右边的最大高度
     * 左最大：比较 i 的前一位最大高度和 i 的前一位墙的高度，从左到右遍历
     * 右最大：比较 i 的后一位最大高度和 i 的后一位墙的高度，从右到左遍历
     * 之后的步骤和上面一样
     * 时间复杂度：On
     * 空间复杂度：On
     */
    public int trap02(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        // 求 maxLeft
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        // 求 maxRight
        for (int i = height.length - 2; i >= 0; i--) { // 注意边界条件
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    /**
     * 双指针前的改造
     * 将maxLeft由数组改变成为变量
     * 并添加入主遍历中，每次使用时进行判断即可
     */
    public int trap03(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int[] maxRight = new int[height.length];
        // 求 maxRight
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        // 利用 maxLeft[]的遍历顺序和主遍历顺序一致
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = Math.min(maxLeft, maxRight[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    /**
     * 双指针
     * 思想：既然maxLeft从左到右遍历可以被省略为变量，那么maxRight也可以从右到左遍历省略为变量
     * 所以需要左右指针
     * 例如：如果当前右侧小于左侧，则一步步逼近左侧找到比左侧更高的值，这期间都是左大于右所以只需要判断右侧最大高度即可
     */
    public int trap04(int[] height) {
        int sum = 0;
        int maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i - 1] < height[i + 1]) {
                maxLeft = Math.max(maxLeft, height[i - 1]);
                int min = maxLeft;
                if (min > height[i]) {
                    sum += min - height[i];
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[i + 1]);
                int min = maxRight;
                if (min > height[i]) {
                    sum += min - height[i];
                }
                right--;
            }
        }
        return sum;
    }


    /**
     * dp 动态规划
     * 属于上面第二种的更简化版
     * 考虑从左面射过来一道光，再从右面射过来一道光，阴影就是水的面积
     */
    public int trap05(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] left = new int[n], right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        int res = 0;
        for (int i = 1; i < n; i++) left[i] = Math.max(left[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--) right[i] = Math.max(right[i + 1], height[i]);
        for (int i = 0; i < n; i++) res = Math.min(left[i], right[i]) - height[i];
        return res;
    }

    /**
     * 单调栈用法
     * 只有高度由低变高才能储水，不然递减的话是无法储水的
     * @param height
     * @return
     */
    public int trap06(int[] height) {
        int n = height.length;
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pre = stack.pop();
                if (stack.isEmpty()) break; // 池子空了无法储水
                int minHight = Math.min(height[i], height[stack.peek()]);
                res += (minHight - height[pre]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }
}
