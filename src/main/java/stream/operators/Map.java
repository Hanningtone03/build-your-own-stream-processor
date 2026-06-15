package stream.operators;

import stream.Stream;

public class Map {
    public static Stream<String> toUpperCase(Stream<String> stream) {
        return stream.map(String::toUpperCase);
    }

    public static Stream<String> toLowerCase(Stream<String> stream) {
        return stream.map(String::toLowerCase);
    }

    public static Stream<Integer> toLength(Stream<String> stream) {
        return stream.map(String::length);
    }

    public static Stream<String> trim(Stream<String> stream) {
        return stream.map(String::trim);
    }

    public static Stream<Integer> multiply(Stream<Integer> stream, int factor) {
        return stream.map(n -> n * factor);
    }

    public static Stream<String> intToString(Stream<Integer> stream) {
        return stream.map(Object::toString);
    }
}