package days;


import java.util.ArrayList;
import java.util.Arrays;

public class Day08 extends AbstractDay {

    private ArrayList<Integer> translatedNumbers = new ArrayList<>();

    public Day08() {
        super("08");
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

    public long solvePart1() {

        argList.forEach(line -> {
            if (!line.isEmpty()) {
                new LinePattern().solveLinePattern(line);
            }
        });
        return translatedNumbers.stream().filter(x -> (x == 1 || x == 4 || x == 7 || x == 8)).count();
    }


    public long solvePart2() {

        int sum;
        int counter = translatedNumbers.size()/4;
        long totalSum = 0;

        for (int i = 0; i < counter; i++) {

            sum = 0;
            for (int j = 0; j < 4; j++) {
                sum = sum * 10 + translatedNumbers.get(i * 4 + j);
            }
            totalSum += sum;
        }
        return totalSum;
    }


    class LinePattern {

        private ArrayList<String> uniqueSignalPatterns = new ArrayList<>();
        private ArrayList<String> outputValue = new ArrayList<>();
        private String[] numbers = new String[10];
        private char isE;
        private char isB;

        public void solveLinePattern(String line) {

            parseArgs(line);

            uniqueSignalPatterns.forEach(this::populateUniqueLengthPatterns);
            uniqueSignalPatterns.stream().filter(x -> x.length() == 5).forEach(this::populateLengthOfFivePatterns);
            uniqueSignalPatterns.stream().filter(x -> x.length() == 6).forEach(this::populateLengthOfSixPatterns);

            outputValue.forEach(this::translatePattern);

        }

        private void translatePattern(String pattern) {
            for (int i = 0; i < numbers.length; i++) {
                if (pattern.equals(numbers[i])) {
                    translatedNumbers.add(i);
                }
            }
        }

        private void populateLengthOfFivePatterns(String pattern) {
            if (pattern.contains(String.valueOf(isE))) {
                numbers[2] = pattern;
            } else if (pattern.contains(String.valueOf(isB))) {
                numbers[5] = pattern;
            } else {
                numbers[3] = pattern;
            }
        }

        private void populateLengthOfSixPatterns(String pattern) {
            if (!(pattern.contains(String.valueOf(isE)))) {
                numbers[9] = pattern;
            } else if (pattern.contains(String.valueOf(numbers[1].charAt(0)))
                    && pattern.contains(String.valueOf(numbers[1].charAt(1)))) {
                numbers[0] = pattern;
            } else {
                numbers[6] = pattern;
            }
        }

        private void populateUniqueLengthPatterns(String pattern) {

            int len = pattern.length();
            if (len == 2) {
                numbers[1] = pattern;
            } else if (len == 3) {
                numbers[7] = pattern;
            } else if (len == 4) {
                numbers[4] = pattern;
            } else if (len == 7) {
                numbers[8] = pattern;
            }
        }

        private void parseArgs(String line) {

            String[] args = line
                    .replace("|", ",")
                    .split(",");

            uniqueSignalPatterns.addAll(Arrays.asList(sortAscending(args[0].split(" "))));
            outputValue.addAll(Arrays.asList(sortAscending(args[1].trim().split(" "))));

            Arrays.fill(numbers, "");

            char[] sign = {'a','b','c','d','e','f','g'};
            for (int i = 0; i < sign.length; i++) {
                char c = sign[i];
                long count = args[0].codePoints().filter(ch -> ch == c).count();
                if (count == 4) {
                    isE = c;
                } else if (count == 6) {
                    isB = c;
                }
            }

        }

        private String[] sortAscending(String[] arr) {

            String[] ret = new String[arr.length];
            for (int i = 0; i < arr.length; i++) {
                char[] charArray = arr[i].toCharArray();
                Arrays.sort(charArray);
                ret[i] = new String(charArray);
            }
            return ret;
        }
    }


}



//num 8                     7                  4         1
//    7     5     5     5   3      6      6    4      6  2
//    acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf
//
//
//    2   1 (1)
//    3   1 (7)
//    4   1 (4)
//    5   3 (2, 3, 5)
//    6   3 (0, 6, 9)
//    7   1 (8)
//
//
//    a 8 n
//    b 6
//    c 8 n
//    d 7 n
//    e 4
//    f 9
//    g 7 n
//
//    1. parsear e colocar em ordem alfabética
//    2. setar os valores
//    length = 2 é o num 1
//    length = 3 é o num 7
//    length = 4 é o num 4
//    length = 7 é o num 8
//    3. descobrir
//    length = 5 pode ser 2, 3 ou 5
//    length = 6 pode ser 0, 6 ou 9
//    4. dicas
//    2 é o que tem o digito que aparece 4 vezes (e)
//    5 é o que tem o digito que aparece 6 vezes (b)
//    3 é o que sobra
//
//
//    9 é o que NAO tem o digito que aparece 4 vezes (e)
//    0 é o que tem todos os digitos em iguais ao que length = 2
//    6 é o que sobra
//
//
//    0 6
//    1 2
//    2 5
//    3 5
//    4 4
//    5 5
//    6 6
//    7 3
//    8 7
//    9 6
