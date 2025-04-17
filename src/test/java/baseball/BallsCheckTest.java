package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsCheckTest {

    private static Balls com;

    @BeforeEach
    void init() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_nothing() {
        PlayResult result = com.play(new Balls(Arrays.asList(4, 5, 6)));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        PlayResult result = com.play(new Balls(Arrays.asList(1, 4, 2)));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_2strike() {
        PlayResult result = com.play(new Balls(Arrays.asList(1, 2, 4)));
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_3strike() {
        PlayResult result = com.play(new Balls(Arrays.asList(1, 2, 3)));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void nothing() {
        assertThat(com.check(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        assertThat(com.check(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        assertThat(com.check(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }
}
