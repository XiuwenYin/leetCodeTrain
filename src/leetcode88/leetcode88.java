package leetcode88;

public class leetcode88 {
    /**
     * 逆向指针 * 2
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tol = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2];
                p2--;
            } else if (p2 == -1) {
                cur = nums1[p1];
                p1--;
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1];
                p1--;
            } else {
                cur = nums2[p2];
                p2--;
            }
            nums1[tol] = cur;
            tol--;
        }
    }

    public void merge01(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tol = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[tol--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
