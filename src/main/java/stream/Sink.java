package stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Sink {
    public static <T> void toConsole(Stream<T> stream) {
        stream.forEach(item -> System.out.println("  " + item));
    }

    public static <T> void toFile(Stream<T> stream, String path) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        stream.forEach(item -> writer.println(item));
        writer.close();
        System.out.println("Output written to " + path);
    }

    public static <T> List<T> toList(Stream<T> stream) {
        return stream.toList();
    }
}