package leetcode140;

import java.util.*;

public class leetcode140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> hashSet = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && hashSet.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (dp[n]) {
            Deque<String> deque = new ArrayDeque<>();
            dfs(s, n, hashSet, dp, deque, res);
            return res;
        }
        return res;
    }

    private void dfs(String s, int n, Set<String> hashSet, boolean[] dp, Deque<String> deque, List<String> res) {
        if (n == 0){
            res.add(String.join(" ", deque));
            return;
        }
        for (int i = n - 1; i >= n; i--) {
            // 倒着来
            String sub = s.substring(i, n);
            if(dp[i] && hashSet.contains(sub)) {
                deque.offer(sub);
                dfs(s, i, hashSet, dp, deque, res);
                deque.removeFirst();
            }
        }
    }
}
