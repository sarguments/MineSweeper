import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void 일반() {
        Game game = new Game(5, Arrays.asList(7));
        List<Integer> result = game.spread();
        assertThat(result).isEqualTo(
                Arrays.asList(
                        0, 0, 1, 0, 0,
                        0, 1, 0, 1, 0,
                        0, 0, 1, 0, 0,
                        0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0
                )
        );
    }

    @Test
    void 겹치기() {
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

    @Test
    void 범위_벗어나나() {
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

    @Test
    void 폭탄_무시하나() {
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
}
