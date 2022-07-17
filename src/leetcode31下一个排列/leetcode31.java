package leetcode31下一个排列;

import java.util.Arrays;

public class leetcode31 {
    /**
     * 从后向前遍历，找到前一位比当前要小的idx
     * 这里sort从idx到n的部分
     * 再从这里向右遍历，找到一个比之前idx - 1大的数字，与idx - 1交换即可
     * 可以用 1243 -> 1234(第一次遍历结束并sort) -> 1342(第二次遍历结束并swap) 来思考
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) { // 如果i位 比i前一位要大
                Arrays.sort(nums, i, len); // 直接j-end排序后，j与i前一位交换
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums); // 题目要求，找不到则升序
        return;
    }

    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
