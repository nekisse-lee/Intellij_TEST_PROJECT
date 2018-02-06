import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {
    @Test
    public int[] comRandomNum() throws Exception {
        int[] comNum = new int[3];
        boolean cm = true;
        while (cm) {
            isCm(comNum, cm);
            for (int i = 0; i < comNum.length; i++) {
                comNum[i] = (int) (Math.random() * 9) + 1;
            }
        }

        System.out.println(comNum[0]+ " " +comNum[1] + " " + comNum[2]);
        return comNum;

    }

    private boolean isCm(int[] comNum, boolean cm) {
        cm = true;
        while (cm) {
            if (comNum[0] != comNum[1] && comNum[0] != comNum[2] && comNum[1] != comNum[2]) {
                cm = false;
            }
            return cm;
        }
        return cm;
    }



}