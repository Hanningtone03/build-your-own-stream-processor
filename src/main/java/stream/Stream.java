package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream<T> {
    private final List<T> data;

    public Stream(List<T> data) {
        this.data = new ArrayList<>(data);
    }

    public Stream<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return new Stream<>(result);
    }

    public <R> Stream<R> map(Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : data) {
            result.add(mapper.apply(item));
        }
        return new Stream<>(result);
    }

    public T reduce(T identity, java.util.function.BinaryOperator<T> accumulator) {
        T result = identity;
        for (T item : data) {
            result = accumulator.apply(result, item);
        }
        return result;
    }

    public void forEach(Consumer<T> action) {
        for (T item : data) {
            action.accept(item);
        }
    }

    public List<T> toList() {
        return new ArrayList<>(data);
    }

    public long count() {
        return data.size();
    }

    public static <T> Stream<T> of(List<T> data) {
        return new Stream<>(data);
    }
}