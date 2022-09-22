package leetcode1640能否连接形成数组;

import java.util.HashMap;
import java.util.Map;

public class leetcode1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] x : pieces) map.put(x[0], x);
        for (int i = 0; i < arr.length; ) {
            if (!map.containsKey(arr[i])) return false;
            for (int temp : map.get(arr[i])) {
                if (arr[i++] != temp) return false;
            }
        }
        return true;
    }
}
