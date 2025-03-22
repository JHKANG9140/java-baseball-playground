package study;


public class Calculator {

    int StringCalculator(String expression) {
        String[] split = expression.split(" ");
        int result = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; i += 2) {
            result = intermediateResults(result, split[i], Integer.parseInt(split[i + 1]));
        }

        return result;
    }

    private int intermediateResults(int a, String operator, int b) {
        switch (operator) {
            case "+":
                return add(a, b);
            case "-":
                return sub(a, b);
            case "*":
                return multiply(a, b);
            default:
                return divide(a, b);
        }
    }

    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

}
