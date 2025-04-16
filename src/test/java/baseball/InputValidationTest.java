package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidationTest {

    @Test
    void checkInputNumber() {
        assertThat(InputValidation.checkNumber(1)).isTrue();
        assertThat(InputValidation.checkNumber(9)).isTrue();
        assertThat(InputValidation.checkNumber(0)).isFalse();
        assertThat(InputValidation.checkNumber(10)).isFalse();
    }

    @Test
    void checkInputNumberDuplication() {
        assertThat(InputValidation.checkDuplication(1, 2, 3)).isTrue();
        assertThat(InputValidation.checkDuplication(1, 1, 3)).isFalse();
        assertThat(InputValidation.checkDuplication(1, 2, 1)).isFalse();
        assertThat(InputValidation.checkDuplication(1, 2, 2)).isFalse();

    }


}
