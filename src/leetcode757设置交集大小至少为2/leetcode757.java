package leetcode757设置交集大小至少为2;

import java.util.Arrays;

public class leetcode757 {
    public int intersectionSizeTwo(int[][] intervals) {
        // 对区间右侧进行升序排列，左侧进行降序排列
        Arrays.sort(intervals, (a, b) -> (a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]));
        int a = -1, b = -1, res = 0; // a为次最大，b为最大
        for (int[] x : intervals) {
            // 两种情况，当前x[0] 大于b，则表示无任何可以覆盖这个区间，更新a,b，更新res+=2
            if (x[0] > b) {
                b = x[1];
                a = x[1] - 1;
                res += 2;
            } else if (x[0] > a) { // 如果是当前x[0]大于a，说明仍能被b覆盖，用a替换b，b更新为x[1]，res++
                a = b;
                b = x[1];
                res++;
            }
        }
        return res;
    }
}
