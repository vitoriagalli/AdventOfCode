import days.Day03;
import days.Day04;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Day04Test {


    @Test
    public void part01Test_00() {

        // given
        Day04 dayObj = new Day04();

        // when
        int min = 165432;
        int max = 707912;

        // then
        Assert.assertEquals(1716, dayObj.solvePart1(min, max));
        Assert.assertEquals(1163, dayObj.solvePart2(min, max));
    }

}
