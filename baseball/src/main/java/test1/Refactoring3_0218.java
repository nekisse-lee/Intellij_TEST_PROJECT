package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Refactoring3_0218 {

    public static void main(String[] args) {


        gameStart();

    }


    // 게임 시작 메서드
    private static void gameStart() {
        boolean doing = true;
        List<Integer> comNum = createComNum();
        while (doing) {
            List<Integer> userNum = createUserNum();
            doing = countStrikeAndBall(comNum, userNum);
        }
    }

    private static boolean countStrikeAndBall(List<Integer> comNum, List<Integer> userNum) {
        int ball = countBall(comNum,userNum);
        int strike = countStrike(comNum,userNum);
//        for (int i = 0; i < comNum.size(); i++) {
//            checkResult(userNum, comNum.get(i), i);
//        }
        return checkResult(strike,ball);
    }




    private static int countStrike(List<Integer> comNum, List<Integer> userNum) {
        int strike = 0;
        for (int i = 0; i < comNum.size(); i++) {
            if (comNum.get(i).equals(userNum.get(i)))  {
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(List<Integer> comNum, List<Integer> userNum) {
        int ball = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if ( !comNum.contains(userNum.get(i)))  {
                ball++;
            }
        }
        return ball;
    }

    private static boolean checkResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
        if (strike == 3) {
            return false;
        }
        return true;
    }



    //컴퓨터의 랜덤 3자리 숫자를 만든다
    private static List<Integer> createComNum() {
        List<Integer> computerNum = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            int randomNum = (int) (Math.random() * 9) + 1;
            if (!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }
        System.out.println("정답   " + computerNum.get(0) + " " + computerNum.get(1) + " " + computerNum.get(2));
        return computerNum;
    }


    //유저 숫자를 만드는 메서드 -> inputUserNum()
    private static List<Integer> createUserNum() {
        List<Integer> userNum = null;
        while (userNum == null || userNum.size() != 3) {
            System.out.println("3자리의 숫자를 입력해주세요.");
            userNum = inputUserNum();
        }
        return userNum;
    }

    //유저 숫자를 입력받는메서드
    private static List<Integer> inputUserNum() {
        List<Integer> userNum = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            userNum.add(Integer.valueOf((String.valueOf(input.charAt(i)))));
        }
        printUserNum(userNum);
        return userNum;
    }

    private static void printUserNum(List<Integer> userNum) {
        System.out.print("입력값 :    ");
        for (Integer num : userNum) {
            System.out.print(num);
        }
        System.out.println();
    }


  /*  private static GameResult countStrikeAndBall(List<Integer> computerNum, List<Integer> userNum, GameResult gameResult) {
        for (int i = 0; i < computerNum.size(); i++) {
            checkResult(userNum, computerNum.get(i), i, gameResult);
        }
        return gameResult;
    }


    private static void checkResult(List<Integer> userNum, Integer comNum, Integer comIndex, GameResult gameResult) {
        if (!userNum.contains(comNum)) {
            return;
        }
        if (userNum.indexOf(comNum) == comIndex) {
            gameResult.increaseStrike();
            return;
        }
        gameResult.increaseBall();
    }


    private static class GameResult {
        private int strike;
        private int ball;

        void increaseStrike() {
            this.strike++;
        }

        void increaseBall() {
            this.ball++;
        }

        void print() {
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 3) {
                System.out.println("세자리 숫자를 모두 맞췄습니다.");
            } else {
                System.out.println(strike + "스트라이크 " + ball + "볼");
            }
        }

        boolean isDone() {
            return strike == 3;
        }

        void clear() {
            this.strike = 0;
            this.ball = 0;
        }
    }*/
}
