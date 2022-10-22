package t360;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class C02 {
    private static Set<String> SUBJECT;   // 主语
    private static Set<String> PREDICATE; // 谓语
    private static Set<String> OBJECT;    // 宾语

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
        sc.nextLine();
        String words1 = sc.nextLine();
        String words2 = sc.nextLine();
        String words3 = sc.nextLine();
        SUBJECT = Arrays.stream(words1.split(" ")).collect(Collectors.toSet());
        PREDICATE = Arrays.stream(words2.split(" ")).collect(Collectors.toSet());
        OBJECT = Arrays.stream(words3.split(" ")).collect(Collectors.toSet());

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            boolean b = process(sc.nextLine());
            if (b) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean process(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String[] words = str.split(" ");
        if (words.length < 3) {
            return false;
        }
        int flag = 0;
        for (String word : words) {
            switch (flag) {
                case 0 :
                    if (!SUBJECT.contains(word)) {
                        return false;
                    } else {
                        flag = 1;
                    }
                    break;
                case 1 :
                    if (OBJECT.contains(word)) {
                        return false;
                    } else if (PREDICATE.contains(word)) {
                        flag = 2;
                    }
                    break;
                case 2 :
                    if (!OBJECT.contains(word)) {
                        return false;
                    }
            }
        }
        return true;
    }
}
