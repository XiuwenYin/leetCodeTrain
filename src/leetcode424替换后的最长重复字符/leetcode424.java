package leetcode424替换后的最长重复字符;

import java.util.Arrays;

public class leetcode424 {
    /**
     * 滑动窗口
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int left = 0, res = 0;
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'A']++; // 计算每一个字符的出现次数
            /* i - left + 1 是窗口的长度；findMax()是找到count中出现次数最多的字符的次数，
            这两个的差值就是需要替换的字符数量，如果这个值大于k，则invalid */
            while (i - left + 1 - findMax(count) > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, i - left + 1);

        }
        return res;
    }

    private int findMax(int[] count) {
        return Arrays.stream(count).max().getAsInt();
    }

    /**
     * 快慢指针
     * 避免统一获取count中最大值，每次用Math.max()计算取一个局部变量
     * 之后同理
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement01(String s, int k) {
        int n = s.length();
        int max = 0;
        int left = 0, right = 0;
        int[] count = new int[26];
        while (right < n) {
            char c = s.charAt(right);
            count[c - 'A']++;
            max = Math.max(max, count[c - 'A']);
            if (right - left + 1 - max > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
