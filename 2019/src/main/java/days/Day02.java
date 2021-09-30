package days;


import java.util.*;
import java.util.stream.Collectors;

public class Day02 extends AbstractDay {


    public Day02() {
        super("02");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        try {
            ArrayList<Integer> inputList;
            inputList = parseInput();
            Integer valueZero = getPositZero(12,2, inputList);
            System.out.println(valueZero);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void part2() {
        System.out.println("Part2:");
        try {
            ArrayList<Integer> inputList;
            inputList = parseInput();
            Integer pair[] = getNounAndVerb(inputList);
            System.out.println(Arrays.toString(pair));

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

    public ArrayList<Integer> calculateMachine(ArrayList<Integer> inputList) throws Day02Exception
    {
        int i = 0;
        while (i < inputList.size() && inputList.get(i) != 99) {
            if ( inputList.get(i) == 1 ) {
                inputList.set(inputList.get(i+3), inputList.get( inputList.get(i+1) ) + inputList.get( inputList.get(i+2)) );
            } else if ( inputList.get(i) == 2 ) {
                inputList.set(inputList.get(i+3), inputList.get( inputList.get(i+1) ) * inputList.get( inputList.get(i+2)) );
            } else {
                throw new Day02Exception("Invalid Opcode");
            }
            i += 4;
        }
        return inputList;
    }


    public Integer getPositZero(int n1, int n2, ArrayList<Integer> inputList) throws Day02Exception {

        inputList.set(1, n1);
        inputList.set(2, n2);
        return calculateMachine(inputList).get(0);
    }

    public Integer[] getNounAndVerb(ArrayList<Integer> inputList) throws Day02Exception {

        for (int noun = 0; noun < 100; noun++)
        {
            for (int verb = 0; verb < 100; verb++) {
                if (getPositZero(noun, verb, new ArrayList<>(inputList)) == 19690720)
                    return (new Integer[]{noun, verb});
            }
        }
        throw new Day02Exception("Noun and Verb not found");
    }

    public class Day02Exception extends Exception {
        public Day02Exception(String message) {
            super("Error:" + message);
        }
    }

}
