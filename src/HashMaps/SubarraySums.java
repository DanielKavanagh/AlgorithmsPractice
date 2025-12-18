package HashMaps;

import GenericProblems.Pair;

import java.util.*;
import java.util.stream.Stream;

public class SubarraySums {
    /**
     * Keep track of running total using hashmap.
     * Check if current running total minus the sum is found. If so, we have a new valid subarray.
     * We track the frequency of each running total value, because they may repeat if the input
     * contains zeroes or negative numbers.
     * */
    public static int totalSubarrays(int[] array, int sum) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        // Initialise map with a zero, to handle case where the first element is a valid subarray
        prefixMap.put(0, 1);

        int runningTotal = 0;
        int result = 0;

        for (int digit : array) {
            runningTotal += digit;

            if (prefixMap.containsKey(runningTotal - sum)) {
                result += prefixMap.get(runningTotal - sum);
            }

            prefixMap.put(runningTotal, prefixMap.getOrDefault(runningTotal, 0) + 1);
        }

        return result;
    }

    /**
     * Returns all the array indices that are valid subarrays.
     * We do this by tracking the index of each runningTotal value. So the key is the runningTotal,
     * and the list of values is each index where that total was found.
     * */
    public static List<Pair<Integer, Integer>> subarrayIndices(int[] array, int sum) {
        Map<Integer, List<Integer>> prefixMap = new HashMap<>();
        prefixMap.put(0, new ArrayList<>(List.of(-1)));

        List<Pair<Integer,Integer>> result = new ArrayList<>();
        int runningTotal = 0;

        for (int i = 0; i < array.length; i++) {
            runningTotal += array[i];

            int target = runningTotal - sum;

            if (prefixMap.containsKey(target)) {
                for (int index : prefixMap.get(target)) {
                    result.add(new Pair<>(index + 1, i ));
                }
            }

            prefixMap.computeIfAbsent(runningTotal, x -> new ArrayList<>()).add(i);
        }

        return result;
    }

    /**
     * Returns the unique subarrays from the given input and target sum.
     * Uniqueness is order dependant (i.e. [2,4] and [4,2] are not the same subarray).
     * <p>
     * Implementation is very similar to subarrayIndices, except we have an extra loop
     * to generate the permutations of subarrays.
     * */
    public static Set<List<Integer>> getAllSubarrays(int[] input, int sum) {
        Map<Integer, List<Integer>> prefixMap = new HashMap<>();
        prefixMap.put(0, new ArrayList<>(List.of(-1)));

        Set<List<Integer>> result = new HashSet<>();
        int runningTotal = 0;

        for (int i = 0; i < input.length; i++) {
            runningTotal += input[i];

            int target = runningTotal - sum;

            if (prefixMap.containsKey(target)) {
                for (int index : prefixMap.get(target)) {
                    List<Integer> validSubarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        validSubarray.add(input[j]);
                    }

                    result.add(validSubarray);
                }
            }

            prefixMap.computeIfAbsent(runningTotal, x -> new ArrayList<>()).add(i);
        }

        return result;

    }
}
