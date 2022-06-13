package leetcode1672;

// 最富有客户的资产总量

/**
 * 暴力解，用Math.max()判断
 */
public class leetcode1672 {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int m = accounts.length, n = accounts[0].length;
        for (int[] account : accounts) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp += account[j];
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
