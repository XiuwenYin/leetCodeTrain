package leetcode1175质数排列;

import java.util.ArrayList;
import java.util.List;

public class leetcode1175 {
    static int MOD = (int) 1e9 + 7;
    static List<Integer> list = new ArrayList<>();

    // 用静态代码块执行一次，100个数中将质数放入list中(此题边界条件是最多n = 100)
    static {
        for (int i = 2; i <= 100; i++) {
            boolean ok = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) ok = false;
            }
            if (ok) list.add(i);
        }
    }

    public int numPrimeArrangements(int n) {
        int l = 0, r = list.size() - 1;
        while (l < r) { // 二分是为了更快找到n的前一位的质数
            int mid = l + r + 1 >> 1;
            if (list.get(mid) <= n) l = mid;
            else r = mid - 1;
        }
        int a = r + 1, b = n - a;
        long ans = 1;
        for (int i = b; i > 1; i--) ans = ans * i % MOD; // 全排列求阶乘
        for (int i = a; i > 1; i--) ans = ans * i % MOD; // 全排列求阶乘
        return (int) ans;
    }
}
