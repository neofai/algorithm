package sort;

import java.util.Arrays;

public class QuickSort {
    private int count = 0;

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {3, 2, 4, 6, 1, 2, 5, 4};
        quickSort.sort(arr);
    }


    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            sort(arr, left, pivot - 1);
            sort(arr, pivot + 1, right);
        }

    }

    private int partition(int[] arr, int left, int right) {
        // 取第一个元素作为枢纽
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                --right;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                ++left;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        System.out.println((++count) + "次： " + Arrays.toString(arr));
        return left;
    }
}
