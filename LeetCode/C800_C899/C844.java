package C800_C899;

import java.util.ArrayDeque;
import java.util.Deque;

public class C844 {
    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        int idx1 = s.length() - 1;
        int idx2 = t.length() - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            int cnt1 = 0;
            while (idx1 >= 0 && s.charAt(idx1) == '#') {
                idx1--;
                cnt1++;
            }
            idx1 = Math.max(-1, idx1 -cnt1);

            int cnt2 = 0;
            while (idx2 >= 0 && t.charAt(idx2) == '#') {
                idx2--;
                cnt2++;
            }
            idx2 = Math.max(-1, idx2 -cnt2);

            if (idx1 == -1 && idx2 == -1) {
                return true;
            } else if (idx1 == -1 || idx2 == -1) {
                return false;
            }
            if (s.charAt(idx1) != t.charAt(idx2)) {
                return false;
            }
            idx1--;
            idx2--;
        }
        return idx1 == -1 && idx2 == -1;
    }
}
