package leetcode54螺旋矩阵;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return result;
        int m = matrix.length, n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int tol = m * n;
        while (tol >= 1) {
            // 从一个挡板起，到一个挡板结束；每次循环都要判断当前还有无tol剩余
            for (int i = left; i <= right && tol >= 1; i++) {
                result.add(matrix[top][i]);
                tol--;
            }
            top++;
            for (int i = top; i <= bottom && tol >= 1; i++) {
                result.add(matrix[i][right]);
                tol--;
            }
            right--;
            for (int i = right; i >= left && tol >= 1; i--) {
                result.add(matrix[bottom][i]);
                tol--;
            }
            bottom--;
            for (int i = bottom; i >= top && tol >= 1; i--) {
                result.add(matrix[i][left]);
                tol--;
            }
            left++;
        }
        return result;
    }
}
