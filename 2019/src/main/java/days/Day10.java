package days;


public class Day10 extends AbstractDay {

    private int line;
    private int column;

    public Day10() {
        super("10");
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        System.out.println(solvePart1());
    }

    public int solvePart1() {
        column = argList.get(0).length();
        line = argList.size();

        int nAsteroids = 0;
        for (String str: argList) {
            nAsteroids += str.chars().filter(num -> num == '#').count();
        }
        System.out.println(nAsteroids);

        int blockedAsteroids = 0;
        int x, y = 0;
        int min = 100000000;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < line; j++) {
                blockedAsteroids = getBlockedAsteroids(i , j);
                if (blockedAsteroids < min)
                {
                    x = column;
                    y = line;
                    min = blockedAsteroids;
                }
            }
        }

        return nAsteroids - blockedAsteroids;
    }

    private int getBlockedAsteroids(int column, int line) {

        int blocked = 0;

        blocked += getQuadrantBlockedAsteroids(column, line);
        blocked += getQuadrantBlockedAsteroids(column * -1, line);
        blocked += getQuadrantBlockedAsteroids(column * -1, line * -1);
        blocked += getQuadrantBlockedAsteroids(column, line * -1);

        return blocked;
    }

    private int getQuadrantBlockedAsteroids(int column, int line) {

        int lineIterator = Math.abs(line);
        int columnIterator = Math.abs(column);

        int blocked = -1;
        while (validPosit(lineIterator, columnIterator)) {
            if (argList.get(lineIterator).charAt(columnIterator) == '#') {
                blocked++;
            }
            lineIterator += line;
            columnIterator += column;
        }
        return blocked;
    }

    private boolean validPosit(int lineIterator, int columnIterator) {

        if (lineIterator > 0 && lineIterator < line
            && columnIterator > 0 && columnIterator < column)
            return true;
        return false;
    }


    @Override
    public void part2() {
        System.out.println("Part2:");
//        System.out.println(solvePart2());
    }

}
