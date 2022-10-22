package C800_C899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C811 {
    public static void main(String[] args) {
        String[] s = {"9001 discuss.leetcode.com"};
        subdomainVisits(s);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String[] s = split[1].split("\\.");
            String temp = "";
            for (int i = s.length - 1; i >= 0; i++) {
                temp = s[i] + temp;
                countMap.put(temp, countMap.getOrDefault(temp, 0) + count);
                temp = "." + temp;
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}
