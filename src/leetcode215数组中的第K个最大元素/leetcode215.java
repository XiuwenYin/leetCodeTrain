package leetcode215数组中的第K个最大元素;

import java.util.PriorityQueue;

public class leetcode215 {
    /**
    堆；heap
    min heap作用此题
    只要看到最大K或者最小K的题，基本都是用min heap 或者 max heap来做
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : nums) {
            //                      如果这里不添加等号，则是考虑每个数字只出现1次（distinct）
            if (heap.size() < k || x >= heap.peek()) {
                heap.offer(x);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest01(int[] nums, int k) {
        int n = nums.length;
        divide(nums, 0, n - 1, k);
        return nums[n - k];
    }

    private void divide(int[] nums, int left, int right, int k) {
        int n = nums.length;
        if (left >= right) return;
        int position = partition(nums, left, right);
        // 这个 n - k 是targetPosition
        if (position == n - k) return;
        else if (position < n - k) divide(nums, position + 1, right, k);
        else divide(nums, left, position - 1, k);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int wall = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, right);
        return wall;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
