
import days.Day10;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day10Test {

    Day10 dayObj;

    @Before
    public void beforeTest() {
        // given
        dayObj = new Day10();

        // when
        ArrayList<String> inputArrList = new ArrayList<>(Arrays.asList(
                "[({(<(())[]>[[{[]{<()<>>",
                "[(()[<>])]({[<{<<[]>>(",
                "{([(<{}[<>[]}>{[]{[(<()>",
                "(((({<>}<{<{<>}{[]{[]{}",
                "[[<[([]))<([[{}[[()]]]",
                "[{[{({}]{}}([{[{{{}}([]",
                "{<[[]]>}<{[{[{[]{()[[[]",
                "[<(<(<(<{}))><([]([]()",
                "<{([([[(<>()){}]>(<<{{",
                "<{([{{}}[<[[[<>{}]]]>[]]"
        ));

        dayObj.setArgList(inputArrList);
    }

    @Test
    public void part01_Test() {
        // then
        Assert.assertEquals(26397, dayObj.solvePart1());
    }

    @Test
    public void part02_Test() {
        // then
        dayObj.part1();
        Assert.assertEquals(288957, dayObj.solvePart2());
    }

}
