import days.Day02;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Day02Test {

    public void programAlarm_test(Integer[] inputArr, Integer[] expectArr) {

        // given
        Day02 dayObj = new Day02();
        ArrayList<Integer> inputArrList = new ArrayList<>();
        ArrayList<Integer> expectArrList = new ArrayList<>();
        inputArrList.addAll(Arrays.asList(inputArr));
        expectArrList.addAll(Arrays.asList(expectArr));

        // when
        dayObj.setIntcodeList(inputArrList);
        dayObj.programAlarm();

        // then
        Assert.assertEquals(expectArrList, dayObj.getIntcodeList());
    }


    @Test
    public void part01Test_programAlarm() {

        programAlarm_test(new Integer[]{1,0,0,0,99}, new Integer[]{2,0,0,0,99});
        programAlarm_test(new Integer[]{2,3,0,3,99}, new Integer[]{2,3,0,6,99});
        programAlarm_test(new Integer[]{2,4,4,5,99,0}, new Integer[]{2,4,4,5,99,9801});
        programAlarm_test(new Integer[]{1,1,1,4,99,5,6,0,99}, new Integer[]{30,1,1,4,2,5,6,0,99});
        programAlarm_test(new Integer[]{1,9,10,3,2,3,11,0,99,30,40,50}, new Integer[]{3500,9,10,70, 2,3,11,0,99,30,40,50});

    }

}
