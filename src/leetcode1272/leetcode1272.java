package leetcode1272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1272 {
    /**
     * 先判断是否重叠，如果cur的右边比目标的左边要小，或者如果cur的左边比目标的右边要大，则说明没有重叠
     * 如果重叠，则判断cur的左边是否小于目标的左边，如果是，则添加 Arrays.asList(cur[0], toBeRemoved[0])
     * 或者另一种情况，cur的右边是否大于目标的右边，如果是，则添加 Arrays.asList(toBeRemoved[1], cur[1])
     *
     * @param intervals
     * @param toBeRemoved
     * @return
     */
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] cur : intervals) {
            if (cur[1] <= toBeRemoved[0] || cur[0] >= toBeRemoved[1]) { // 没有重叠
                res.add(Arrays.asList(cur[0], cur[1]));
            } else {
                if (cur[0] < toBeRemoved[0]) res.add(Arrays.asList(cur[0], toBeRemoved[0]));
                if (cur[1] > toBeRemoved[1]) res.add(Arrays.asList(toBeRemoved[1], cur[1]));
            }
        }
        return res;
    }
}
