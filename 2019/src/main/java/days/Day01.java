package days;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class Day01 extends AbstractDay {

    public Day01() {
        super("01");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        try {
            ArrayList<Integer> resultList = new ArrayList<>();
            argList.forEach(argStr -> resultList.add(calculateFuel(Integer.parseInt(argStr))));
            resultList.forEach(System.out::println);
            System.out.println("SUM = " + resultList.stream().collect(Collectors.summingInt(Integer::intValue)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    int calculateFuel(int mass) {
        return Math.floorDiv(mass, 3) - 2;
    }

}
