package 面试题.古生物血缘远近判定;

import java.util.*;
import java.lang.*;


public class Solution {
    /**
     * 就是leetcode第72题编辑距离
     * @param s
     * @param t
     * @return
     */
    public static int minDiff(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) dp[i][0] = i;
        for (int j = 0; j <= n2; j++) dp[0][j] = j;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = t.charAt(j - 1);
                if (c1 != c2) dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                else dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String input = "";
        // get character stream from keyboard
        if (scan.hasNext()) {
            input = scan.nextLine();
        }
        scan.close();
        String[] array = input.split(",");
        System.out.println(minDiff(array[0] , array[1]));

    }
}