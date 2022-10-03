package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        for (int k = left; k <= right; k++) {
            arr[k] = temp[t++];
        }
    }

}
