package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Util 함수 모음
 */
public class Util {

    private static final int MIN = 1;
    private static final int MAX = 9;

    /**
     * 숫자가 1~9 내의 숫자인지 판단
     * @param i
     * @return
     */
    public static boolean checkNumber(int i) {
        return (i >= MIN && i <= MAX);
    }

    /**
     * 세 숫자 중 중복된 숫자가 있는지 판단
     * @param first
     * @param second
     * @param third
     * @return
     */
    public static boolean checkDuplication(int first, int second, int third) {
        return first != second && second != third && third != first;
    }

    /**
     * 입력받은 숫자가 3자리인지 판단
     * @param input
     * @return
     */
    public static boolean checkNumbers(int input) {
        return input >= 100 && input <= 999;
    }

    /**
     * 숫자를 배열로 변경
     *
     * @param inputNum
     * @return
     */
    public static List<Integer> numToArray(int inputNum) {
        // 백의 자리수: 123 / 100 = 1
        int hundreds = inputNum / 100;
        // 십의 자리수: (123 % 100) / 10 = 23 / 10 = 2
        int tens = (inputNum % 100) / 10;
        // 일의 자리수: 123 % 10 = 3
        int ones = inputNum % 10;

        return Arrays.asList(hundreds, tens, ones);
    }

    public static boolean continueCheck(String choice) {
        return choice.equals("Y");
    }

    public static List<Integer> generateNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        return Arrays.asList(numbers.get(0), numbers.get(1), numbers.get(2));
    }
}
