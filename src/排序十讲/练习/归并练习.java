package 排序十讲.练习;

import java.util.Arrays;

public class 归并练习 {
    public int[] mergeSort(int[] arr) {
        return divide(arr, 0, arr.length - 1);
    }

    public int[] divide(int[] arr, int left, int right) {
        if (left >= right) return new int[]{arr[right]};
        int mid = left + (right - left) / 2;
        int[] leftRes = divide(arr, left, mid);
        int[] rightRes = divide(arr, mid + 1, right);
        return merge(leftRes, rightRes);
    }

    public int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            res[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) res[k++] = left[i++];
        while (j < right.length) res[k++] = right[j++];
        return res;
    }

    public static void main(String[] args) {
        归并练习 test = new 归并练习();
        int[] arr = new int[]{2,3,445,45,2435,34,8,45,234,52,34};
        arr = test.mergeSort(arr);
        for (int x : arr) System.out.print(x + " ");
    }
}
