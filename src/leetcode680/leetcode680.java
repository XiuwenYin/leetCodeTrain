package leetcode680;

public class leetcode680 {
    /**
     * 递归
     * 双指针怎么都凹不对，换了个思路
     * check中k表示能够跳跃k次
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        return check(arr, 0, arr.length - 1, 1);
    }

    private boolean check(char[] arr, int left, int right, int k) {
        int l = left, r = right;
        while (l < r) {
            if (arr[l] == arr[r]) {
                l++;
                r--;
            } else {
                if (k > 0) {
                   return check(arr, l + 1, r, k - 1) || check(arr, l, r - 1, k - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
