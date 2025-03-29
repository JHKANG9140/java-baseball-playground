package study.baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumberBaseball {
    /*
    기능 요구 사항
    기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

    같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
    위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
    게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
     */

    /*
    자바 코드 컨벤션을 지키면서 프로그래밍한다.
        기본적으로 Google Java Style Guide을 원칙으로 한다.
        단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
    indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
        예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
        힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
    else 예약어를 쓰지 않는다.
        힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
        else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
        핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
        UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
    3항 연산자를 쓰지 않는다.
    함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.`
     */

    public void main() {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            playGame(in);
            playAgain = checkPlayAgain(in);
        }
        System.out.println("게임을 종료합니다.");
        in.close();

    }

    public void playGame(Scanner in) {
        String[] comArr = generateRandomNumber();
        String[] userArr = {"","",""};

        while (!checkSame(userArr, comArr)) {
            System.out.printf("숫자를 입력해 주세요: ");
            String userNum = in.nextLine();

            userArr = userNum.split("");

            System.out.println(getBallAndStrike(userArr, comArr));

        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public boolean checkSame(String[] userArr, String[] comArr) {
        if (userArr[0].equals(comArr[0]) && userArr[1].equals(comArr[1]) && userArr[2].equals(comArr[2])) return true;
        return false;
    }

    public String[] generateRandomNumber() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        String[] result = new String[3];
        result[0] = String.valueOf(numbers.get(0));
        result[1] = String.valueOf(numbers.get(1));
        result[2] = String.valueOf(numbers.get(2));
        return result;
    }

    public String getBallAndStrike(String[] userArr, String[] comArr) {
        int strike = countStrike(userArr, comArr);
        int ball = countBall(userArr, comArr);

        if (strike == 0 && ball != 0) return ball + "ball";
        if (strike != 0 && ball == 0) return strike + "strike";
        if (strike != 0 && ball != 0) return ball + "ball " + strike + "strike";
        return "Nothing";
    }

    public int countStrike(String[] userArr, String[] comArr) {
        int strike = 0;
        strike += checkStrikeAt(userArr[0], comArr[0]);
        strike += checkStrikeAt(userArr[1], comArr[1]);
        strike += checkStrikeAt(userArr[2], comArr[2]);
        return strike;
    }

    public int checkStrikeAt(String a, String b) {
        if (a.equals(b)) return 1;
        return 0;
    }

    public int countBall(String[] userArr, String[] comArr) {
        int balls = 0;
        balls += countBallForPosition(userArr, comArr, 0);
        balls += countBallForPosition(userArr, comArr, 1);
        balls += countBallForPosition(userArr, comArr, 2);
        return balls;
    }

    public int countBallForPosition(String[] userArr, String[] comArr, int i) {
        int ball = 0;
        ball += countBallAt(userArr, comArr, i, 0);
        ball += countBallAt(userArr, comArr, i, 1);
        ball += countBallAt(userArr, comArr, i, 2);
        return ball;
    }

    public int countBallAt(String[] userArr, String[] comArr, int i, int j) {
        if (userArr[i].equals(comArr[j]) && i != j) return 1;
        return 0;
    }

    public boolean checkPlayAgain(Scanner in) {
        //하나의 scanner로 nextInt, nextLine 을 동시에 쓸수 없는듯
        String choice = in.nextLine();
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choice = in.nextLine();
        }
        if (choice.equals("1")) return true;
        return false;
    }
}
