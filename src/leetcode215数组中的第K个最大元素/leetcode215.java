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

    private void divide(int[] arr, int left, int right, int k) {
        int n = arr.length;
        if (left >= right) return;
        int position = partition(arr, left, right);
        // 如果找到n-k则直接返回，这个 n - k 是targetPosition，单边call了helper，而不是模板中双边都call helper，所以会更快，平均On而不是Onlogn
        if (position == n - k) return;
        else if (position < n - k) divide(arr, position + 1, right, k);
        else divide(arr, left, position - 1, k);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int wall = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, wall);
                wall++;
            }
        }
        swap(arr, wall, right);
        return wall;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

/**
 * 自己写的快速排序
 */
class Solution {
    int k;
    int n;
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        this.n = nums.length;
        quicksort(nums);
        return nums[nums.length - k];
    }
    public void quicksort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }
    public void helper(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = partition(arr, left, right);
        if (pivot == n - k) return;
        helper(arr, left, pivot - 1);
        helper(arr, pivot + 1, right);
    }
    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int start = left, end = right - 1;
        while (start <= end) {
            if (arr[start] <= pivot) start++;
            else if (arr[end] > pivot) end--;
            else swap(arr, start++, end--);
        }
        swap(arr, start, right);
        return start;
    }
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}