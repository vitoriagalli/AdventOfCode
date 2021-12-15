package days;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Day07 extends AbstractDay {

    private ArrayList<Integer> crabsPosition;
    private int median;

    public Day07() {
        super("07");
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

    public long solvePart1() {

        crabsPosition = (ArrayList<Integer>) Arrays.stream(argList.get(0).split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
        median = (int)(median(crabsPosition));

        return findLeastFuelAmount(false);
    }

    public long solvePart2() {

        return findLeastFuelAmount(true);
    }

    private long findLeastFuelAmount(boolean apIncrease) {

        long sumFuel = Integer.MAX_VALUE;
        int maxDif = (Collections.max(crabsPosition) - Collections.min(crabsPosition))/2;

        for (int i = 0; i < maxDif; i++) {
            sumFuel = min(sumFuel,
                        calculateTotalFuel(crabsPosition, median + i, apIncrease),
                        calculateTotalFuel(crabsPosition, median - i, apIncrease));
        }
        return sumFuel;
    }


    private static long calculateTotalFuel(ArrayList<Integer> crabsPosition, int commonPosit, boolean apIncrease) {

        long sumFuel = 0;
        int gap;

        for (Integer posit: crabsPosition) {
            gap = Math.abs(posit - commonPosit);

            if (apIncrease) {
                sumFuel += sumOfAP(1, gap, gap);
            } else {
                sumFuel += sumOfAP(gap, gap, 1);
            }
        }
        return sumFuel;
    }

    public static long min(long a, long b, long c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int sumOfAP(int a1, int an, int n)
    {
        return n * (a1 + an) / 2;
    }

    public static double median(ArrayList<Integer> m) {
        int middle = m.size()/2;
        if (m.size() % 2 == 1) {
            return m.get(middle);
        } else {
            return (m.get(middle-1) + m.get(middle)) / 2.0;
        }
    }


}
