package stream;

import stream.operators.Filter;
import stream.operators.Map;
import stream.operators.Reduce;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n========================================");
        System.out.println("  Stream Processor");
        System.out.println("========================================\n");

        System.out.println("  [1] Number pipeline");
        Stream<Integer> numbers = Source.fromRange(1, 20);
        Stream<Integer> evens = Filter.greaterThan(numbers, 5);
        Stream<Integer> doubled = Map.multiply(evens, 2);
        int total = Reduce.sum(doubled);
        System.out.println("  Numbers 6-20 doubled and summed: " + total);

        System.out.println("\n  [2] Text pipeline");
        List<String> words = Arrays.asList(
            "Nairobi", "backend", "Java", "stream", "processor",
            "data", "engineering", "pipeline", "filter", "map"
        );
        Stream<String> text = Source.fromList(words);
        Stream<String> filtered = Filter.containsWord(text, "a");
        Stream<String> upper = Map.toUpperCase(filtered);
        System.out.println("  Words containing 'a' uppercased:");
        Sink.toConsole(upper);

        System.out.println("\n  [3] Pipeline with logging");
        Stream<Integer> raw = Source.random(50, 100);
        Pipeline<Integer> pipeline = new Pipeline<>(raw);
        Stream<Integer> result = pipeline
            .filter(n -> n > 30, "greater than 30")
            .filter(n -> n % 2 == 0, "even numbers only")
            .build();

        System.out.println("  Result count: " + result.count());
        System.out.println("  Sum: " + Reduce.sum(result));
        System.out.println("  Max: " + Reduce.max(result));
        System.out.println("  Min: " + Reduce.min(result));

        System.out.println("\n========================================\n");
    }
}