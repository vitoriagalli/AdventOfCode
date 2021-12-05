import days.Day02;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day02Test {

    Day02 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day02();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"forward 5 ", "down 5 ", "forward 8 ", "up 3 ", "down 8 ", "forward 2"}));
        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(150, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        Assert.assertEquals(900, dayObj.solvePart2());
    }

}
