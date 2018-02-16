package test1;

import java.util.Scanner;

public class Refactoring3_021412J {

    private static final int GAME_INPUT_LENGTH = 3;

    public static void main(String[] args) {
        gameStart();
    }


    // 게임 시작 메서드
    private static void gameStart() {
        boolean start = true;
        int[] comNum = createComNum();
        while (start) {
            int[] userNum = createUserNum();
            start = countStrikeAndBall(comNum, userNum);
        }
        System.out.println("세자리 숫자를 모두 맞췄습니다.");
    }


    //컴퓨터의 랜덤 3자리 숫자를 만든다
    private static int[] createComNum() {
        int[] computerNum = new int[GAME_INPUT_LENGTH];
        boolean randomNum = true;
        while (randomNum) {
            for (int i = 0; i < GAME_INPUT_LENGTH; i++) {
                computerNum[i] = getRandomNumeric();
            }
            randomNum = checkRandomNum(computerNum);
        }
        return computerNum;
    }

    private static int getRandomNumeric() {
        return (int) (Math.random() * 9) + 1;
    }


    //유저 숫자 만들기
    private static int[] createUserNum() {
        String userInput = String.valueOf(Integer.parseInt(inputUserNum()));
        int[] userNum = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++) {
            userNum[i] = userInput.charAt(i) - '0';
        }
        return userNum;
    }

    private static boolean isGameInputLength(String userNum) {
        return userNum != null && userNum.length() == GAME_INPUT_LENGTH;
    }


    //유저 숫자를 입력받는다
    private static String inputUserNum() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("3자리 숫자를 입력하세요");
            userInput = scanner.nextLine();
        }while (!isGameInputLength(userInput) || !isNumeric(userInput));
        return userInput;
    }


    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(String.valueOf(str));
        } catch (NumberFormatException nfe) {
            System.out.println("공백 또는 문자는 입력 불가능합니다. 3자리 숫자만 입력해 주세요");
            return false;
        }
        return true;
    }

    //컴퓨터숫자와 유저숫자를 비교해 볼과 카운트를 구한다
    private static boolean countStrikeAndBall(int[] computerNum, int[] userNum) {
        int strike = countStrike(computerNum, userNum);
        int ball = countBall(computerNum, userNum);
        return result(strike, ball);
    }

    private static boolean result(int strike, int ball) {
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


    //볼 카운트
    private static int countBall(int[] computerNum, int[] userNum) {
        int ball = 0;
        for (int i = 0; i < computerNum.length; i++) {
            for (int j = 0; j < userNum.length; j++)
                if (computerNum[i] == userNum[j] && i != j) {
                    ball++;
                }
        }
        return ball;
    }


    //스트라이크 카운트
    private static int countStrike(int[] computerNum, int[] userNum) {
        int strike = 0;
        for (int i = 0; i < computerNum.length; i++) {
            if (computerNum[i] == userNum[i]) {
                strike++;
            }
        }
        return strike;
    }

    //컴퓨터의 숫자 중복체크
    private static boolean checkRandomNum(int[] computerNum) {
        if (computerNum[0] != computerNum[1] && computerNum[0] != computerNum[2] && computerNum[1] != computerNum[2]) {
            System.out.println("컴퓨터값  " + computerNum[0] + " " + computerNum[1] + " " + computerNum[2]);
            System.out.println("자릿수 중복 없는 컴퓨터 값 생성");
            return false;
        }
        return true;
    }
}