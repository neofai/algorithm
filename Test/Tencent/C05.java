package Tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C05 {

    private static List<Character> ans;
    private static int X = -1;
    private static int Y = -1;

    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n, arr);
    }

    public static void solution(int n, int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int x = sum / 2;
        int y = sum - x;
        while (!flag && x >= 0) {
            dfs(arr, x, -y, 0, 0, new ArrayList<>());
            if (!flag) {
                dfs(arr, -x, y, 0, 0, new ArrayList<>());
            }
            x--;
            y++;
        }
        if (!flag) {
            System.out.println(-1);
        }
        else {
            System.out.println(X + " " + Y);
            for (Character c : ans) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void dfs(int[] arr, int x, int y, int curIndex, int curSum, List<Character> list) {
        if (flag) return;
        if (curIndex == arr.length) {
            if (curSum == 0) {
                ans = new ArrayList<>(list);
                X = x;
                Y = y;
                flag = true;
            }
            return;
        }
        List<Character> tempList = new ArrayList<>(list);
        int tempSum = curSum;
        list.add('X');
        curSum += arr[curIndex] * x;
        dfs(arr, x, y, curIndex + 1, curSum, list);

        tempList.add('Y');
        tempSum += arr[curIndex] * y;
        dfs(arr, x, y, curIndex + 1, tempSum, tempList);
    }

}
