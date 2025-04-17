package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playGame(in);
            playAgain = checkPlayAgain(in);
        }
        System.out.println("게임을 종료합니다.");
        in.close();
    }

    private static void playGame(Scanner in) {
        Balls comNum = new Balls(Util.generateNumber());
        System.out.println(comNum.toString());
        Balls userNum = new Balls(Arrays.asList(0, 0, 0));
        boolean gameFlag = true;
        while (gameFlag) {
            userNum = userInput(in);
            PlayResult play = comNum.play(userNum);
            System.out.println(play.getStrike() + " strike " + play.getBall() + " ball");
            gameFlag = !play.isGameEnd();
        }
    }

    private static Balls userInput(Scanner in) {
        boolean reInputFlag = true;
        int input = 0;
        while (reInputFlag) {
            System.out.printf("숫자를 입력해 주세요: ");
            input = in.nextInt();
            reInputFlag = validation(input);
        }
        //TODO Util.numToArray(input)를 두번하는 상황 수정 필요
        return new Balls(Util.numToArray(input));
    }

    private static boolean validation(int input) {
        if (!Util.checkNumbers(input)) {
            System.out.println("세자리 숫자를 입력해야 합니다.");
            return true;
        }
        List<Integer> inputArr = Util.numToArray(input);
        if (!Util.checkDuplication(inputArr.get(0), inputArr.get(1), inputArr.get(2))) {
            System.out.println("중복된 숫자를 입력할 수 없습니다.");
            return true;
        }
        return false;
    }

    public static boolean checkPlayAgain(Scanner in) {
        //하나의 scanner로 nextInt, nextLine 을 동시에 쓸수 없는듯
        String choice = in.nextLine();
        while (!choice.equals("Y") && !choice.equals("N")) {
            System.out.printf("계속 플레이 하시겠습니까? (Y/N): ");
            choice = in.nextLine();
        }
        if (choice.equals("Y")) return true;
        return false;
    }
}
