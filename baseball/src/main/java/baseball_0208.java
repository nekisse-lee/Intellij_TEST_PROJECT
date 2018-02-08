import java.util.Scanner;

public class baseball_0208 {
    public static void main(String[] args) {
        gamestart();



    }

    private static void gamestart() {
        boolean isRun = true;
        int[] conNum = createComNum();
        int[] userNum = createInputUserNum();
        while (isRun) {

            compareComNumAndUserNum(conNum, userNum);

        }

    }

    //컴퓨터의 랜덤 숫자를 만든다 int[]
    private static int[] createComNum() {
        int[] comNum = new int[3];
        boolean random = true;
        while (random) {
            for (int i = 0; i < comNum.length; i++) {
                comNum[i] = (int) (Math.random() * 9) + 1;
            }
            random = checkRandomNum(comNum);
        }
        return comNum;
    }

   //유저숫자를 만든다 int[]
    private static int[] createInputUserNum() {
        int[] userNum = new int[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <userNum.length; i++) {
            System.out.println((i + 1) + "번째 숫자를 입력해 주세요");
            userNum[i] = scanner.nextInt();
        }
        System.out.println("유저값   " + userNum[0] + " " + userNum[1] + "  " + userNum[2]);
        return userNum;
    }


    private static boolean compareComNumAndUserNum(int[] comNum, int[] userNum) {
        int strike = countStrike(comNum,userNum);
        int ball = countBall(comNum, userNum);
        if (countStrike(comNum, userNum) == 3) {
            System.out.println(strike+ "스트라이크");
            System.out.println(ball + " 볼");
            return false;
        }
        return true;
//        while (countStrike(comNum, userNum) == 3? false:true) {
//            countBall(comNum, userNum);
//                System.out.println("3스트라이크 게임끝");
//        }
//        return true;
    }

    private static int countStrike(int[] comNum, int[] userNum) {
        int strike = 0;
        for (int i = 0; i < comNum.length; i++) {
            if (comNum[i] == userNum[i]) {
                strike++;
            }
        }
        return strike;
    }


    private static int countBall(int[] comNum, int[] userNum) {
        int ball = 0;
        for (int i = 0; i <comNum.length; i++) {
            for (int j = 0; j < userNum.length; j++) {
                if (i == userNum[j] && i != j) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private static boolean checkRandomNum(int[] comNum) {
        if (comNum[0] != comNum[1] && comNum[0] != comNum[2] && comNum[1] != comNum[2]) {
            System.out.println("컴퓨터값  " + comNum[0] + " " + comNum[1] + " " + comNum[2]);
            System.out.println("자릿수 중복 없는 컴퓨터 값 생성");
            return false;
        }
        return true;
    }



}
