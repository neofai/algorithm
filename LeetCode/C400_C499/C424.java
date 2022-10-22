package C400_C499;

public class C424 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (k > len) {
            return len;
        }
        int[] cnt =new int[26];
        int left = 0, right = 0;
        int ans = 1;
        int cut_max = 0;
        while (right < len) {
            cnt[s.charAt(right) - 'A']++;
            cut_max = Math.max(cut_max, cnt[s.charAt(right) - 'A']);
            if (right - left + 1 > cut_max + k) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
