package C400_C499;

import java.util.ArrayList;
import java.util.List;

public class C438 {
    public static void main(String[] args) {
        findAnagrams("bpaa", "aa");
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        List<Integer> ans = new ArrayList<>();
        if (len1 < len2) {
            return ans;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < len2; i++) {
            cnt[p.charAt(i) - 'a']--;
            cnt[s.charAt(i) - 'a']++;
        }

        if (check(cnt)) ans.add(0);
        for (int i = 0; i < len1 - len2; i++) {
            int index1 = s.charAt(i) - 'a';
            cnt[index1]--;
            int index2 = s.charAt(i + len2) - 'a';
            cnt[index2]++;
            if (check(cnt)) ans.add(i + 1);
        }
        return ans;
    }

    public static boolean check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
