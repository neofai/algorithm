package Tencent;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class C02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        // int[] arr = new int[n];
        long sum = 0L;
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sum += num;
            queue.offer(num);
        }

        while (k > 0) {
            int poll = queue.poll();
            int temp = help(poll);
            int t = poll - temp;
            sum -= t;
            --k;
            queue.offer(temp);
        }
        System.out.println(sum);
    }

    public static int help(int num) {
        if (num == 0) return 0;
        return help(num / 2) + (num & 1);
    }
}
