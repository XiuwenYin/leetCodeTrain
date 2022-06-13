package leetcode905;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode905 {
    public int[] sortArrayByParity(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        for (int x : nums) {
            if (x % 2 == 0) {
                deque.addFirst(x);
            } else {
                deque.addLast(x);
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = deque.pop();
        }
        return res;
    }
}
