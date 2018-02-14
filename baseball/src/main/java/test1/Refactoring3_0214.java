package test1;

import java.util.Scanner;

public class Refactoring3_0214 {
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
        int[] computerNum = new int[3];
        boolean randomNum = true;
        while (randomNum) {
            for (int i = 0; i < computerNum.length; i++) {
                computerNum[i] = (int) (Math.random() * 9) + 1;
            }
            randomNum = checkRandomNum(computerNum);
        }
        return computerNum;
    }


    //유저 숫자 만들기
    private static int[] createUserNum() {
        int[] userNum = inputUserNum();
        while (userNum.length != 3 || userNum == null) {
            System.out.println("3자리 숫자를 입력하세요");
            userNum = inputUserNum();
        }
        return userNum;
    }


    //유저 숫자를 입력받는다
    private static int[] inputUserNum() {
        Scanner scanner = new Scanner(System.in);
        String input = String.valueOf(Integer.parseInt(scanner.nextLine()));
        int[] userNum = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            userNum[i] = input.charAt(i) - '0';
        }
        return userNum;
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