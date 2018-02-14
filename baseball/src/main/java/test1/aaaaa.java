package test1;

import java.util.Scanner;

public class aaaaa {
    public static void main(String[] args) {


        gameStart();

    }


    // 게임 시작 메서드
    private static void gameStart() {
        boolean start = true;
        int[] comNum =createComNum();
        while (start) {
            int[] userNum = createUserInputNum();
            start = countStrikeAndBall(comNum, userNum);

        }
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


    //유저 숫자를 입력받는 메서드
    private static int[] createUserInputNum() {
        int[] userNum = new int[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < userNum.length; i++) {
            System.out.println((i + 1) + "번째 숫자를 입력해 주세요");
            userNum[i] = scanner.nextInt();
        }
        System.out.println("유저값   " + userNum[0] + " " + userNum[1] + " " + userNum[2]);
        return userNum;
    }

    //컴퓨터숫자와 유저숫자를 비교해 볼과 카운트를 구한다
    private static boolean countStrikeAndBall(int[] computerNum, int[] userNum) {
        int strike = countStrike(computerNum,userNum);
        int ball = countBall(computerNum,userNum);
        System.out.println(strike + "스트라이크  " + ball + "볼");
        if (strike == 3) {
            System.out.println("세자리 숫자를 모두 맞췄습니다.");
            return false;
        }
        return true;
    }


    //볼 카운트
    private static int countBall(int[] computerNum, int[] userNum) {
        int ball = 0;
        for (int i = 0; i < computerNum.length; i++) {
            for (int j = 0; j <userNum.length;j++)
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