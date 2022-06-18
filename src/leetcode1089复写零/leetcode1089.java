package leetcode1089复写零;

public class leetcode1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int s = 0, f = 0;
        while (f < n) {
            if (arr[s] == 0) f++;
            s++;
            f++;
        }
        s--;
        f--;
        while (s >= 0) {
            if (f < n) arr[f] = arr[s];
            if (arr[s] == 0 && --f > 0) arr[f] = 0;
            s--;
            f--;
        }
    }
}
