package leetcode370区间加法;

public class leetcode370 {
    /**
     * lazy propagation
     * 懒惰更新/惰性传播/延迟更新
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            res[start] += val;
            if (end + 1 < length)  res[end + 1] -= val;
        }
        int temp = res[0];
        for (int i = 1; i < length; i++) {
            res[i] += temp;
            temp = res[i];
        }
        return res;
    }
}
