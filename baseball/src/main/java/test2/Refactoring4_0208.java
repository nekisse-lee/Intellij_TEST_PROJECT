package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Refactoring4_0208 {

    public static void main(String[] args) {


        gameStart();

    }


    // 게임 시작 메서드
    private static void gameStart() {
        List<Integer> comNum =createComNum();
        GameResult gameResult = new GameResult();
        while (!gameResult.isDone()) {
            gameResult.clear();
            List<Integer> userNum = inputUserNum();
            gameResult = countStrikeAndBall(comNum, userNum, gameResult);
            gameResult.print();
        }
    }

    private static List<Integer> inputUserNum() {
        List<Integer> userNum = null;
        while(userNum == null || userNum.size() != 3) {
            System.out.println("3자리의 숫자를 입력해주세요.");
            userNum = createUserInputNum();
        }
        return userNum;
    }


    //컴퓨터의 랜덤 3자리 숫자를 만든다
    private static List<Integer> createComNum() {
        List<Integer> computerNum = new ArrayList<Integer>();
        while (computerNum.size() < 3) {
            int randomNum = (int) (Math.random() * 9) + 1;
            if(computerNum.contains(randomNum)) {
                continue;
            }
            computerNum.add(randomNum);
        }
        System.out.println("정답   " + computerNum.get(0) + " " + computerNum.get(1) + " " + computerNum.get(2));
        return computerNum;
    }


    //유저 숫자를 입력받는 메서드
    private static List<Integer> createUserInputNum() {
        List<Integer> userNum = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            userNum.add(Integer.valueOf((String.valueOf(input.charAt(i)))));
        }

        System.out.println("입력값 : ");
        for(Integer num : userNum) {
            System.out.print(num);
        }
        System.out.println();
        return userNum;
    }

    private static GameResult countStrikeAndBall(List<Integer> computerNum, List<Integer> userNum, GameResult gameResult) {
        for(int i=0; i < computerNum.size(); i++) {
            checkResult(userNum, computerNum.get(i), i, gameResult);
        }
        return gameResult;
    }

    private static void checkResult(List<Integer> userNum, Integer comNum, Integer comIndex, GameResult gameResult) {
        if(!userNum.contains(comNum)) {
            return;
        }
        if(userNum.indexOf(comNum) == comIndex) {
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
    }
}
