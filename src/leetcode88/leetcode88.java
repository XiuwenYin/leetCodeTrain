package leetcode88;

public class leetcode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int currn;
        int[] newArr = new int[m + n];
        while(p1 < m || p2 < n) {
            if (p1 == m) {
                currn = nums2[p2++];
            } else if (p2 == n) {
                currn = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                currn = nums1[p1++];
            } else {
                currn = nums2[p2++];
            }
            newArr[p1 + p2 - 1] = currn;
        }
        for (int i = 0; i < m + n - 1; i++) {
            nums1[i] = newArr[i];
        }
    }

    /**
     * 逆向指针 * 2
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge01(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int end = m + n - 1;
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
            nums1[end] = cur;
            end--;
        }
    }
}
