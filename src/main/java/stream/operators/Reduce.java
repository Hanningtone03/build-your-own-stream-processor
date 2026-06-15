package stream.operators;

import stream.Stream;

public class Reduce {
    public static int sum(Stream<Integer> stream) {
        return stream.reduce(0, Integer::sum);
    }

    public static int max(Stream<Integer> stream) {
        return stream.reduce(Integer.MIN_VALUE, Integer::max);
    }

    public static int min(Stream<Integer> stream) {
        return stream.reduce(Integer.MAX_VALUE, Integer::min);
    }

    public static double average(Stream<Integer> stream) {
        java.util.List<Integer> list = stream.toList();
        if (list.isEmpty()) return 0;
        int total = list.stream().mapToInt(Integer::intValue).sum();
        return (double) total / list.size();
    }

    public static String concat(Stream<String> stream, String delimiter) {
        return stream.reduce("", (a, b) -> a.isEmpty() ? b : a + delimiter + b);
    }
}