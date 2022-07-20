package leetcode34在排序数组中查找元素的第一个和最后一个位置;

public class leetcode34 {
    /**
     * 两次二分
     * 一个找左侧起点一个找右侧终点
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int l = 0, r = nums.length - 1; //二分范围
        while (l < r) { //查找元素的开始位置
            int mid = (l + r) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[r] != target) return new int[]{-1, -1}; //查找失败
        int left = r;
        l = 0;
        r = nums.length - 1; //二分范围
        while (l < r) { //查找元素的结束位置
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return new int[]{left, r};
    }
}
