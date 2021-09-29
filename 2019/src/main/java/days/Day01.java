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
//            resultList.forEach(System.out::println);
            System.out.println("sum of the fuel requirements = " + resultList.stream().collect(Collectors.summingInt(Integer::intValue)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void part2() {
        System.out.println("Part2:");
        try {
            ArrayList<Integer> resultList = new ArrayList<>();
            argList.forEach(argStr -> resultList.add(calculateRecursiveFuel(Integer.parseInt(argStr))));
//            resultList.forEach(System.out::println);
            System.out.println("sum of the fuel requirements = " + resultList.stream().collect(Collectors.summingInt(Integer::intValue)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    int calculateFuel(int mass) {
        return Math.floorDiv(mass, 3) - 2;
    }

    int calculateRecursiveFuel(int mass) {
        int fuel = calculateFuel(mass);
        if (fuel <= 0)
            return 0;
        return (fuel + calculateRecursiveFuel(fuel));
    }
}
