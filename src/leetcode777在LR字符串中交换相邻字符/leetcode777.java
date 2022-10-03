package leetcode777在LR字符串中交换相邻字符;

public class leetcode777 {
    /**
     * 双指针（单向）
     *
     * 根据题意，我们每次移动要么是将 XL 变为 LX，要么是将 RX 变为 XR，而该两者操作可分别看做将 L 越过多个 X 向左移动，将 R 越过多个 X 向右移动。
     * 因此在 start 和 end 中序号相同的 L 和 R 必然满足坐标性质：
     * 序号相同的 L : start 的下标不小于 end 的下标（即 L 不能往右移动）
     * 序号相同的 R : start 的下标不大于 end 的下标（即 R 不能往左移动）
     *
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i == n || j == n) return i == j;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return i == j;
    }
}
