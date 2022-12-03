import days.Day06;
import days.Day07;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Day07Test {


    @Test
    public void part01Test_00() {

        // given
        Day07 dayObj = new Day07();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0"}));
        dayObj.setArgList(inputArrList);

        // then
        Assert.assertEquals(43210, dayObj.solvePart1());
    }

}
