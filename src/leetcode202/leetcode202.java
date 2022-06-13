package leetcode202;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class leetcode202 {
    public boolean isHappy(int n) {
        // 使用哈希表存储
        Set<Integer> hashSet = new HashSet<>();
        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n) {
        int res = 0, temp;
        while(n != 0) {
            temp = n % 10;
            n /= 10;
            res += Math.pow(temp, 2);
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode202 demo = new leetcode202();
        boolean a = demo.isHappy(19);
        System.out.println(a);
    }
}
