package klook;

import java.util.Arrays;

public class C01 {
    public static int AmountOfCombination(int[] nums, int target) {
        //请在这里实现算法并返回结果
        if (nums==null || nums.length < 4) {
            return 0;
        }
        int amount = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int k = 0; k < len - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                continue;
            }
            int max1 = nums[k] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max1 < target) {
                continue;
            }
            for (int i = k + 1; i < len - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int h = len - 1;
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    break;
                }
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                while (j < h) {
                    int cur = nums[k] + nums[i] + nums[j] + nums[h];
                    if (cur == target) {
                        amount++;
                        j++;
                        while ((j < h && nums[j] == nums[j-1])) {
                            j++;
                        }
                        h--;
                        while (j < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (cur > target) {
                        h--;
                    } else {
                        j++;
                    }
                }

            }
        }
        return amount;
    }
}
