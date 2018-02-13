package newbaseball;

import java.util.Scanner;

public class baseball_0213 {

    public static void main(String[] args) {

inputUserNum();
    }

    static int[] creatUserNum() {
        return inputUserNum();
    }

    private static int[] inputUserNum() {
        Scanner scanner = new Scanner(System.in);
        String input = String.valueOf(Integer.parseInt(scanner.nextLine()));
        int[] userNum = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            userNum[i] = input.charAt(i) - '0';
            System.out.print(userNum[i]);
        }
        return userNum;
    }

}
