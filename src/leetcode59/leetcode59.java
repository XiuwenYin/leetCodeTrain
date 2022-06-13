package leetcode59;

public class leetcode59 {
    /**
     * 模拟
     * 直接按照题目要求，旋转输入数字，完成矩阵
     * 初始化矩阵的四个边界，按照先向左，（top++）再向下，（right--）再向左，（bottom--）在向上，（left++）的思路
     * 逐步缩小矩阵范围
     * 当获得的数字当前值等同于矩阵的面积值之后，表示矩阵已经填满，即可返回result
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int total = n * n;
        int count = 1;
        while (count  <= total) {
            for (int i = l; i <= r; i++) res[t][i] = count++;
            t++;
            for (int i = t; i <= b; i++) res[i][r] = count++;
            r--;
            for (int i = r; i >= l; i--) res[b][i] = count++;
            b--;
            for (int i = b; i >= t; i--) res[i][l] = count++;
            l++;
        }
        return res;
    }
}
