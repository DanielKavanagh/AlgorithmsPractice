package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // This is the number we're searching for each iteration
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[]{ numMap.get(complement), i };
            }

            // No complement was found, add the current number to the map, and continue.
            numMap.put(nums[i], i);
        }

        return null;
    }

    public <T, U, R, P> BiFunction<T, U, R> memoize(BiFunction<T, U, R> function) {
        List<P> p = getThing();
        Map<List<?>, R> cache = new HashMap<>();
        return (a, b) -> cache.computeIfAbsent(List.of(a, b), k -> function.apply(a, b));
    }

    public BiFunction<int[], Integer, int[]> twoSumMemoized = memoize(this::twoSum);

    public <P> List<P> getThing() {
        return new ArrayList<>();
    }
}
