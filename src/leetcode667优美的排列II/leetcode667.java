package leetcode667优美的排列II;

public class leetcode667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int t = n - k - 1;
        for (int i = 0; i < t; i++) ans[i] = i + 1;
        for (int i = t, a = n - k, b = n; i < n; ) {
            ans[i++] = a++;
            if (i < n) ans[i++] = b--;
        }
        return ans;
    }
}

