package study.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballTest {

    private NumberBaseball numberBaseball;

    @BeforeEach
    void setUp() {
        numberBaseball = new NumberBaseball();
    }

    @Test
    void testCheckSame_WhenArraysAreEqual() {
        String[] userArr = {"1", "2", "3"};
        String[] comArr = {"1", "2", "3"};
        assertTrue(numberBaseball.checkSame(userArr, comArr), "동일한 배열은 true를 반환해야 합니다.");
    }

    @Test
    void testCheckSame_WhenArraysAreDifferent() {
        String[] userArr = {"1", "2", "3"};
        String[] comArr = {"1", "3", "2"};
        assertFalse(numberBaseball.checkSame(userArr, comArr), "다른 배열은 false를 반환해야 합니다.");
    }

    @Test
    void testGenerateRandomNumber() {
        String[] result = numberBaseball.generateRandomNumber();
        assertEquals(3, result.length, "배열 길이는 3이어야 합니다.");
        assertTrue(result[0].matches("[1-9]") && result[1].matches("[1-9]") && result[2].matches("[1-9]"),
                "모든 요소는 1~9 사이의 숫자여야 합니다.");
        assertFalse(result[0].equals(result[1]) || result[1].equals(result[2]) || result[0].equals(result[2]),
                "모든 요소는 서로 달라야 합니다.");
    }

    @Test
    void testGetBallAndStrike_OneStrike() {
        String[] userArr = {"1", "2", "3"};
        String[] comArr = {"1", "3", "4"};
        String result = numberBaseball.getBallAndStrike(userArr, comArr);
        assertEquals("1ball 1strike", result, "1볼 1스트라이크가 반환되어야 합니다.");
    }

    @Test
    void testGetBallAndStrike_OneBallOneStrike() {
        String[] userArr = {"2", "1", "3"};
        String[] comArr = {"1", "2", "3"};
        String result = numberBaseball.getBallAndStrike(userArr, comArr);
        assertEquals("2ball 1strike", result, "2볼 1스트라이크가 반환되어야 합니다.");
    }

    @Test
    void testGetBallAndStrike_Nothing() {
        String[] userArr = {"4", "5", "6"};
        String[] comArr = {"1", "2", "3"};
        String result = numberBaseball.getBallAndStrike(userArr, comArr);
        assertEquals("Nothing", result, "낫싱이 반환되어야 합니다.");
    }

    @Test
    void testCountStrike() {
        String[] userArr = {"1", "2", "3"};
        String[] comArr = {"1", "3", "2"};
        int result = numberBaseball.countStrike(userArr, comArr);
        assertEquals(1, result, "스트라이크 수는 1이어야 합니다.");
    }

    @Test
    void testCountBall() {
        String[] userArr = {"2", "1", "3"};
        String[] comArr = {"1", "2", "3"};
        int result = numberBaseball.countBall(userArr, comArr);
        assertEquals(2, result, "볼 수는 2어야 합니다.");
    }

    @Test
    void testCheckStrikeAt_WhenEqual() {
        int result = numberBaseball.checkStrikeAt("1", "1");
        assertEquals(1, result, "동일한 경우 1을 반환해야 합니다.");
    }

    @Test
    void testCheckStrikeAt_WhenNotEqual() {
        int result = numberBaseball.checkStrikeAt("1", "2");
        assertEquals(0, result, "다른 경우 0을 반환해야 합니다.");
    }

    @Test
    void testCountBallAt_WhenBall() {
        String[] userArr = {"2", "1", "3"};
        String[] comArr = {"1", "2", "3"};
        int result = numberBaseball.countBallAt(userArr, comArr, 0, 1);
        assertEquals(1, result, "볼인 경우 1을 반환해야 합니다.");
    }

    @Test
    void testCountBallAt_WhenNotBall() {
        String[] userArr = {"2", "1", "3"};
        String[] comArr = {"1", "2", "3"};
        int result = numberBaseball.countBallAt(userArr, comArr, 0, 0);
        assertEquals(0, result, "볼이 아닌 경우 0을 반환해야 합니다.");
    }

}