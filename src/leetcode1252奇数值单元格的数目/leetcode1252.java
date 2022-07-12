package leetcode1252奇数值单元格的数目;

public class leetcode1252 {
    /**
     * 方法1：
     * 朴素模拟
     *
     * @param m
     * @param n
     * @param indices
     * @return
     */
    public int oddCells(int m, int n, int[][] indices) {
        int res = 0;
        int[][] matrix = new int[m][n];
        for (int[] indice : indices) {
            for (int i = 0; i < m; i++) {
                matrix[i][indice[1]]++;
            }
            for (int j = 0; j < n; j++) {
                matrix[indice[0]][j]++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix[i][j] & 1) != 0) res++; // 位运算判断奇偶性
            }
        }
        return res;
    }


    /**
     * 方法2：
     * 模拟空间优化
     * 使用两个额外数组来分别保存row和col的增加值，最后加和来判断奇偶性
     *
     * @param m
     * @param n
     * @param indices
     * @return
     */
    public int oddCells01(int m, int n, int[][] indices) {
        int res = 0;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] indice : indices) {
            row[indice[0]]++;
            col[indice[1]]++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((row[i] + col[j]) & 1) != 0) res++;
            }
        }
        return res;
    }


    /**
     * 方法3：
     * 数学方法
     * @param m
     * @param n
     * @param indices
     * @return
     */
    public int oddCells02(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int oddx = 0, oddy = 0;
        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) != 0) {
                oddx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((cols[i] & 1) != 0) {
                oddy++;
            }
        }
        return oddx * (n - oddy) + (m - oddx) * oddy;
    }

}
