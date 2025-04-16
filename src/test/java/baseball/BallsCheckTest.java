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
