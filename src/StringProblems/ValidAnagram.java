package StringProblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    private static final Logger logger = LoggerFactory.getLogger(ValidAnagram.class);

    public boolean isAnagram(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) {
            return false;
        }

        char[] inputA = a.toCharArray();
        char[] inputB = b.toCharArray();

        Arrays.sort(inputA);
        Arrays.sort(inputB);

        logger.debug("Input A: {}, Input B: {}", inputA, inputB);

        return Arrays.equals(inputA, inputB);
    }

    public boolean isAnagramHashMap(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            aMap.put(a.charAt(i),aMap.getOrDefault(a.charAt(i), 0) + 1);
            bMap.put(b.charAt(i), bMap.getOrDefault(b.charAt(i), 0) + 1);
        }

        logger.debug("aMap: {}", aMap);
        logger.debug("bMap: {}", bMap);

        return aMap.equals(bMap);
    }
}
