package leetcode1229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1229 {
    /**
     * 此题和 986题基本一致
     * @param slots1
     * @param slots2
     * @param duration
     * @return
     */
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int i = 0, j = 0;
        int m = slots1.length, n = slots2.length;
        while (i < m && j < n) {
            int intersectStart = Math.max(slots1[i][0], slots2[j][0]); // 对于不同的slot，开始时间取最晚的（max）
            int intersectEnd = Math.min(slots1[i][1], slots2[j][1]); // 对于不同的slot，结束时间取最早的（min）
            if (intersectEnd - intersectStart >= duration) {
                res.add(intersectStart);
                res.add(intersectStart + duration);
                return res;
            } else if (slots1[i][1] < slots2[j][1]){ // 较早结束的换成下一个slot，由于这里答案仅需要一个，所以是 elif，和986不同
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
