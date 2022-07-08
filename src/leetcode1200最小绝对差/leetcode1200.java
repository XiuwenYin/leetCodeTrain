package leetcode1200最小绝对差;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int min = arr[1] - arr[0];
        for (int i = 0; i < n - 1; i++) {
            int cur = arr[i + 1] - arr[i];
            if (cur < min) {
                res.clear();
                min = cur;
            }
            if (cur == min) {
                List<Integer> level = new ArrayList<>();
                level.add(arr[i]);
                level.add(arr[i + 1]);
                res.add(new ArrayList<>(level));
            }
        }
        return res;
    }
}
