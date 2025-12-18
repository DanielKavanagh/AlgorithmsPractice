package HashMaps;

import GenericProblems.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumsTest {

    @Test
    public void testSimpleArray() {
        int[] input = new int[]{1,2,4,1,1,5,1};
        assertEquals(4, SubarraySums.totalSubarrays(input, 6));
    }

    @Test
    public void testNoSubarraysFound() {
        int[] input = new int[]{1,2,4};
        assertEquals(0, SubarraySums.totalSubarrays(input, 8));
    }

    @Test
    public void testAllZeroes() {
        int[] input = new int[]{0,0,0,0};
        assertEquals(10, SubarraySums.totalSubarrays(input, 0));
    }

    @Test
    public void testNegativeNumbers() {
        int[] input = new int[]{-1,-2,-4,-6};
        assertEquals(2, SubarraySums.totalSubarrays(input, -6));
    }

    @Test
    public void testSubarrayIndices() {
        int[] input = new int[]{1,2,4};
        List<Pair<Integer, Integer>> expectedResult = List.of(
                new Pair<>(1, 2)
        );

        assertEquals(expectedResult, SubarraySums.subarrayIndices(input, 6));
    }

    @Test
    public void testGetAllSubarrays() {
        int[] input = new int[]{1,2,4,1,2,4};
        Set<List<Integer>> expectedResult = Set.of(
                List.of(2,4)
        );

        assertEquals(expectedResult, SubarraySums.getAllSubarrays(input, 6));
    }

    @Test
    public void testGetAllSubarraysZeroes() {
        int[] input = new int[]{0,0,0};
        Set<List<Integer>> expectedResult = Set.of(
                List.of(0),
                List.of(0,0),
                List.of(0,0,0)
        );

        assertEquals(expectedResult, SubarraySums.getAllSubarrays(input, 0));
    }

    @Test
    public void testGetAllSubarraysNegative() {
        int[] input = new int[]{-1,-2,-4};
        Set<List<Integer>> expectedResult = Set.of(
                List.of(-2,-4)
        );

        assertEquals(expectedResult, SubarraySums.getAllSubarrays(input, -6));
    }


}