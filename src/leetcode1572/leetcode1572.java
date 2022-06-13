package leetcode1572;
// 矩阵对角线元素的和


public class leetcode1572 {
    /**
     * 1. 暴力法，找规律（i == j 和 i + j = n - 1）
     */
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j =0; j < n; j++) {
                if (i == j || (i + j) == n - 1) {
                    res += mat[i][j];
                }
            }
        }
        return res;
    }

    /**
     * 2. 一次遍历
     *
     */
    public int diagonalSum02(int[][] mat) {
        int res = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
            res += mat[i][n - i - 1];

        }
        // 如果是奇数矩阵那么要减去一次重复的中心数字
        res -= mat[n / 2][n / 2]* (n & 1); // (n & 1) 判断n是否为奇数，是的话结果为1，否的话结果为0
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println((n & 1));
    }
}
