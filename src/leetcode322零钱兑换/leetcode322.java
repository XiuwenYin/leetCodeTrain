package leetcode322零钱兑换;

import java.util.Arrays;

public class leetcode322 {
    int INF = 1000000000;
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 0; i < coins.length; i ++ )
            for (int j = coins[i]; j <= amount; j ++ ){
                f[j] = Math.min(f[j], f[j - coins[i]] + 1);
            }
        if (f[amount] == INF) f[amount] = -1;
        return f[amount] ;
    }
}
