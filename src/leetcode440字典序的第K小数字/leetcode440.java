package leetcode440字典序的第K小数字;

public class leetcode440 {
    /**
     * 以当前数字为根的十叉树的元素总个数 (包括当前数字)
     *
     * @param num 当前数字 (需要先 cast 成 long, 因为 num*10 可能导致 int 溢出)
     * @param n   数字的最大值
     * @return
     */
    private int count(long num, int n) {
        int cnt = 0;     // 元素总个数
        int width = 1;   // 当前层数的宽度, 第一层只有 num 一个元素, 所以第一层宽度为 1
        while (true) {
            if (num + width - 1 <= n) {   // n 的值大于等于当前层的最大值, 说明当前层数的个数可以全部添加
                cnt += width;
                num *= 10;
                width *= 10;
            } else {                      // n 的值小于当前层的最大值则只能添加部分个数或者不添加, 并跳出循环
                if (n - num >= 0) {
                    cnt += n - num + 1;
                }
                break;
            }
        }
        return cnt;
    }

    public int findKthNumber(int n, int k) {
        int cnt = 0;   // 已经经过的元素个数, 开始一个元素都没有经过, 所以个数为 0
        int num = 1;   // 第一个元素 (经过 i 个元素, 当前 num 是第 i + 1 元素)

        // 要找到第 k 个元素, 需要经过 k - 1 个元素
        while (true) {
            if (cnt == k - 1) {          // 经过了 k - 1 个元素找到了第 k 个元素
                break;
            }
            int temp = count((long) num, n);    // 以 num 为根, 以 n 为最大值的十叉树的元素总个数
            if (cnt + temp >= k) {       // 以 num 为根的十叉树内有第 k 个元素
                num *= 10;
                cnt++;
            } else if (cnt + temp < k) { // 以 num 为根的十叉树内没有第 k 个元素
                num++;
                cnt += temp;
            }
        }
        return num;
    }
}
