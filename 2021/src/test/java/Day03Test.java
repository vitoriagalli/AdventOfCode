import days.Day03;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day03Test {

    Day03 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day03();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"}));
        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(198, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        Assert.assertEquals(230, dayObj.solvePart2());
    }

}
