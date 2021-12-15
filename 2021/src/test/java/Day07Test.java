
import days.Day07;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day07Test {

    Day07 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day07();

        // when
        ArrayList<String> inputArrList = new ArrayList<>(Arrays.asList(new String[]{"16,1,2,0,4,2,7,1,2,14"}));
        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(37, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        dayObj.part1();
        Assert.assertEquals(168, dayObj.solvePart2());
    }

}
