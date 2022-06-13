package leetcode350;

import java.util.Arrays;

public class leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 双指针，左侧开始，每次比较大小，若不相等，每次小的数字的指针向右移动一位
        int n1 = nums1.length, n2 = nums2.length;
        int[] res = new int[Math.min(n1, n2)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0, p3 = 0;
        while(p1 != n1 && p2 != n2) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            }else if (nums2[p2] < nums1[p1]) {
                p2++;
            }else {
                res[p3++] = nums1[p1++];
                p2++;
            }
        }
        return Arrays.copyOfRange(res, 0, p3);
    }
}
