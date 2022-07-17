package leetcode696计数二进制子串;

import java.util.ArrayList;
import java.util.List;

public class leetcode696 {
    /**
     * 模拟：按照字符分组
     * 我们可以将字符串 s 按照 0 和 1 的连续段分组，存在 counts 数组中，
     * 例如 s = 00111011，可以得到这样的 counts 数组：counts={2,3,1,2}。
     *
     * 这里 counts 数组中两个相邻的数一定代表的是两种不同的字符。假设 counts 数组中两个相邻的数字为 u 或者 v，
     * 它们对应着 u 个 0 和 v 个 1，或者 u 个 1 和 v 个 0。
     * 它们能组成的满足条件的子串数目为 min{u,v}，即一对相邻的数字对答案的贡献。
     * 我们只要遍历所有相邻的数对，求它们的贡献总和，即可得到答案。
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int n = s.length();
        List<Integer> cnts = new ArrayList<>();
        int ptr = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int cnt = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ptr++;
                cnt++;
            }
            cnts.add(cnt);
        }
        int res = 0;
        for (int i = 1; i < cnts.size(); i++) {
            res += Math.min(cnts.get(i - 1), cnts.get(i));
        }
        return res;
    }

    /**
     * 优化后使用单一变量存储最后的cnt，每次更新res值
     * @param s
     * @return
     */
    public int countBinarySubstrings01(String s) {
        int ptr = 0, n = s.length(), last = 0, res = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            res += Math.min(count, last);
            last = count;
        }
        return res;
    }
}
