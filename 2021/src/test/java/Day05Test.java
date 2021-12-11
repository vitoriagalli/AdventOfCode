
import days.Day05;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day05Test {

    Day05 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day05();

        // when
        ArrayList<String> inputArrList = new ArrayList<>(Arrays.asList(new String[]{"0,9 -> 5,9","8,0 -> 0,8","9,4 -> 3,4","2,2 -> 2,1","7,0 -> 7,4","6,4 -> 2,0","0,9 -> 2,9","3,4 -> 1,4","0,0 -> 8,8","5,5 -> 8,2"}));
        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(5, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        Assert.assertEquals(-1, dayObj.solvePart2());
    }

}
