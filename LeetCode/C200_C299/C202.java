package C200_C299;

public class C202 {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);
        } while (slow != fast);
        return fast == 1;
    }

    private int getSum(int m) {
        int sum = 0;
        while (m > 0) {
            sum += (m % 10) * (m % 10);
            m /= 10;
        }
        return sum;
    }
}
