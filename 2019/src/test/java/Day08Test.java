import days.Day07;
import days.Day08;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Day08Test {


    @Test
    public void part01_part02_test_00() {

        // given
        Day08 dayObj = new Day08();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"0222112222120000"}));
        dayObj.setArgList(inputArrList);
        dayObj.setHeight(2);
        dayObj.setWidth(2);

        // then
        Assert.assertEquals(4, dayObj.solvePart1());
        Assert.assertEquals("0110", dayObj.solvePart2());
    }

}
