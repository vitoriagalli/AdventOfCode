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
        System.out.println(solvePart2());
    }

    public int solvePart1() {

        Map<String, List<String>> hashMap = createHashMap();
        List<String> keyList = new ArrayList<String>();

        int sumOrbits = 0;

        for (List<String> list : hashMap.values()) {
            for (String value : list) {
                sumOrbits += getKeyList(value, hashMap, keyList).size();
                keyList.clear();
            }
        }
        return sumOrbits;
    }

    public int solvePart2() {

        Map<String, List<String>> hashMap = createHashMap();
        List<String> keyListSanta = getKeyList("SAN", hashMap, new ArrayList<>());
        List<String> keyListYou = getKeyList("YOU", hashMap, new ArrayList<>());
        String firstCommonKey = "";

        for (String key: keyListSanta) {
            if (keyListYou.contains(key)) {
                firstCommonKey = key;
                break;
            }
        }
        return (keyListSanta.indexOf(firstCommonKey) + keyListYou.indexOf(firstCommonKey));
    }

    List<String> getKeyList(String value, Map<String, List<String>> hashMap, List<String> list) {

        for (String key : hashMap.keySet()) {
            for (String valueToCompare : hashMap.get(key)) {
                if (valueToCompare.equals(value)) {
                    list.add(key);
                    return(getKeyList(key, hashMap, list));
                }
            }
        }
        return list;
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
