package days;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day04 extends AbstractDay {

    public ArrayList<Integer> calledNumbers = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> boards = new ArrayList<>();

    private static final int grid = 5;
    private static final int calledNumb = -1;

    public Day04() {
        super("04");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        System.out.println(solvePart1());
    }

    public int solvePart1() {

        parseArgs();
//        System.out.println(calledNumbers + "\n" + boards);

        for (int number : calledNumbers) {

            for (int j = 0; j < boards.size(); j++) {

                int index = boards.get(j).indexOf(number);

                if (index >= 0) {

                    boards.get(j).set(index, calledNumb);

                    int winner = completeRowOrColumn(boards.get(j));
                    if (winner > 0)
                        return winner * number;
                }

            }

//            System.out.println(boards);
        }


        return 0;
    }

    private int completeRowOrColumn(ArrayList<Integer> board) {

        int ret;
        ret = checkRow(board);
        if (ret > 0)
            return ret;
        return checkColumn(board);
    }

    private static int checkRow(ArrayList<Integer> board) {

        int row = 0;

        while (row < grid) {

            if (board.subList(row * grid, (row + 1) * grid).stream().collect(Collectors.summingInt(Integer::intValue)) == calledNumb * grid)
                return board.stream().filter(x -> x > 0).collect(Collectors.summingInt(Integer::intValue));
            row++;
        }

        return 0;
    }

    private static int checkColumn(ArrayList<Integer> board) {

        int column = 0;
        while (column < grid) {

            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < grid * grid; i++) {
                if (i % 5 == column) {
                    tmp.add(board.get(i));
                }
            }

            if (tmp.stream().collect(Collectors.summingInt(Integer::intValue)) == calledNumb * grid)
                return board.stream().filter(x -> x > 0).collect(Collectors.summingInt(Integer::intValue));

            column++;
        }

        return 0;
    }

    private void parseArgs() {

        ArrayList<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList(argList.get(0).split(",")));
        calledNumbers = (ArrayList<Integer>) stringList.stream().map(Integer::parseInt).collect(Collectors.toList());

        int nBoard = -1;
        for (int i = 1; i < argList.size(); i++) {

            List<String> arg = Arrays.asList(argList.get(i).split("\\s+"));
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(arg.stream().filter(x -> x.length() > 0).map(Integer::parseInt).collect(Collectors.toList()));

            if (tmp.size() == 0) {
                nBoard++;
            } else if (boards.size() == nBoard) {
                boards.add(tmp);
            } else {
                boards.get(nBoard).addAll(tmp);
            }
        }
    }

    @Override
    public void part2() {
        System.out.println("Part2:");
        System.out.println(solvePart2());
    }

    public int solvePart2() {
        return 0;
    }


}
