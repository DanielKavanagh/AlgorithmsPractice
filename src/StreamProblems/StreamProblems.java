package StreamProblems;

import java.util.*;
import java.util.stream.Collectors;

public class StreamProblems {
    public static void main(String[] args) {
        squareList();
        longestName();
        distinctWords();
        concatenateEvenWords();
        sumOfEvenSquares();
        sumOfEven();
        sortedStrings();
        squaresGreaterThan(10);
        stringsLongerThan(3);
        longestString();
        toUpperCase();
        concatNonEmpty();
        groupByEvenOdd();
        frequencyMap();
        flattenLists();
        topNLongestWords(3);
        partitionPrimes();
        averageStringLength();
        groupByStringLength();
        findDuplicates();
    }

    public static void squareList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream().map(e -> (int) Math.pow(e, 2)).toList();
        System.out.println(result);
    }

    public static void longestName() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        System.out.println(names.stream().map(String::length).max(Integer::compare).get());

    }

    public static void distinctWords() {
        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );

        System.out.println(sentences.stream().flatMap(e -> Arrays.stream(e.split(" "))).distinct().count());
    }

    public static void concatenateEvenWords() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        System.out.println(words.stream().filter(word -> word.length() % 2 == 0).limit(2).collect(Collectors.joining()));
    }

    public static void sumOfEvenSquares() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(numbers.stream()
                .mapToInt(num -> (int) Math.pow(num, 2))
                .filter(num -> num % 2 == 0)
                .sum());
    }

    public static void sumOfEven() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        System.out.println(input.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum)
        );
    }

    public static void sortedStrings() {
        List<String> input = List.of("apple", "banana", "apple", "cherry");

        System.out.println(input.stream().distinct().sorted().collect(Collectors.toList()));
    }

    public static void squaresGreaterThan(int min) {
        List<Integer> input = List.of(2, 5, 10, 12, 15);

        System.out.println(input.stream()
                .filter(num -> num > min)
                .map(num -> (int) Math.pow(num, 2))
                .toList());
    }

    public static void stringsLongerThan(int min) {
        List<String> input = List.of("a", "cat", "house", "pen");

        System.out.println(input.stream()
                .filter(word -> word.length() > min)
                .count()
        );
    }

    public static void longestString() {
        List<String> input = List.of("aa", "bbbb", "ccc");
        System.out.println(input.stream().max(Comparator.comparing(String::length)).orElseThrow());
    }

    public static void toUpperCase() {
        List<String> input = List.of("hi", "java", "stream");
        System.out.println(input.stream().map(word -> word.toUpperCase(Locale.ROOT)).toList());
    }

    public static void concatNonEmpty() {
        List<String> input = List.of("hello", "", "world", "", "!");
        System.out.println(input.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining()));
    }

    public static void groupByEvenOdd() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> partition;

        partition = input.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(partition.get(false));
        System.out.println(partition.get(true));
    }

    public static void frequencyMap() {
        List<Character> input = List.of('a','b','a','c','b','a');
        System.out.println(input.stream().collect(Collectors.groupingBy(Character::charValue, Collectors.counting())));
    }

    public static void flattenLists() {
        List<List<Integer>> input = List.of(List.of(1,2), List.of(3), List.of(4,5));
        System.out.println(input.stream().flatMap(Collection::stream).collect(Collectors.toList()));
    }

    public static void topNLongestWords(int num) {
        List<String> input = List.of("hi","banana","code","banana","streaming","java","parallel");

        System.out.println(input.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length)
                        .reversed())
                .limit(num)
                .collect(Collectors.toList()));
    }

    public static void partitionPrimes() {
        List<Integer> input = List.of(2,3,4,5,8,11,12);
        Map<Boolean, List<Integer>> partition = input.stream()
                .collect(Collectors.partitioningBy(StreamProblems::isPrime));

        System.out.println(partition.get(true));
        System.out.println(partition.get(false));
    }

    public static boolean isPrime(int num) {
        boolean isPrime = num > 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    public static void averageStringLength() {
        List<String> input = List.of("hi","","world","java");

        System.out.println(input.stream()
                .filter(s -> !s.isBlank())
                .mapToInt(String::length).average());
    }

    public static void groupByStringLength() {
        List<String> input = List.of("a","bb","ccc","dd","eeee");
        System.out.println(input.stream().collect(Collectors.groupingBy(String::length, Collectors.toList())));
    }

    public static void findDuplicates() {
        List<Integer> input = List.of(1,2,1,3,2,4,5,2);
        Set<Integer> duplicates = new HashSet<>();
        System.out.println(input.stream().filter(n -> !duplicates.add(n)).collect(Collectors.toSet()));
    }

}
