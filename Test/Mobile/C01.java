package Mobile;

import java.util.Scanner;

public class C01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long temp = (long) Math.max(0, b[i] - m) * c[i] + a[i];
            ans = Math.min(ans, temp);
        }
        System.out.println(ans);
    }
}
