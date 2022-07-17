package leetcode91;

public class leetcode91 {
    /**
     * dp 从右到左
     */
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n + 1];
        return dfs(dp, s, n);
    }

    private int dfs(Integer[] dp, String s, int n) {
        if (n == 0) return 1;
        if (n == 1) return s.charAt(1) == '0' ? 0 : 1;
        if (dp[n] != null) return dp[n];

        int res = 0;
        char c1 = s.charAt(n - 1), c2 = s.charAt(n - 2);
        if (c1 != '0') res += dfs(dp, s, n - 1);

        int combine = (c2 - '0') * 10 + (c1 - '0');
        if (combine >= 10 && combine <= 26) {
            res += dfs(dp, s, n);
        }
        dp[n] = res;
        return res;
    }

    /**
     * dp 从左到右
     */
    public int numDecodings01(String s) {
        int n = s.length();
        s = " " + s;
        char[] charArr = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int c1 = charArr[i] - '0'; // 取出当前位置的值
            int c2 = (charArr[i - 1] - '0') * 10 + (charArr[i] - '0'); // 取出和前一位拼接在一起的值

            if (c1 >= 1 && c1 <= 9) dp[i] = dp[i - 1];
            if (c2 >= 10 && c2 <= 26) dp[i] += dp[i - 2]; // 注意这里，是+=
        }
        return dp[n];
    }
}

