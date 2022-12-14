import java.util.HashMap;
import java.util.Map;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/25
 * @description
 */
public class Solution50_2 {
    
    private StringBuilder res = new StringBuilder();
    private Map<Character, Integer> characterMap = new HashMap<>();

    // Insert one char from stringstream
    public void Insert(char ch) {
        res.append(ch);
        characterMap.put(ch, characterMap.getOrDefault(ch, 0) + 1);
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {

        for (char c : res.toString().toCharArray()) {
            if (characterMap.get(c) == 1) {
                return c;
            }
        }

        return '#';
    }
}