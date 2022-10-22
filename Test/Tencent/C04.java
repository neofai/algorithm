package Tencent;

import java.util.Scanner;

public class C04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(), R = sc.nextInt();
        String s = "10010110011010010110100110010110";
        String substring = s.substring(L, R + 1);
        int count = 0;
        for (int i = 0; i < substring.length(); i++) {
            if(substring.charAt(i) == '1') {
                ++count;
            }
        }
        System.out.println(count);
    }
}
