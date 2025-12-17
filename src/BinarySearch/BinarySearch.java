package BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearch {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearch.class);

    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
