package leetcode498;

import java.util.ArrayList;
import java.util.Collections;

public class leetcode498 {
    public int[] findDiagonalOrder(int[][] mat) {
        // 检察是否为空
        if (mat.length == 0) {
            return new int[0];
        }
        // 获取矩阵大小
        int m = mat.length, n = mat[0].length;

        // 初始化结果
        int[] res = new int[m * n];
        int k = 0;
        ArrayList<Integer> mid = new ArrayList<Integer>();

        // 遍历数组 第一行 和 最后一列 保证不会落下任何一个角落
        for (int i = 0; i < m + n; i++) {
            // 每次都清空 mid
            mid.clear();

            // 找到头
            int x = i < m ? 0 : i - m - 1;
            int y = i < m ? i : m - 1;

            //
            while(x < n && y > -1) {
                mid.add(mat[x][y]);
                ++x;
                --y;
            }
            if (i % 2 == 0) {
                Collections.reverse(mid);
            }
            for (int j = 0; j < mid.size(); j++) {
                res[k++] = mid.get(j);
            }
        }
        return res;
    }
}
