package leetcode556下一个更大元素III;

import java.util.Arrays;

public class leetcode556 {
    public int nextGreaterElement(int n) {
        // 转换成 char[]
        char[] s = String.valueOf(n).toCharArray();
        // 从后向前查找第一个相邻升序的元素对
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] > s[i - 1]) {
                // 从 i 开始排序
                Arrays.sort(s, i, s.length);
                // 从 i 开始向后找第一个比 i - 1 大的元素
                for (int j = i; j < s.length; j++) {
                    // 找到就交换
                    if (s[j] > s[i - 1]) {
                        char t = s[i - 1];
                        s[i - 1] = s[j];
                        s[j] = t;
                        // 判断是否为 32 位整数
                        long ans = Long.parseLong(String.valueOf(s));
                        if (ans > Integer.MAX_VALUE) return -1;
                        return (int) ans;
                    }
                }
            }
        }
        // 没有下一个更大的元素
        return -1;
    }
}
