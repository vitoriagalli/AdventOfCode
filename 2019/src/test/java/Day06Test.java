import days.Day06;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Day06Test {


    @Test
    public void part01Test_00() {

        // given
        Day06 dayObj = new Day06();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"COM)B", "B)C", "C)D", "D)E", "E)F", "B)G","G)H", "D)I", "E)J", "J)K", "K)L"}));

        // then
        Assert.assertEquals(42, dayObj.solvePart1());
    }

}
