package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls;

    public Balls(List<Integer> balls) {
        this.balls = mapBalls(balls);
    }

    private List<Ball> mapBalls(List<Integer> balls) {
        List<Ball> mappingBall = new ArrayList<>();
        for (int i = 0; i < balls.size(); i++) {
            mappingBall.add(new Ball(i + 1, balls.get(i)));
        }
        return mappingBall;
    }

    /**
     * 컴퓨터 입력값과 유저 입력값중 공 하나 비교
     * @param ball
     * @return
     */
    public BallStatus check(Ball ball) {
        return balls.stream()
                .map(answer -> answer.check(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    /**
     * 컴퓨터 입력값과 유저의 입력값 비교
     * @param userBalls
     * @return
     */
    public PlayResult play(Balls userBalls) {
        PlayResult result = new PlayResult();
        for (Ball ball : userBalls.balls) {
            BallStatus ballStatus = check(ball);
            result.status(ballStatus);
        }
        return result;
    }

    @Override
    public String toString() {
        return balls.get(0).getNum() + " " + balls.get(1).getNum() + " " + balls.get(2).getNum();
    }
}
