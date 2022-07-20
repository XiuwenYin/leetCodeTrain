package leetcode287寻找重复数;

import java.util.Arrays;

public class leetcode287 {
    /**
     * 可以替换成寻找环形链表的形式
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0; // 定义快慢指针
        do {
            slow = nums[slow]; // 慢指针一次走一步
            fast = nums[nums[fast]]; // 快指针一次走两步
        } while (slow != fast); // do-while可以防止初始条件都为0而不执行
        slow = 0; // 在相遇后慢指针归零
        while (slow != fast) { // 同时前进直到再次相遇
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
