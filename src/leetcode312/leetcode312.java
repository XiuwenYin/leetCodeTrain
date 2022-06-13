package leetcode312;

public class leetcode312 {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        //创建一个n+2的数组，开头和末尾都填1
        int[] arr = new int[n + 2];
        for(int i = 1; i <= n; ++i) {
            arr[i] = nums[i - 1];
        }
        arr[0]= 1;
        arr[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        //从下往上遍历，i控制左边界，j控制右边界
        for(int i = n - 1; i >= 0; --i) {
            for(int j = i + 2; j <= n + 1; ++j) {
                //k在(i,j)范围内遍历气球，计算每选择一个气球的积分
                //一轮遍历完后，就能确定(i,j)的最大积分
                for(int k = i + 1; k < j; ++k) {
                    int total = arr[i] * arr[k] * arr[j];
                    total += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], total);
                }
            }
        }
        return dp[0][n + 1];
    }
}
