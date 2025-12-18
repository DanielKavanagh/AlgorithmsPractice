package StringProblems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidGroupAnagramsTest {

    @Test
    public void testGroupAnagrams() {
        List<List<String>> result = ValidGroupAnagrams
                .groupAnagrams(List.of("eat", "tea", "aet", "diff"));

        List<List<String>> expectedResult = List.of(
                List.of("eat", "tea", "aet"),
                List.of("diff")
        );

        assertEquals(expectedResult, result);
    }

}