package StringProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidGroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> inputStrings) {
        Map<String, List<String>> result = new HashMap<>();

        for (String word : inputStrings) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);

            String key = String.valueOf(charArray);

            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(word);
        }

        return result.values().stream().toList();
    }
}
