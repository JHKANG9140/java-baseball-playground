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

    public BallStatus check(Ball ball) {
        return balls.stream()
                .map(answer -> answer.check(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
