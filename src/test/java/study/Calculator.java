package study;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    int StringCalculator(String expression) {
        String[] split = expression.split(" ");
        List<Integer> nums = new ArrayList<>();
        List<String> operator = new ArrayList<>();
        for (String s : split) {
            if (intCheck(s)) nums.add(Integer.parseInt(s));
            else operator.add(s);
        }
        int result = 0;
        for (int i = 0; i < operator.size(); i++) {
            if (result == 0) {
                result = intermediateResults(nums.get(i), operator.get(i), nums.get(i + 1));
            } else {
                result = intermediateResults(result, operator.get(i), nums.get(i + 1));
            }
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

    private boolean intCheck(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
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
