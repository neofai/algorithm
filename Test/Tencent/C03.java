package Tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0, right = n - 1;
        List<Integer> ans = new ArrayList<>();
        boolean b = true;
        while (left < right) {
            if (b) {
                if (arr[left] > arr[right]) {
                    ans.add(arr[left++]);
                } else if (arr[left] < arr[right]) {
                    ans.add(arr[right--]);
                } else {
                    int tempLeft = left + 1, tempRight = right - 1;
                    while (tempLeft < tempRight && arr[tempLeft] == arr[tempRight]) {
                        tempRight--;
                        tempLeft++;
                    }
                    if (arr[tempLeft] >= arr[tempRight]) {
                        ans.add(arr[left++]);
                    } else {
                        ans.add(arr[right--]);
                    }
                }
            } else {
                if (arr[left] > arr[right]) {
                    ans.add(arr[right--]);
                } else if (arr[left] < arr[right]) {
                    ans.add(arr[left++]);
                } else {
                    int tempLeft = left + 1, tempRight = right - 1;
                    while (tempLeft < tempRight && arr[tempLeft] == arr[tempRight]) {
                        tempRight--;
                        tempLeft++;
                    }
                    if (arr[tempLeft] >= arr[tempRight]) {
                        ans.add(arr[right--]);
                    } else {
                        ans.add(arr[left++]);
                    }
                }
            }
            b = !b;
        }
        ans.add(arr[left]);
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i));
            if (i < n - 1) System.out.print(" ");
        }
    }
}
