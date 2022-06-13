package leetcode467;

import sun.jvm.hotspot.debugger.win32.coff.WindowsNTSubsystem;

public class leetcode467 {
    /**
     * 线性dp
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        if (n == 1) return 1;
        int[] dp = new int[26];
        int res = 0, count = 0;
        for (int i = 0; i < n; i++) {
            char cur = p.charAt(i);
            if (i > 0 && (cur - p.charAt(i - 1) == 1 || p.charAt(i - 1) - cur == 25)) {
                count++;
            } else {
                count = 1;
            }
            dp[cur - 'a'] = Math.max(dp[cur - 'a'], count);
        }
        for (int x : dp) {
            res += x;
        }
        return res;
    }

    /**
     * 线性dp，本质相同
     * @param p
     * @return
     */
    public int findSubstringInWraproundString01(String p) {
        int[] dp = new int[26];
        int n = p.length();
        int res = 0;
        dp[p.charAt(0) - 'a']++;
        for (int i = 1, count = 1; i < n; i++) {
            char cur = p.charAt(i), pre = p.charAt(i - 1);
            if ((cur - 'a' == 0 && pre - 'a' == 25) || (cur - pre == 1)) {
                count++;
            } else {
                count = 1;
            }
            dp[cur] = Math.max(dp[cur], count);
        }
        for (int x : dp) res += x;
        return res;
    }
}
