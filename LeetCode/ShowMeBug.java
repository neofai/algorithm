import java.util.Scanner;

public class ShowMeBug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(process(str));
    }

    private static long process(String str) {
        long ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                ret = ret * 36 + (c - '0');
            } else {
                c = Character.toUpperCase(c);
                ret = ret * 36 + (c - 'A' + 10);
            }
        }
        return ret;
    }


}


