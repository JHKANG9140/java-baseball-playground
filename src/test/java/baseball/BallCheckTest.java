package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCheckTest {

    private static Ball com;
    @BeforeEach
    void init() {
        com = new Ball(1, 1);
    }

    @Test
    void nothing() {
        assertThat(com.check(new Ball(1, 2))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        assertThat(com.check(new Ball(2, 1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        assertThat(com.check(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }
}
