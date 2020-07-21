package util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbers {
    private static final Random random = new Random();

    public static List<Integer> generate(int start, int end, int count) {
        return random.ints(start, end).limit(count).boxed().collect(Collectors.toList());
    }
}
