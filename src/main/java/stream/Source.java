package stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Source {
    public static Stream<String> fromList(List<String> items) {
        return Stream.of(items);
    }

    public static Stream<String> fromFile(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return Stream.of(lines);
    }

    public static Stream<Integer> fromRange(int start, int end) {
        List<Integer> nums = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            nums.add(i);
        }
        return Stream.of(nums);
    }

    public static Stream<Integer> random(int count, int max) {
        Random rand = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nums.add(rand.nextInt(max));
        }
        return Stream.of(nums);
    }
}