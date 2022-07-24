package leetcode26删除有序数组中的重复项;

// 删除有序数组中的重复项
public class leetcode26 {
    /**
     * 双指针
     * 不使用额外空间
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        // 定义双指针
        int i = 0, j = 0;
        // j是快指针，快指针到达数组长度时停止循环
        while (j < n) {
            // 如果 i == 0，则表明是第0位，跳过第0位；如果 i 后面一位和 j 此刻值相同，则说明不重复，i++，j++
            if (i == 0 || nums[i - 1] != nums[j]) {
                // 更新数组的方式，如果不一样，则把 快指针位置的值 赋给 慢指针位置
                nums[i++] = nums[j++];
                // 如果相同，则说明 i后面一位和 j此刻的值相同，j++，i保持不变
            } else {
                j++;
            }
        }
        // 最后i所在的位置就是不重复数组的长度
        return i;
    }

    /**
     * 双指针
     * 练习
     */
    public int removeDuplicates01(int[] nums) {
        int ptr = 1, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        return ptr;
    }
}
