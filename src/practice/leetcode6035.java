package practice;

import java.util.HashMap;
import java.util.Map;

public class leetcode6035 {
    public long numberOfWays01(String s) {
        int n = s.length();
        Map<Integer, Integer> hashMap = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] - '0';
            hashMap.put(x, i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) continue;
                for (int k = j + 1; k < n; k++) {
                    if (s.charAt(k) == s.charAt(j)) continue;
                    res += 1;
                }
            }
        }
        return res;
    }


}
