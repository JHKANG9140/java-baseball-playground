package baseball;

public class InputValidation {

    private static final int MIN = 1;
    private static final int MAX = 9;

    public static boolean checkNumber(int i) {
        return (i >= MIN && i <= MAX);
    }

    public static boolean checkDuplication(int first, int second, int third) {
        return first != second && second != third && third != first;
    }
}
