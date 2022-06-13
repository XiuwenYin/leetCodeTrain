package leetcode728;

import java.util.ArrayList;
import java.util.List;

public class leetcode728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        outer: for (int i = left; i <= right; i++) {
            int temp = i;
            while (temp != 0) {
                int digit = temp % 10;
                if (digit == 0 || i % digit != 0) continue outer;
                temp /= 10;
            }
            res.add(i);
        }
        return res;
    }
}
