package days;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class Day07 extends AbstractDay {

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
    }

    public int solvePart1() {

        List<Integer[]> generatedList = new ArrayList<>();
        permute(generatedList, new Integer[]{0,1,2,3,4}, 0, 5);

        System.out.println(generatedList.size());

//        generatedList.forEach(list -> {
//            for (Object item : list) {
//                System.out.print(item);
//            }
//            System.out.println();
//        });

        return -1;
    }

    private void permute(List<Integer[]> generatedList, Integer ints[], int i, int n) {
        if (i == n) {
//            System.out.println(Arrays.asList(ints));
            generatedList.add(ints.clone());
        }
        else {
            for (int j = i; j < n; j++) {
                Integer tmp = ints[i];
                ints[i] = ints[j];
                ints[j] = tmp;
                permute(generatedList, ints, i+1, n);
                tmp = ints[i];
                ints[i] = ints[j];
                ints[j] = tmp;
            }
        }
    }

//    public int solvePart2() {
//
//    }

}
