import days.Day04;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day04Test {

    Day04 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day04();

        // when
        ArrayList<String> inputArrList = new ArrayList<>(Arrays.asList(new String[]{"7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1", "", "22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19", "", " 3 15  0  2 22", " 9 18 13 17  5", "19  8  7 25 23", "20 11 10 24  4", "14 21 16 12  6", "", "14 21 17 24  4", "10 16 15  9 19", "18  8 23 26 20", "22 11 13  6  5", " 2  0 12  3  7"}));
        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(4512, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        dayObj.solvePart1();
        Assert.assertEquals(1924, dayObj.solvePart2());
    }

}
