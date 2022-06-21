package leetcode11盛最多水的容器;

public class leetcode11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0, left = 0, right = n - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}
