package C200_C299;

public class C299 {
    public String getHint(String secret, String guess) {
        int[] cnt1 = new int[10];
        int[] cnt2 = new int[10];
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                cnt1[secret.charAt(i) - '0']++;
                cnt2[guess.charAt(i) - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(cnt1[i], cnt2[i]);
        }
        return new StringBuilder().append(bulls).append("A").append(cows).append("B").toString();
    }
}
