package ttdcalculator;

import junit.framework.TestCase;
import org.junit.Assert;

public class StringCalculatorTest extends TestCase {

    public void testSplitWhenComma() throws Exception {
        StringCalculator cal = new StringCalculator();
        String [] result = cal.split("1,2,3");
        Assert.assertArrayEquals(new String[]{"1","2","3"}, result);
    }


    public void testSplitWhenNewLine() throws Exception {
        StringCalculator cal = new StringCalculator();
        String [] result = cal.split("1\n2\n3");
        Assert.assertArrayEquals(new String[]{"1","2","3"}, result);
    }


}
