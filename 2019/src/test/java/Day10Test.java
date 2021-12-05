
import days.Day10;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Day10Test {


    @Test
    public void part01_test_00() {

        // given
        Day10 dayObj = new Day10();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{".#..#", ".....", "#####", "....#", "...##"}));
        dayObj.setArgList(inputArrList);

        // then
        Assert.assertEquals(8, dayObj.solvePart1());
    }

    @Test
    public void part01_test_01() {

        // given
        Day10 dayObj = new Day10();
        ArrayList<String> inputArrList = new ArrayList<>();

        // when
        inputArrList.addAll(Arrays.asList(new String[]{"......#.#.","#..#.#....","..#######.",".#.#.###..",".#..#.....","..#....#.#","#..#....#.",".##.#..###","##...#..#.",".#....####"}));
        dayObj.setArgList(inputArrList);

        // then
        Assert.assertEquals(33, dayObj.solvePart1());
    }


}
