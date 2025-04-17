package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    private static int input;

    @BeforeEach
    void init() {
        input = 123;
    }

    @Test
    void generateRandomNums() {
        List<Integer> nums = Util.generateNumber();
        assertThat(nums.size()).isEqualTo(3);
        assertThat(Util.checkDuplication(nums.get(0), nums.get(1), nums.get(2))).isTrue();
    }

    @Test
    void numCountCheck() {
        assertThat(Util.checkNumbers(input)).isTrue();
    }

    @Test
    void numToArray() {
        assertThat(Util.numToArray(input)).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void checkInputNumber() {
        assertThat(Util.checkNumber(1)).isTrue();
        assertThat(Util.checkNumber(9)).isTrue();
        assertThat(Util.checkNumber(0)).isFalse();
        assertThat(Util.checkNumber(10)).isFalse();
    }

    @Test
    void checkInputNumberDuplication() {
        assertThat(Util.checkDuplication(1, 2, 3)).isTrue();
        assertThat(Util.checkDuplication(1, 1, 3)).isFalse();
        assertThat(Util.checkDuplication(1, 2, 1)).isFalse();
        assertThat(Util.checkDuplication(1, 2, 2)).isFalse();
    }

    @Test
    void checkPlayContinue() {
        assertThat(Util.continueCheck("Y")).isTrue();
    }
}
