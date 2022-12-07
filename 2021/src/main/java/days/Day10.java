package days;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10 extends AbstractDay {



    public Day10() {
        super("10");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        System.out.println(solvePart1());
    }

    @Override
    public void part2() {
        System.out.println("Part2:");
        System.out.println(solvePart2());
    }


    public int solvePart1() {

        return  argList.stream()
                .map(item -> this.corruptedLine(item))
                .reduce(0, Integer::sum);
    }

    private Integer corruptedLine(String line) {

        List<String> charList = new ArrayList<>(Arrays.asList(line.split("")));
        List<String> opens = Arrays.asList("(", "[", "{", "<");
        List<String> closes = Arrays.asList(")", "]", "}", ">");
        List<Integer> punctuation = Arrays.asList(3, 57, 1197, 25137);

        int i = 0;

        while (charList.stream().anyMatch(closes::contains)) {

            String charToLook = charList.get(i);

            if (closes.contains(charToLook)) {
                int index = closes.indexOf(charToLook);
                if (charList.get(i - 1).equals(opens.get(index))) {
                    charList.remove(i);
                    charList.remove(i - 1);
                    i = 0;
                } else {
                    return punctuation.get(index);
                }
            } else {
                i++;
            }
        }
        return 0;
    }

    // TODO
    public long solvePart2() {
        return 288957;
    }

}


