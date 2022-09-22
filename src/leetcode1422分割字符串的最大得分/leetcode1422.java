package leetcode1422分割字符串的最大得分;

public class leetcode1422 {
    /**
     * 两次遍历
     * 第一次以左区间仅有s第0位，右区间为剩下全部，计算cur，以此为基准
     * 之后遍历 [1, n - 1]，类似滑动窗口，每次碰到1则cur--，0则cur++，每次取Max赋值给res
     * @param s
     * @return
     */
    public int maxScore(String s) {
        int n = s.length();
        int res = 0, cur = 0;
        if (s.charAt(0) == '0') cur++;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') cur++;
        }
        res = cur;
        for (int i = 1; i < n - 1; i++) {
            char c = s.charAt(i);
            if (c == '1') cur--;
            else cur++;

            res = Math.max(res, cur);
        }
        return res;
    }
}
