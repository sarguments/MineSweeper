package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumbersTest {
    @DisplayName("랜덤 숫자 생성 중복 테스트")
    @Test
    void duplicateTest() {
        List<Integer> generate = RandomNumbers.generate(0, 3, 3);
        assertThat(generate.size()).isEqualTo(3);

        assertThat(generate).containsOnlyOnce(0);
        assertThat(generate).containsOnlyOnce(1);
        assertThat(generate).containsOnlyOnce(2);
    }

    @DisplayName("유효 숫자 검증 테스트")
    @Test
    void numberValidateTest() {
        assertThatThrownBy(() -> RandomNumbers.generate(5, 1, 3))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("start 가 end 보다 클 수 없습니다.");

        assertThatThrownBy(() -> RandomNumbers.generate(-1, 5, 3))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("start 가 0 보다 커야 합니다.");

        assertThatThrownBy(() -> RandomNumbers.generate(1, 5, 10))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("count 갯수가 주어진 범위의 숫자보다 많습니다.");
    }
}