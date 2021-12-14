package days;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Day06 extends AbstractDay {

    private long[] lanternFishAtDay = new long[10];

    public Day06() {
        super("06");
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
        Arrays.fill(lanternFishAtDay, 0);
        Arrays.asList(argList.get(0).split(",")).forEach(x -> lanternFishAtDay[Integer.parseInt(x)]++);
        return countLanternFish(80);
    }

    public long solvePart2() {
        Arrays.fill(lanternFishAtDay, 0);
        Arrays.asList(argList.get(0).split(",")).forEach(x -> lanternFishAtDay[Integer.parseInt(x)]++);
        return countLanternFish(256);
    }

    private long countLanternFish(int day) {

        long tmp;
        for (int i = 0; i < day; i++) {

            tmp = lanternFishAtDay[0];
            lanternFishAtDay[0] = lanternFishAtDay[1];
            lanternFishAtDay[1] = lanternFishAtDay[2];
            lanternFishAtDay[2] = lanternFishAtDay[3];
            lanternFishAtDay[3] = lanternFishAtDay[4];
            lanternFishAtDay[4] = lanternFishAtDay[5];
            lanternFishAtDay[5] = lanternFishAtDay[6];
            lanternFishAtDay[6] = lanternFishAtDay[7];
            lanternFishAtDay[7] = lanternFishAtDay[8];
            lanternFishAtDay[8] = lanternFishAtDay[9];
            lanternFishAtDay[6] += tmp;
            lanternFishAtDay[8] += tmp;
        }
        return LongStream.of(lanternFishAtDay).sum();
    }

}
