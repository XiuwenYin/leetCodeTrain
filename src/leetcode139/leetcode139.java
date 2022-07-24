package leetcode139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode139 {
    /**
     * dp + dfs
     * 初始化长度为 n + 1的boolean[]（由于substring左开右闭的特性），重构hashSet的wordDict（查询速度比List更快）
     * 三挡板：0，i，n
     * 在dfs函数中：每次从index = 0开始向n遍历，定义局部变量right，表示是否有 i-n包含于wordDict中；每次i向n靠近，切割整个字符串
     * 如果存在从 i-n的substring包含于wordDict中，则更新长度为i，
     * 调用dfs并把新长度带入，如此往复直到带入的i = 0，返回dp[n]
     */
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n + 1];
        return dfs(s, n, new HashSet<>(wordDict));
    }

    private boolean dfs(String s, int len, HashSet<String> wordDict) {
        if (len == 0) return true;
        if (dp[len] != null) return dp[len];

        dp[len] = false;
        for (int i = 0; i < len; i++) {
            boolean right = wordDict.contains(s.substring(i, len));
            if (!right) {
                continue;
            }
            boolean left = dfs(s, i, wordDict);
            if (left) {
                dp[len] = true;
                break;
            }
        }
        return dp[len];
    }

    /**
     * dp
     * 四个挡板：0，j，i，n
     * 这个解法是：从index 1开始，逐渐向右遍历，
     * 在此过程中，对于 index 左边的 substring 从 0 开始到 index遍历
     * 如果 0-j为true（wordDict包含此子串）则同时考虑 j-i是否为true，如果是，则表明0-i为true（使用子问题的答案解决当前问题）
     * 如此往复，直到i位于n + 1（由于substring左开右闭的特性）
     * 时间复杂度相比上面的解法要高
     */
    public boolean wordBreak01(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // substring左闭右开，所以要n + 1
        dp[0] = true;
        Set<String> hashSet = new HashSet<>(wordDict);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * 更快
     * 类似01
     * dp[i]表示字符串的前 i 个字母构成的字符子串能否由字典中的字符串表示
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak02(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;//默认每个字典中包含空字符串
        Set<String> hash = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) { // 注意边界
            for (int j = 1; j <= i; j++) { // 注意边界
                String temp = s.substring(i - j, i); // i 无需 + 1
                if (dp[i - j] && hash.contains(temp)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /**
     * 更更快
     * 类似00
     */
    public boolean wordBreak03(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        boolean res = wordBreakBacking(s, wordDict, 0, dp);
        return res;
    }

    private boolean wordBreakBacking(String s, List<String> wordDict, int index, Boolean[] dp) {
        if (index == s.length()) return true; // idx到达末尾则为true
        if (dp[index] != null) return dp[index]; // 如果当前dp的idx位置不为空则返回
        boolean check;
        for (String word : wordDict) { // 对字典的每一个进行遍历
            if (wordBreakCheck(s, word, index)) { // 如果从当前idx起的每一位char都匹配，则成功匹配这个单词
                // 则递归，并且由于字典中单词可以重复使用，则对每一个字典中的元素都进行递归匹配
                check = wordBreakBacking(s, wordDict, index + word.length(), dp);
                if (check) {
                    dp[index] = true;
                    return true;
                }
            }
        }
        dp[index] = false;
        return false;
    }

    private boolean wordBreakCheck(String s, String word, int index) {
        for (int i = 0; i < word.length(); i++) {
            if (index + i >= s.length() || s.charAt(index + i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
