
import days.Day06;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day06Test {

    Day06 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day06();

        // when
        ArrayList<String> inputArrList = new ArrayList<>(Arrays.asList(new String[]{"3,4,3,1,2"}));
        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(5934, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        Assert.assertEquals(26984457539L, dayObj.solvePart2());
    }

}
