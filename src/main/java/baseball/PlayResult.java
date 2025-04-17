package baseball;

public class PlayResult {
    private int STRIKE = 0;
    private int BALL = 0;

    public int getStrike() {
        return STRIKE;
    }

    public int getBall() {
        return BALL;
    }

    public void status(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            STRIKE++;
        }
        if (ballStatus.isBall()) {
            BALL++;
        }
    }

    public boolean isGameEnd() {
        return STRIKE == 3;
    }
}
