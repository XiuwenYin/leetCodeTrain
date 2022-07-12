package leetcode202快乐数;

import java.util.*;

public class leetcode202 {
    /**
     * 可以看成判断有环链表
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n, fast = getSum(n);
        while (slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return slow == 1;
    }

    public int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            int level = num % 10;
            sum += level * level;
            num /= 10;
        }
        return sum;
    }
}
