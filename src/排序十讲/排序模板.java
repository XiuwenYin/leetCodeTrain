package 排序十讲;

public class 排序模板 {
    /**
     * 冒泡排序
     *
     * @param arr
     */
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    private int[] selectionSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return arr;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                // 往后推，给更小的留位置
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    private void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap >= 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j = i;
                while (arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }

    }
}












