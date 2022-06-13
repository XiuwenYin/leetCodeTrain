package leetcode240;

public class leetcode240 {
    /**
     * 普通二分查找
     * 对每一行
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] x : matrix) {
            if (binarySearch(x, target)) {
                return true;
            }
        }
        return false;

    }

    public boolean binarySearch(int[] subMatrix, int target) {
        int left = 0, right = subMatrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (subMatrix[mid] > target) {
                right = mid - 1;
            } else if (subMatrix[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Z字形查找，从右上角开始形成以左下角和现在坐标的矩阵进行查找
     * 如果matrix[x][y] > target, 则 y--;
     * 如果matrix[x][y] < target, 则 x++;
     */
    public boolean searchMatrix01(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] < target) {
                ++x;
            } else {
                --y;
            }
        }
        return false;
    }

}
