package leetcode852山脉数组的峰顶索引;

public class leetcode852 {
    /**
     * 一次遍历
     * 每次更新比cur大的当前坐标即可（贪心）
     * 太慢
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int cur = arr[0];
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (cur < arr[i]) {
                cur = arr[i];
                res = i;
            }
        }
        return res;
    }

    /**
     * 二分（特化）
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray01(int[] arr) {
        int left = 1, right = arr.length - 1; // 由于数组长度最低为3，而且arr保证存在山峰，所以从1开没问题；当然也可以从0开
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid + 1]) right = mid; // 注意对比条件，是mid的下一位
            else left = mid + 1;
        }
        return left;
    }
}
