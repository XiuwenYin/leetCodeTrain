package leetcode4;

public class leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;
        int totalLeft = m + (n - m + 1) / 2;

        // 要使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums[i];
        // nums1分割线左边的数值小于nums2分割线右边的数值 && ...
        int left = 0, right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int num2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1) {
            return Math.max(num1LeftMax, num2LeftMax);
        } else {
            return (double)(Math.max(num1LeftMax, num2LeftMax) + Math.min(num1RightMin, num2RightMin)) / 2;
        }
    }


}
