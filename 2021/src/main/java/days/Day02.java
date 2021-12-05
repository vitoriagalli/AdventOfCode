package days;


public class Day02 extends AbstractDay {

    public Day02() {
        super("02");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        System.out.println(solvePart1());
    }

    public int solvePart1() {
        int xAxis = 0, yAxis = 0;
        int value = 0;

        for (String line: argList) {
            value = Integer.parseInt(line.split(" ")[1]);
            if (line.contains("down")) {
                yAxis += value;
            } else if (line.contains("up")) {
                yAxis -= value;
            } else if (line.contains("forward")) {
                xAxis += value;
            }
        }
        return xAxis * yAxis;
    }

    @Override
    public void part2() {
        System.out.println("Part2:");
        System.out.println(solvePart2());
    }

    public int solvePart2() {
        int xAxis = 0, yAxis = 0;
        int value = 0;
        int aim = 0;

        for (String line: argList) {
            value = Integer.parseInt(line.split(" ")[1]);
            if (line.contains("down")) {
                aim += value;
            } else if (line.contains("up")) {
                aim -= value;
            } else if (line.contains("forward")) {
                xAxis += value;
                yAxis += value * aim;
            }
        }
        return xAxis * yAxis;
    }

}
