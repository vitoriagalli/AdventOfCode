package days;


import java.util.*;

public class Day06 extends AbstractDay {

    public Day06() {
        super("06");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        System.out.println(solvePart1());
    }


    @Override
    public void part2() {

        System.out.println("Part2:");
//        System.out.println(solvePart2());

    }

    public int solvePart1() {

        Map<String, List<String>> hashMap = createHashMap();

        int sumOrbits = 0;

        for (List<String> list : hashMap.values()) {
            for (String value : list) {
                sumOrbits += countOrbits(value, hashMap, 0);
            }
        }

        return sumOrbits;
    }

//    public int solvePart2() {
//
//
//    }

    int countOrbits(String value, Map<String, List<String>> hashMap, int n) {

        for (String key : hashMap.keySet()) {
            for (String valueToCompare : hashMap.get(key)) {
                if (valueToCompare.equals(value)) {
                    return(countOrbits(key, hashMap, n + 1));
                }
            }
        }
        return n;
    }




    public Map<String, List<String>> createHashMap() {

        Map<String, List<String>> hashMap = new HashMap<String, List<String>>();

        argList.forEach(line -> {

            String[] args = line.split("\\)");
            String key = args[0];
            String value = args[1];

            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(value);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(value);
                hashMap.put(key, list);
            }
        });

        return hashMap;
    }



}

//chave, lista de valores
//
//COM:B
//B:C, G
//C:D
//D:E, I
//E:F, J
//H:G
//J:K
//K:L
//
//
//
//                  I
// COM  B   C   D   E   F
//                      J   K   L
//          G   H
//
//
// COM 0
// B 1
// C 2
// D 3
// E 4
// F 5
// G 2
// H 3
// I 4
// J 5
// K 6
// L 7