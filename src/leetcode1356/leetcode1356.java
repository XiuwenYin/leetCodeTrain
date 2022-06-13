package leetcode1356;

import java.util.Arrays;

// 根据数字二进制下 1 的数目排序
public class leetcode1356 {
    /**
     * 位运算
     * 使用 Integer.bitCount()方法（返回二进制中1的个数）
     */
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        // 创建数组存储结果的同时存储当前数字
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // res中元素的六位以前存储各元素二进制中1的个数
            // 后六位的五位存储元素本身
            res[i] = Integer.bitCount(arr[i]) * 100000 + arr[i];
        }
        // 根据1的个数排序
        Arrays.sort(res);
        for (int i = 0; i < n; i++) {
            // 对结果进行取模
            res[i] %= 100000;
        }
        return res;
    }

    // 在这道题中此方法可以替代 Integer.bitCount()
    private int getCount(int a) {
        int t = 0;
        while (a != 0) {
            a &= a-1;
            t++;
        }
        return t;
    }
    public static void main(String[] args) {
        int a = 15;
        int b = 16;
        leetcode1356 test = new leetcode1356();
        int c = test.getCount(a);
        System.out.println(c);

    }
}
