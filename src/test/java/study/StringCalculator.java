package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculator {

    /**
     * 요구사항
     * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
     * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     */

    /**
     * 위의 요구사항을 JUnit을 활용해 단위 테스트 코드를 추가해 구현한다.
     * 단위 테스트 코드를 추가한다는 말이 이해가 가지 않는다. 단위 테스트를 하기 위해서는 계산기 코드가 필요하기 때문에 Calculator클래스를 구현해 버리고 테스트는 여기서 짧게 구현함.
     * 한데 테스트 코드를 추가해 구현하라는 의미는 테스트 코드에서 계산기의 로직을 먼저 구현하라는 의미일까?
     * 피드백 강의를 한번 봐야 할듯
     */

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void stringCalculatorTest() {
        int i = calculator.StringCalculator("2 + 3 * 4 / 2");
        assertThat(i).isEqualTo(10);
    }

}
