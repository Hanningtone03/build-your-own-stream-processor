package stream.operators;

import stream.Stream;
import java.util.function.Predicate;

public class Filter {
    public static <T> Stream<T> apply(Stream<T> stream, Predicate<T> predicate) {
        return stream.filter(predicate);
    }

    public static Stream<String> containsWord(Stream<String> stream, String word) {
        return stream.filter(s -> s.toLowerCase().contains(word.toLowerCase()));
    }

    public static Stream<Integer> greaterThan(Stream<Integer> stream, int threshold) {
        return stream.filter(n -> n > threshold);
    }

    public static Stream<Integer> lessThan(Stream<Integer> stream, int threshold) {
        return stream.filter(n -> n < threshold);
    }

    public static Stream<Integer> between(Stream<Integer> stream, int min, int max) {
        return stream.filter(n -> n >= min && n <= max);
    }
}