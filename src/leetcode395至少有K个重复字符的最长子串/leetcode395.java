package leetcode395至少有K个重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class leetcode395 {
    /**
     * 递归最基本的是记住递归函数的含义（务必牢记函数定义）：
     * 本题的 longestSubstring(s, k) 函数表示的就是题意，即求一个最长的子字符串的长度，该子字符串中每个字符出现的次数都最少为 k。
     * 函数入参 s 是表示源字符串；k 是限制条件，即子字符串中每个字符最少出现的次数；函数返回结果是满足题意的最长子字符串长度。
     *
     * 递归的终止条件（能直接写出的最简单 case）：
     * 如果字符串 s 的长度少于 k，那么一定不存在满足题意的子字符串，返回 0；
     *
     * 调用递归（重点）：如果一个字符 c 在 s 中出现的次数少于 k 次，
     * 那么 s 中所有的包含 c 的子字符串都不能满足题意。
     * 所以，应该在 s 的所有不包含 c 的子字符串中继续寻找结果：
     * 把 s 按照 c 分割（分割后每个子串都不包含 c），得到很多子字符串 t；
     * 下一步要求 t 作为源字符串的时候，它的最长的满足题意的子字符串长度（到现在为止，我们把大问题分割为了小问题(s → t)）。
     * 此时我们发现，恰好已经定义了函数 longestSubstring(s, k) 就是来解决这个问题的！
     * 所以直接把 longestSubstring(s, k) 函数拿来用，于是形成了递归。
     *
     * 未进入递归时的返回结果：
     * 如果 s 中的每个字符出现的次数都大于 k 次，那么 s 就是我们要求的字符串，直接返回该字符串的长度。
     *
     * 作者：fuxuemingzhu
     */
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n < k) return 0;
        if (k == 1) return n;

        int[] cnt = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(cnt[i] > 0 && cnt[i] < k) {
                int res = 0;
                for (String t : s.split(String.valueOf((char) (i + 'a')))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return n;
    }
}
