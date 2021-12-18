
import days.Day09;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day09Test {

    Day09 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day09();

        // when
        ArrayList<String> inputArrList = new ArrayList<>(Arrays.asList(
                new String[]{"2199943210",
                        "3987894921",
                        "9856789892",
                        "8767896789",
                        "9899965678"}));

        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(15, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        dayObj.part1();
        Assert.assertEquals(1134, dayObj.solvePart2());
    }

}
