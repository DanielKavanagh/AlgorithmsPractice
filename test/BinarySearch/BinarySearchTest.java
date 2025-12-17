package BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private BinarySearch cut = new BinarySearch();

    @Test
    public void targetExistsBinarySearch() {
        int indexRight = cut.binarySearch(new int[]{1,2,4,6,8,10}, 8);
        assertEquals(4, indexRight);

        int indexLeft = cut.binarySearch(new int[]{1,2,4,6,8,10}, 2);
        assertEquals(1, indexLeft);

    }

    @Test
    public void targetDoesNotExistBinarySearch() {
        int index = cut.binarySearch(new int[]{1, 2, 4, 6, 8, 10}, 999);
        assertEquals(-1, index);
    }
}