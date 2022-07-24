package leetcode7整数反转;

public class leetcode7 {
    /**
     * 模拟
     * 主要问题在于题干要求不可存储超过32位，也就是不能超过或小于 +- Integer.MAX_VALUE
     * 解决方法：用一个temp存储当前状态，并 / 10 看结果是否还等于res：如果不等于则表示溢出，直接返回0
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 可以这么理解：temp是新reverse，res是老reverse，那么temp / 10 应该等于 res, 如果不等则表示溢出
            int temp = res * 10 + x % 10;
            if (temp / 10 != x) return 0; // 防止溢出
            res = temp;
            x /= 10;
        }
        return res;
    }
}
