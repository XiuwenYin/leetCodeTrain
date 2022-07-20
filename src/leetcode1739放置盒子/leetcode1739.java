package leetcode1739放置盒子;

public class leetcode1739 {
    public int minimumBoxes(int n) {
        int sum = 0, k = 1;
        while (sum + k * (k + 1) / 2 <= n) {
            sum += k * (k + 1) / 2;
            k++;
        }

        k--;
        int ans = k * (k + 1) / 2;
        k = 1;
        while (sum < n) {
            sum += k;
            k++;
            ans++;
        }
        return ans;
    }
}
