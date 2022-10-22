package C900_C999;

public class C904 {

    public static void main(String[] args) {
        C904 c904 = new C904();
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(c904.totalFruit(arr));
    }
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        int[] cnt = new int[len];
        int type = 0, ans = 0;
        int left = 0, right = 0;
        while (right < len) {
            while (left < right && type > 2) {
                int index = fruits[left++];
                --cnt[index];
                if (cnt[index] == 0) --type;
            }
            while (right < len && type <= 2) {
                int index = fruits[right++];
                ++cnt[index];
                if (cnt[index] == 1) ++type;
            }
            ans = Math.max(ans, type <= 2 ? right - left : right - left - 1);

        }
        return ans;
    }
}
