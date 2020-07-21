import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomNumbers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @DisplayName("일반적인 지뢰 카운트")
    @Test
    void normalTest() {
        Game game = new Game(5, Arrays.asList(7));
        List<Integer> result = game.spread();
        assertThat(result).isEqualTo(
                Arrays.asList(
                        0, 1, 1, 1, 0,
                        0, 1, 0, 1, 0,
                        0, 1, 1, 1, 0,
                        0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0
                )
        );
    }

    @DisplayName("두개의 지뢰 카운트가 겹치는 부분이 있는 경")
    @Test
    void overlapTest() {
        Game game = new Game(5, Arrays.asList(7, 17));
        List<Integer> result = game.spread();
        assertThat(result).isEqualTo(
                Arrays.asList(
                        0, 1, 1, 1, 0,
                        0, 1, 0, 1, 0,
                        0, 2, 2, 2, 0,
                        0, 1, 0, 1, 0,
                        0, 1, 1, 1, 0
                )
        );
    }

    @DisplayName("지뢰 카운트가 가장자리에 걸쳐서 범위를 벗어나는 경")
    @Test
    void outOfRangeTest() {
        Game game = new Game(5, Arrays.asList(0, 4, 20, 24));
        List<Integer> result = game.spread();
        assertThat(result).isEqualTo(
                Arrays.asList(
                        0, 1, 0, 1, 0,
                        1, 1, 0, 1, 1,
                        0, 0, 0, 0, 0,
                        1, 1, 0, 1, 1,
                        0, 1, 0, 1, 0
                )
        );
    }

    @DisplayName("이미 지뢰가 존재하고 또다른 지뢰가 기존 지뢰를 무시하는 경우")
    @Test
    void ignoreMineTest() {
        Game game = new Game(5, Arrays.asList(7, 12));
        List<Integer> result = game.spread();
        assertThat(result).isEqualTo(
                Arrays.asList(
                        0, 1, 1, 1, 0,
                        0, 2, 0, 2, 0,
                        0, 2, 0, 2, 0,
                        0, 1, 1, 1, 0,
                        0, 0, 0, 0, 0
                )
        );
    }

    @DisplayName("지뢰 갯수가 10개이고 테이블 크기가 10x10  경우")
    @Test
    void tenMineTest() {
        Game game = new Game(10, Arrays.asList(12, 4, 22, 24, 40, 60, 99));
        List<Integer> result = game.spread();
        assertThat(result).isEqualTo(
                Arrays.asList(
                        0, 1, 1, 2, 0, 1, 0, 0, 0, 0,
                        0, 2, 0, 4, 2, 2, 0, 0, 0, 0,
                        0, 2, 0, 3, 0, 1, 0, 0, 0, 0,
                        1, 2, 1, 2, 1, 1, 0, 0, 0, 0,
                        0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                        2, 2, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                        1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0
                )
        );

        game.print();
    }

    @DisplayName("랜덤 넘버 생성 후 주입")
    @Test
    void randomNumberGenerate() {
        List<Integer> generate = RandomNumbers.generate(0, 100, 10);
        System.out.println(generate);

        Game game = new Game(10, generate);
        game.spread();
        game.print();
    }
}
