package leetcode282;

// 移动0

/**
 * 双指针（快慢指针）
 */
public class leetcode282 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            // 当碰到非0时，p1右移，p2右移
            // 当p1碰到0时，p1右移，p2不动，再当p1遇到第一个非零值时，交换p1，p2的值
            if (nums[p1] != 0) {
                if (p1 > p2) {
                    nums[p2] = nums[p1];
                    nums[p1] = 0;
                }
                p2++;
            }

        }
    }

}
