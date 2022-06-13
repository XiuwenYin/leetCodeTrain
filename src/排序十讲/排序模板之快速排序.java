package 排序十讲;

public class 排序模板之快速排序 {
    public int[] quickSort(int[] arr) {
        int n = arr.length;
        helper(arr, 0, n - 1);
        return arr;
    }

    private void helper (int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = partition(arr, left, right);
        helper(arr, left, pivot - 1);
        helper(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
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

    private int partition2(int[] arr, int left, int right) {
        int pivot = arr[right], wall = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, wall);
                wall++;
            }
        }
        swap(arr, wall, right);
        return wall;
    }

    private void swap (int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
