package leetcode28;
// 实现strStr()
public class leetcode28 {
    /**
     * KMP算法
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int n = haystack.length(), m = needle.length();
        // 分别在字符串前加空格，使得其数组下表从1开始
        haystack = ' ' + haystack;
        needle = ' ' + needle;

        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();

        // 构建next数组，长度为加了空格后的匹配串长度
        int[] next = new int[m + 1];
        // 构造 i 从2开始，j 从0开始
        for (int i = 2, j = 0; i < m + 1; i++) {
            // 匹配不成功的话，j = next[j]，j 归零
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功，先让 j 右移，i 随着大for循环也会右移
            if (p[i] == p[j + 1]) j++;
            // 更新next数组，结束此次循环
            next[i] = j;
        }

        // 开始匹配，过程类似构造next
        for (int i = 1, j = 0; i < n + 1; i++) {
            // 匹配不成功的话 j = next[j];
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            // 如果 j 长度和匹配串长度相等，则找到第一个匹配串位置为 i - m 的位置开头
            if (j == m) return i - m;
        }
        return -1;
    }
}
