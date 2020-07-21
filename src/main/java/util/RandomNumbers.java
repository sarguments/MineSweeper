package util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbers {
    private static final Random random = new Random();
    public static final int ZERO = 0;

    public static List<Integer> generate(int start, int end, int count) {
        if (start >= end) {
            throw new IllegalArgumentException("start 가 end 보다 클 수 없습니다.");
        }

        if (start < ZERO || count < ZERO) {
            throw new IllegalArgumentException("start 가 0 보다 커야 합니다.");
        }

        if (end - start < count) {
            throw new IllegalArgumentException("count 갯수가 주어진 범위의 숫자보다 많습니다.");
        }


        return random.ints(start, end).distinct().limit(count).boxed().collect(Collectors.toList());
    }
}
