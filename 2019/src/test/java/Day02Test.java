import days.Day02;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Day02Test {

    public void programAlarm_test(Integer[] inputArr, Integer[] expectArr) throws Day02.Day02Exception {

        // given
        Day02 dayObj = new Day02();
        ArrayList<Integer> inputArrList = new ArrayList<>();
        ArrayList<Integer> expectArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(inputArr));
        expectArrList.addAll(Arrays.asList(expectArr));

        // then
        Assert.assertEquals(expectArrList, dayObj.calculateMachine(inputArrList));
    }

    @Test
    public void part01Test_00() throws Day02.Day02Exception {
        programAlarm_test(new Integer[]{1,0,0,0,99}, new Integer[]{2,0,0,0,99});
    }

    @Test
    public void part01Test_01() throws Day02.Day02Exception {
        programAlarm_test(new Integer[]{2,3,0,3,99}, new Integer[]{2,3,0,6,99});
    }

    @Test
    public void part01Test_02() throws Day02.Day02Exception {
        programAlarm_test(new Integer[]{2,4,4,5,99,0}, new Integer[]{2,4,4,5,99,9801});
    }

    @Test
    public void part01Test_03() throws Day02.Day02Exception {
        programAlarm_test(new Integer[]{1,1,1,4,99,5,6,0,99}, new Integer[]{30,1,1,4,2,5,6,0,99});
    }

    @Test
    public void part01Test_04() throws Day02.Day02Exception {
        programAlarm_test(new Integer[]{1,9,10,3,2,3,11,0,99,30,40,50}, new Integer[]{3500,9,10,70, 2,3,11,0,99,30,40,50});
    }

}
