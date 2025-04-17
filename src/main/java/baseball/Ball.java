package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int num;

    public Ball(int position, int num) {
        this.position = position;
        this.num = num;
    }

    /**
     * 공과 공의 strike, ball, nothing 판단
     * @param ball
     * @return
     */
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

    /**
     * 랜덤 입력 번호 확인 목적
     * @return
     */
    public int getNum() {
        return num;
    }
}
