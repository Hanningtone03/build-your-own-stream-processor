package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Pipeline<T> {
    private Stream<T> stream;
    private final List<String> log = new ArrayList<>();

    public Pipeline(Stream<T> source) {
        this.stream = source;
        log.add("Source: " + source.count() + " records");
    }

    public Pipeline<T> filter(java.util.function.Predicate<T> predicate, String label) {
        stream = stream.filter(predicate);
        log.add("Filter [" + label + "]: " + stream.count() + " records remaining");
        return this;
    }

    public <R> Pipeline<R> map(Function<T, R> mapper, String label) {
        Stream<R> mapped = stream.map(mapper);
        log.add("Map [" + label + "]: applied");
        Pipeline<R> next = new Pipeline<>(mapped);
        next.log.addAll(this.log);
        return next;
    }

    public Stream<T> build() {
        log.add("Pipeline complete: " + stream.count() + " records");
        printLog();
        return stream;
    }

    private void printLog() {
        System.out.println("\n  Pipeline execution:");
        for (String entry : log) {
            System.out.println("  -> " + entry);
        }
        System.out.println();
    }
}