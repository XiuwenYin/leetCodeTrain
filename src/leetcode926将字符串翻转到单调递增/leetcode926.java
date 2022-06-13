package leetcode926将字符串翻转到单调递增;

public class leetcode926 {
    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = dp[i][0];
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]);
            if (arr[i] == '1') {
                dp[i + 1][0]++;
            } else {
                dp[i + 1][1]++;
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}
