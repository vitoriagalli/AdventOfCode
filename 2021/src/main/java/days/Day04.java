package days;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day04 extends AbstractDay {

    private ArrayList<Integer> calledNumbers = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> boards = new ArrayList<>();
    private ArrayList<Integer> ranking = new ArrayList<>();

    private static final int grid = 5;
    private static final int calledNumbNewValue = -1;

    public Day04() {
        super("04");
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
        callingTheNumbers();
        return ranking.get(0);
    }

    public int solvePart2() {
        return ranking.get(ranking.size() - 1);
    }

    public void callingTheNumbers() {

        int indexCalledNumber, winner;
        for (int number : calledNumbers) {
            for (int j = 0; j < boards.size(); j++) {
                if (boards.get(j) != null) {
                    indexCalledNumber = boards.get(j).indexOf(number);
                    if (indexCalledNumber >= 0) {
                        boards.get(j).set(indexCalledNumber, calledNumbNewValue);
                        winner = completeRowOrColumn(boards.get(j));
                        if (winner > 0) {
                            ranking.add(winner * number);
                            boards.set(j, null);
                        }
                    }

                }
            }
        }
    }

    private static int completeRowOrColumn(ArrayList<Integer> board) {

        int fullRow, fullColumn;
        for (int i = 0; i < grid; i++) {
            fullRow = sublistRow(board, i).stream().mapToInt(Integer::intValue).sum();
            fullColumn = sublistColumn(board, i).stream().mapToInt(Integer::intValue).sum();
            if (fullRow == calledNumbNewValue * grid || fullColumn == calledNumbNewValue * grid) {
                return board.stream().filter(x -> x > 0).mapToInt(Integer::intValue).sum();
            }
        }
        return 0;
    }

    private static ArrayList<Integer> sublistRow(ArrayList<Integer> board, int row) {
        return new ArrayList<>(board.subList(row * grid, (row + 1) * grid));
    }

    private static ArrayList<Integer> sublistColumn(ArrayList<Integer> board, int column) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 0; i < grid * grid; i++) {
            if (i % 5 == column) {
                lst.add(board.get(i));
            }
        }
        return lst;
    }

    private void parseArgs() {

        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(argList.get(0).split(",")));
        calledNumbers = (ArrayList<Integer>) stringList.stream().map(Integer::parseInt).collect(Collectors.toList());

        int nBoard = -1;
        for (int i = 1; i < argList.size(); i++) {

            ArrayList<Integer> tmp = new ArrayList<>(
                            Arrays.asList(argList.get(i).split("\\s+"))
                            .stream()
                            .filter(x -> x.length() > 0)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));

            if (tmp.size() == 0) {
                nBoard++;
            } else if (boards.size() == nBoard) {
                boards.add(tmp);
            } else {
                boards.get(nBoard).addAll(tmp);
            }
        }
    }



}
