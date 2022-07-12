package 排序十讲;

public class 排序模板之归并排序 {
    public int[] mergeSort(int[] array) {
        return divide(array, 0, array.length - 1);
    }

    public int[] divide(int[] array, int left, int right) {
        if (left > right) return new int[]{array[left]};
        int mid = left + (right - left) /2 ;
        int[] leftResult = divide(array, left, mid);
        int[] rightResult = divide(array, mid + 1, right);
        return merge(leftResult, rightResult);
    }

    public int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            res[k++] = left[i] <= right[j] ? left[i++] : right[j++];
//            if (left[i] <= right[j]) res[k++] = left[i++];
//            else res[k++] = right[j++];
        }
        while (i < left.length) res[k++] = left[i++];
        while (j < right.length) res[k++] = right[j++];
        return res;
    }
}
