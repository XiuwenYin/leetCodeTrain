package leetcode565数组嵌套;

import java.util.Arrays;

public class leetcode565 {
    /**
     * 标记数组法 + 多条链表找长度
     * 本题重点由于数组中每个都不重复，所以只用找到最长的环链长度就是答案
     * 题中最大S是误导性，其实只要找到最长链则必定是最大
     * On On
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    /**
     * 原地标记法（更省空间）
     * 由于本题数组中的数字不为负，所以用负数标记
     * On O1
     * @param nums
     * @return
     */
    public int arrayNesting01(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (nums[i] >= 0) {
                int temp = nums[i];
                nums[i] = -1; // 标记visited
                cnt++;
                i = temp;

            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
