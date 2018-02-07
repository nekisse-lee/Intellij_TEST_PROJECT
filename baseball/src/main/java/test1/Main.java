package test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        createComNum();


    }


    //컴퓨터의 랜덤 3자리 숫자를 만들고 유저의 숫자를 입력받는다.
    private static void createComNum() {
        int[] computerNum = new int[3];
        boolean randomNum = true;
        while (randomNum) {
            for (int i = 0; i < computerNum.length; i++) {
                computerNum[i] = (int) (Math.random() * 9) + 1;
            }
            randomNum = chekRandomNum(computerNum, randomNum);
        }
        System.out.println("컴퓨터 값 생성");
        createUserNum(computerNum);
    }

    //유저 숫자를 입력받고     컴퓨터 숫자와 유저숫자를 비교하는 메서드 실행
    private static void createUserNum(int[] computerNum) {
        int[] userNum = new int[3];
        System.out.println("게임 시작 유저 값 입력");
        Scanner scanner = new Scanner(System.in);
        boolean gameStart = true;
        while (gameStart) {
            for (int i = 0; i < userNum.length; i++) {
                System.out.println((i + 1) + "번째 숫자를 입력해 주세요");
                userNum[i] = scanner.nextInt();
            }
            System.out.println("유저값   " + userNum[0] + " " + userNum[1] + " " + userNum[2]);
           gameStart =  comNumEqualsUserNum(computerNum, userNum, gameStart);
        }
    }

    //  컴퓨터 숫자와 유저숫자를 비교하는 메서드
    private static boolean comNumEqualsUserNum(int[] computerNum, int[] userNum, boolean gameStart) {
        int strike = 0;
        int ball = 0;
//        strike = checkStrikeAndBall(computerNum, userNum, strike, ball);
        if (checkStrikeAndBall(computerNum, userNum, strike, ball) == 3) {
            System.out.println("세자리 숫자를 모두 맞췄습니다.");
            gameStart = false;
        }
        return gameStart;
    }

    private static int checkStrikeAndBall(int[] computerNum, int[] userNum, int strike, int ball) {
        for (int i = 0; i < computerNum.length; i++) {
            if (computerNum[i] == userNum[i]) {
                strike++;
            } else {
                for (int j = 0; j < userNum.length; j++) {
                    if (computerNum[i] == userNum[j]) {
                        ball++;
                    }
                }
            }
        }
        System.out.println(strike + "스트라이크  " + ball + "볼");
        return strike;
    }


    private static boolean chekRandomNum(int[] computerNum, boolean randomNum) {
        if (computerNum[0] != computerNum[1] && computerNum[0] != computerNum[2] && computerNum[1] != computerNum[2]) {
            System.out.println("컴퓨터값  " + computerNum[0] + " " + computerNum[1] + " " + computerNum[2]);
            randomNum = false;
        }
        return randomNum;
    }
}
