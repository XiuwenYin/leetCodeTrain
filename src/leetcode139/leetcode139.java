package leetcode139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode139 {
    /*
    dp + dfs
    初始化长度为 n + 1的boolean[]（由于substring左开右闭的特性），重构hashSet的wordDict（查询速度比List更快）
    三挡板：0，i，n
    在dfs函数中：每次从index = 0开始向n遍历，定义局部变量right，表示是否有 i-n包含于wordDict中；每次i向n靠近，切割整个字符串
    如果存在从 i-n的substring包含于wordDict中，则更新长度为i，
    调用dfs并把新长度带入，如此往复直到带入的i = 0，返回dp[n]
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

    /*
    dp
    四个挡板：0，j，i，n
    这个解法是：从index 1开始，逐渐向右遍历，
    在此过程中，对于 index左边的 substring从0开始到 index遍历
    如果 0-j为true（wordDict包含此子串）则同时考虑 j-i是否为true，如果是，则表明0-i为true（使用子问题的答案解决当前问题）
    如此往复，直到i位于n + 1（由于substring左开右闭的特性）
    时间复杂度相比上面的解法要高
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
}
