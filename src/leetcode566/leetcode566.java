package leetcode566;
// 重塑矩阵
public class leetcode566 {
    /**
     * 二维数组的一维遍历
     * 对于 x∈ [0,mn)，第 x 个元素在 nums 中对应的下标为 (x / n, x % n) 而在新的重塑矩阵中对应的下标为 (x / c,x % c)。我们直接进行赋值即可
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int x = 0; x < m * n; x++) {
            // 关键
            res[x / c][x % c] = mat[x / n][x % n];
        }
        return res;
    }
}
