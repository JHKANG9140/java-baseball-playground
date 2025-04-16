package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int num;

    public Ball(int position, int num) {
        this.position = position;
        this.num = num;
    }

    public BallStatus check(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (this.num == ball.num) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, num);
    }

}
