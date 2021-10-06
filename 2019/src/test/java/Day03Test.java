import days.Day03;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Day03Test {


    @Test
    public void part01Test_00() {

        // given
        Day03 dayObj = new Day03();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"R8,U5,L5,D3", "U7,R6,D4,L4"}));
        dayObj.setArgList(inputArrList);

        // then
        Assert.assertEquals(6, dayObj.distance(dayObj.getCloserLocation()));
    }

    @Test
    public void part01Test_01() {

        // given
        Day03 dayObj = new Day03();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"}));
        dayObj.setArgList(inputArrList);

        // then
        Assert.assertEquals(159, dayObj.distance(dayObj.getCloserLocation()));
    }

    @Test
    public void part01Test_02() {

        // given
        Day03 dayObj = new Day03();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"}));
        dayObj.setArgList(inputArrList);

        // then
        Assert.assertEquals(135, dayObj.distance(dayObj.getCloserLocation()));
    }


}
