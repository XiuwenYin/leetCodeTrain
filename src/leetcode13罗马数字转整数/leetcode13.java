package leetcode13罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

public class leetcode13 {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int val = map.get(arr[i]);
            if (i < n - 1 && val < map.get(arr[i + 1])) res -= val; // 例如 XIV 可视作 X − I + V = 10 − 1 + 5 = 14

            else res += val;
        }
        return res;
    }
}
