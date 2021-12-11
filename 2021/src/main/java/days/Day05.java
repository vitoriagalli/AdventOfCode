package days;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day05 extends AbstractDay {

    private int[][] diagram;
    private ArrayList<Line> lineOfVents = new ArrayList<>();
    private int grid = 0;

    private class Line {
        int x0;
        int x;
        int y0;
        int y;

        public Line(int x0, int y0, int x, int y) {
            this.x0 = x0;
            this.y0 = y0;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "x0=" + x0 +
                    ", x=" + x +
                    ", y0=" + y0 +
                    ", y=" + y +
                    '}';
        }
    }

    public Day05() {
        super("05");
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

        parseArgs();

        diagram = new int[grid + 1][grid + 1];

        lineOfVents.stream()
                .filter(Day05::isHorizontalOrVerticalLine)
                .forEach(this::populateDiagram);

        return countMoreThanOneOverlap();
    }

    public int solvePart2() {

        lineOfVents.stream()
                .filter(Predicate.not(Day05::isHorizontalOrVerticalLine))
                .forEach(this::populateDiagram);

//        plotDiagram();

        return countMoreThanOneOverlap();
    }

    private int countMoreThanOneOverlap() {
        AtomicInteger sum = new AtomicInteger();

        Arrays.stream(diagram).sequential()
                .forEach(line -> sum.addAndGet((int) IntStream.of(line).filter(p -> p > 1).count()));

        return sum.get();
    }

    static private boolean isHorizontalOrVerticalLine(Line line) {
        return (line.x0 == line.x || line.y0 == line.y);
    }

    private void populateDiagram(Line line) {

        int incX = 0;
        int incY = 0;
        int diffX = line.x - line.x0;
        int diffY = line.y - line.y0;

        if (line.x0 != line.x) {
            incX = diffX/Math.abs(diffX);
        }
        if (line.y0 != line.y) {
            incY = diffY/Math.abs(diffY);
        }

        int maxDiff = Math.max(Math.abs(diffX), Math.abs(diffY));

        for (int i = 0; i <= maxDiff; i++) {
            diagram[line.y0 + i * incY][line.x0 + i * incX] += 1;
        }
    }


    private void plotDiagram() {

        System.out.println("\n*-* DIAGRAM *-*\n");

        Arrays.stream(diagram).sequential()
                .forEach(line -> {
                    IntStream.of(line).forEach(System.out::print);
                    System.out.println();
                });

        System.out.println();
    }

    private void parseArgs() {

        for (String line: argList) {

            List<Integer> coord = Arrays.stream(line.replace(" -> ", ",")
                    .split(",")).map(Integer::parseInt).collect(Collectors.toList());

            if (Collections.max(coord) > grid)
                grid = Collections.max(coord);

            lineOfVents.add(new Line(coord.get(0), coord.get(1), coord.get(2),coord.get(3)));
        }
    }



}
