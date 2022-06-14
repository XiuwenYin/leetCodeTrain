package leetcode498对角线遍历;

import java.util.ArrayList;
import java.util.Collections;

public class leetcode498 {
    public int[] findDiagonalOrder(int[][] mat) {
        // 检察是否为空
        if (mat.length == 0) return new int[0];
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
            while (x < n && y > -1) {
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

    /**
     * 模拟
     *
     * @param
     * @return
     */
    public int[] findDiagonalOrder01(int[][] g) {
        int n = g.length, m = g[0].length, cnt = n * m;
        int[] ans = new int[cnt];
        int x = 0, y = 0, dir = 1, idx = 0;
        while (idx != cnt) {
            ans[idx++] = g[x][y];
            int nx = x, ny = y;
            if (dir == 1) {
                nx = x - 1;
                ny = y + 1;
            } else {
                nx = x + 1;
                ny = y - 1;
            }
            if (idx < cnt && (nx < 0 || nx >= n || ny < 0 || ny >= m)) {
                if (dir == 1) {
                    nx = y + 1 < m ? x : x + 1;
                    ny = y + 1 < m ? y + 1 : y;
                } else {
                    nx = x + 1 < n ? x + 1 : x;
                    ny = x + 1 < n ? y : y + 1;
                }
                dir *= -1;
            }
            x = nx;
            y = ny;
        }
        return ans;
    }

}
