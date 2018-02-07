package test1;

import java.util.Scanner;

public class Refactoring2 {
    public static void main(String[] args) {
        int[] computerNum = createComNum();
        int[] userNum = createUserNum();
        while (gameRun()) {

            countStrike(computerNum, computerNum);
            ball(computerNum, userNum);
        }


    }


    //컴퓨터의 랜덤 3자리 숫자를 만들고 유저의 숫자를 입력받는다.
    private static int[] createComNum() {
        int[] computerNum = new int[3];
        boolean randomNum = true;
        while (randomNum) {
            for (int i = 0; i < computerNum.length; i++) {
                computerNum[i] = (int) (Math.random() * 9) + 1;
            }
            randomNum = checkRandomNum(computerNum, randomNum);
        }
        System.out.println("자릿수 중복 없는 컴퓨터 값 생성");
        return computerNum;
    }

    //유저 숫자를 입력받고 ,    컴퓨터숫자와 유저숫자를 가지고 비교하는 메서드를 실행
    private static int[] createUserNum() {
        int[] userNum = new int[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < userNum.length; i++) {
            System.out.println((i + 1) + "번째 숫자를 입력해 주세요");
            userNum[i] = scanner.nextInt();
        }
        System.out.println("유저값   " + userNum[0] + " " + userNum[1] + " " + userNum[2]);
        return userNum;

    }

//    //유저 숫자를 입력받는 메서드
//    private static void createUserInputNum(int[] userNum) {
//        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i < userNum.length; i++) {
//            System.out.println((i + 1) + "번째 숫자를 입력해 주세요");
//            userNum[i] = scanner.nextInt();
//        }
//        System.out.println("유저값   " + userNum[0] + " " + userNum[1] + " " + userNum[2]);
//    }

    //  컴퓨터 숫자와 유저숫자를 비교, strike와 ball을 알려주는 메서드
//    private static boolean compareComputerNumAndUserNum(int[] computerNum, int[] userNum) {
//        computerNum = createComNum();
//        userNum = createUserNum();
//        if (countStrikeAndBall(computerNum, userNum) == 3) {
//            System.out.println("세자리 숫자를 모두 맞췄습니다.");
//            return false;
//        }
//        return true;
//    }

//    private static int countStrikeAndBall(int[] computerNum, int[] userNum) {
//        int strike = 0;
//        int ball = 0;
//        for (int i = 0; i < computerNum.length; i++) {
//            if (computerNum[i] == userNum[i]) {
//                strike++;
//            } else {
//                ball = countBall(computerNum[i], userNum, ball);
//            }
//        }
//        System.out.println(strike + "스트라이크  " + ball + "볼");
//        return strike;
//    }

    private static boolean gameRun() {
        if (countStrike(createComNum(),createUserNum())== 3) {
            return false;
        }
        return true;
    }

    private static int countStrike(int[] computerNum, int[] userNum) {
        int strike=0;
        for (int i = 0; i < computerNum.length; i++) {
            if (computerNum[i] == userNum[i]) {
                strike++;
            }
        }
        System.out.println(strike + "스트라이크");
        return strike;
    }

    private static int ball(int[] computerNum, int[] userNum) {
        int ball=0;
        for (int i = 0; i < computerNum.length; i++) {
            if (computerNum[i] == userNum[i]) {
                ball++;
            }
        }
        System.out.println(ball + "스트라이크");
        return ball;
    }


    private static int countBall(int i, int[] userNum, int ball) {
        for (int j = 0; j < userNum.length; j++) {
            if (i == userNum[j]) {
                ball++;
            }
        }
        return ball;
    }


    private static boolean checkRandomNum(int[] computerNum, boolean randomNum) {
        if (computerNum[0] != computerNum[1] && computerNum[0] != computerNum[2] && computerNum[1] != computerNum[2]) {
            System.out.println("컴퓨터값  " + computerNum[0] + " " + computerNum[1] + " " + computerNum[2]);
            randomNum = false;
        }
        return randomNum;
    }
}
