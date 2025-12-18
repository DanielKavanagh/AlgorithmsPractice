package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public static int firstUniqueCharacter(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char[] charArray = input.toCharArray();

        for (Character c : charArray) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < charArray.length; i++) {
            if (frequencyMap.get(charArray[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}
