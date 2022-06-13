package 剑指Offer38.字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class jianzhi38 {
    /**
     * 和47题没有本质区别，也是set去重，然后交换-回溯-交换
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        backTracking(arr, res, 0);
        return res.toArray(new String[res.size()]);
    }

    private void backTracking(char[] arr, List<String> res, int index) {
        if (index == arr.length - 1) {
            res.add(String.valueOf(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            swap(arr, i, index);
            backTracking(arr, res, index + 1);
            swap(arr, i, index);
        }
    }

    private void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
