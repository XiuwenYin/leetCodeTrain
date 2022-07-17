package leetcode2241设计一个ATM机器;

import java.util.HashMap;
import java.util.Map;

public class leetcode2241 {
}

class ATM {

    long[] count; // 记录每种面值的钱数
    int[] val; // 记录每种币的面值，方便下面操作

    public ATM() {
        count = new long[5]; // 记录每种面值的钱数
        val = new int[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; ++i) {
            count[i] += banknotesCount[i]; // 更新每种币的数量
        }
    }

    public int[] withdraw(int amount) {
        int[] arr = new int[5]; // 记录每种币的消耗量
        // 模拟取出钱币的过程
        for (int i = 4; i >= 0; --i) {
            int num = (int) Math.min(count[i], amount / val[i]);
            arr[i] = num;
            amount -= num * val[i]; // 更新amount的值
        }
        if (amount != 0) { // 说明将所有面值都遍历后，不能取出钱
            return new int[]{-1};
        }
        // 更新账户里面的币的数量，只有取出钱才更新数量
        for (int i = 0; i < 5; ++i) {
            count[i] -= arr[i];
        }
        return arr;
    }
}