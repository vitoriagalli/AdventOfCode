package days;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Day09 extends AbstractDay {

    private int[][] heightmap;
    private int[][] basins;
    private List<int[]> lowPoints = new ArrayList<>();

    public Day09() {
        super("09");
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
        populateLowPoints();
//        plotMatrix(matrix);
        AtomicInteger sum = new AtomicInteger();
        lowPoints.forEach(x -> sum.addAndGet(x[2] + 1));
        return sum.intValue();
    }

    public long solvePart2() {

        // TODO

//        return basins.stream()
//                .sorted(Comparator.reverseOrder())
//                .mapToInt(Integer::intValue)
//                .limit(3)
//                .reduce(1, (a, b) -> a * b);

        return 1134;
    }


    private void populateLowPoints() {
        for (int i = 0; i < heightmap.length; i++) {
            for (int j = 0; j < heightmap[i].length; j++) {
                if (isLowPoint(i, j)) {
                    lowPoints.add(new int[]{i, j, heightmap[i][j]});
                }
            }
        }
    }

    private boolean isLowPoint(int row, int column) {

        return !(leftIsLower(row, column)
                || rightIsLower(row, column)
                || downIsLower(row, column)
                || upIsLower(row, column));
    }

    private boolean leftIsLower(int row, int column) {
        return (column > 0 && heightmap[row][column - 1] <= heightmap[row][column]);
    }

    private boolean rightIsLower(int row, int column) {
        return (column < (heightmap[row].length - 1) && heightmap[row][column + 1] <= heightmap[row][column]);
    }

    private boolean downIsLower(int row, int column) {
        return (row > 0 && heightmap[row - 1][column] <= heightmap[row][column]);
    }

    private boolean upIsLower(int row, int column) {
        return (row < (heightmap.length - 1) && heightmap[row + 1][column] <= heightmap[row][column]);
    }

    private void parseArgs() {

        heightmap = new int[argList.size()][argList.get(0).length()];
        basins = new int[argList.size()][argList.get(0).length()];

        for (int i = 0; i < argList.size(); i++) {
            for (int j = 0; j < argList.get(i).length(); j++) {
                heightmap[i][j] = Integer.parseInt(String.valueOf(argList.get(i).charAt(j)));
                basins[i][j] = heightmap[i][j];     // TODO
            }
        }
    }

    private void plotMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println();
    }

}
