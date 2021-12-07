package days;


import java.util.ArrayList;

public class Day03 extends AbstractDay {

    public Day03() {
        super("03");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        System.out.println(solvePart1());
    }

    public int solvePart1() {

        String  binary = "";
        int nBits = argList.get(0).length();
        for (int i = 0; i < nBits; i++) {
            int finalI = i;
            int ones = argList.stream().mapToInt(line -> Integer.parseInt(String.valueOf(line.charAt(finalI)))).sum();
            if (ones > argList.size()/2) {
                binary += "1";
            } else {
                binary += "0";
            }
        }
        int value = Integer.parseInt(binary, 2);
        return value * flipBits(value, nBits);
    }

    static private int flipBits(int value, int bits) {
        int mask = (1 << bits) - 1;
        return value ^ mask;
    }


    @Override
    public void part2() {
        System.out.println("Part2:");
        System.out.println(solvePart2());
    }

    public int solvePart2() {
        int o2Generator = getRating((ArrayList<String>)argList.clone(), "oxigen");
        int c02Scrubber = getRating((ArrayList<String>)argList.clone(), "carbonDioxide");
        return o2Generator * c02Scrubber;
    }

    private int getRating(ArrayList<String> list, String element) {

        int nBits = list.get(0).length();
        for (int i = 0; i < nBits; i++) {

            int finalI = i;
            int ones = list.stream().mapToInt(line -> Integer.parseInt(String.valueOf(line.charAt(finalI)))).sum();

            int halfList = (int) (Math.ceil((double)(list.size())/(double)(2)));
            if ((element.equals("oxigen") && ones >= halfList)
                || (element.equals("carbonDioxide") && ones < halfList)) {
                list.removeIf(x -> x.charAt(finalI) == '0');
            } else {
                list.removeIf(x -> x.charAt(finalI) == '1');
            }

            if (list.size() == 1)
                break;
        }
        return Integer.parseInt(list.get(0), 2);
    }

}
