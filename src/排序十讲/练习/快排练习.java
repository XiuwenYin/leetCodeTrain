package 排序十讲.练习;

public class 快排练习 {
    public void quickSort(int[] arr) {
        helper(arr, 0, arr.length - 1);
    }

    public void helper(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = partition(arr, left, right);
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
