package days;


public class Day01 extends AbstractDay {

    public Day01() {
        super("01");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        System.out.println(solvePart1());
    }

    public int solvePart1() {
        return compareWith(1);
    }

    @Override
    public void part2() {
        System.out.println("Part2:");
        System.out.println(solvePart2());
    }

    public int solvePart2() {
        return compareWith(3);
    }

    public int compareWith(int indexIncr) {

        int count = 0;
        for (int i = 0; i < argList.size(); i++) {
            try {
                if (Integer.parseInt(argList.get(i))
                        < Integer.parseInt(argList.get(i + indexIncr))) {
                    count++;
                }
            } catch (Exception e) {}
        }
        return count;
    }

}
