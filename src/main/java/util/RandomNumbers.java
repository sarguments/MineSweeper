package util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbers {
    private static final Random random = new Random();

    public static List<Integer> generate(int start, int end, int count) {
        if (start >= end || count < 0) {
            throw new IllegalArgumentException("start 가 end 보다 작거나, count가 0보다 작습니다");
        }

        return random.ints(start, end).limit(count).boxed().collect(Collectors.toList());
    }
}
