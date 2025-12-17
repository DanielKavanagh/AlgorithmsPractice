package HashMaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    TwoSum cut = new TwoSum();

    @Test
    public void when_simpleArray_then_resultFound() {
        int[] result = cut.twoSum(new int[]{1,2,4,8}, 12);
        assertArrayEquals(new int[]{2, 3}, result);
    }

    @Test
    public void when_noAnswer_then_nullReturned() {
        int[] result = cut.twoSum(new int[]{1,2,4,9}, 12);
        assertNull(result);
    }

    @Test
    public void when_emptyArray_then_nullReturned() {
        int[] result = cut.twoSum(new int[]{}, 12);

        cut.twoSumMemoized.apply(new int[]{5,5}, 10);
        assertNull(result);
    }

}