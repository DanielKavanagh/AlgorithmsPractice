package StringProblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {
    ValidAnagram cut = new ValidAnagram();

    @BeforeEach
    void setUp() {
    }

    @Test
    public void when_simpleInput_then_isAnagram() {
        boolean result = cut.isAnagram("abcd", "cbda");
        assertTrue(result);
    }

    @Test
    public void when_repeatingCharacters_then_isAnagram() {
        boolean result = cut.isAnagram("aaabcdd", "bcaddaa");
        assertTrue(result);
    }

    @Test
    public void when_differingCharacters_then_isNotAnagram() {
        boolean result = cut.isAnagram("abcde", "abcdf");
        assertFalse(result);

    }

    @Test
    public void when_differingStringLength_then_isNotAnagram() {
        boolean result = cut.isAnagram("abcde", "abcd");
        assertFalse(result);
    }

    @Test
    void when_oneEmptyString_then_isNotAnagram() {
        boolean result = cut.isAnagram("abcd", "");
        assertFalse(result);
    }

    @Test
    void when_twoEmptyStrings_then_isNotAnagram() {
        boolean result = cut.isAnagram("", "");
        assertFalse(result);
    }

    @Test
    public void when_simpleInput_then_isAnagramHashMap() {
        boolean result = cut.isAnagramHashMap("abcd", "cbda");
        assertTrue(result);
    }

    @Test
    public void when_repeatingCharacters_then_isAnagramHashMap() {
        boolean result = cut.isAnagramHashMap("aaabcdd", "bcaddaa");
        assertTrue(result);
    }

    @Test
    public void when_differingCharacters_then_isNotAnagramHashMap() {
        boolean result = cut.isAnagramHashMap("abcde", "abcdf");
        assertFalse(result);

    }

    @Test
    public void when_differingStringLength_then_isNotAnagramHashMap() {
        boolean result = cut.isAnagramHashMap("abcde", "abcd");
        assertFalse(result);
    }

    @Test
    void when_oneEmptyString_then_isNotAnagramHashMap() {
        boolean result = cut.isAnagramHashMap("abcd", "");
        assertFalse(result);
    }

    @Test
    void when_twoEmptyStrings_then_isNotAnagramHashMap() {
        boolean result = cut.isAnagramHashMap("", "");
        assertFalse(result);
    }
}