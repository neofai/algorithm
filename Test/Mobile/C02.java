package Mobile;

import java.util.Scanner;

public class C02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        sc.nextLine();
        String str = sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = 0;
        int left = 0, right = n - 1;
        while ((left < right)) {
            if (str.charAt(left) != str.charAt(right)) {
                ans += Math.min(arr[left], arr[right]);
            }
            ++left;
            --right;
        }
        System.out.println(ans);
    }
}
