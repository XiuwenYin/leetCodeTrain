package 排序十讲;

public class 排序模板之堆化 {
    public void buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
