import days.Day01;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day01Test {

    Day01 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day01();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"}));
        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(7, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        Assert.assertEquals(5, dayObj.solvePart2());
    }

}
