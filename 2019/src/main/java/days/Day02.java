package days;


import java.util.*;
import java.util.stream.Collectors;
import java.util.Iterator;

public class Day02 extends AbstractDay {

    private ArrayList<Integer> intcodeList;

    public Day02() {
        super("02");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        try {

            intcodeList = parseInput();
            programAlarm();
            intcodeList.forEach(i -> System.out.print(i + ","));
//            System.out.println("sum of elements = " + intcodeList.stream().collect(Collectors.summingInt(Integer::intValue)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<Integer> parseInput() {

        ArrayList<String> strList = new ArrayList();
        Collections.addAll(strList, argList.get(0).split(","));

        return strList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toCollection(ArrayList::new));

    }


    @Override
    public void part2() {
    }


    void programAlarm() {

        for (int i = 0; i < intcodeList.size(); i++) {
            if ( intcodeList.get(i) == 99 )
                return;
            else if ( intcodeList.get(i) == 1 ) {
                intcodeList.set(intcodeList.get(i+3), intcodeList.get(intcodeList.get(i+1)) + intcodeList.get(intcodeList.get(i+2)));
            } else if ( intcodeList.get(i) == 2 ) {
                intcodeList.set(intcodeList.get(i+3), intcodeList.get(intcodeList.get(i+1)) * intcodeList.get(intcodeList.get(i+2)));
            }
        }

    }

}
