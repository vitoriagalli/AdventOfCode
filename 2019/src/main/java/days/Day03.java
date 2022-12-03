package days;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.abs;


public class Day03 extends AbstractDay {

    public Day03() {
        super("03");
    }

    @Override
    public void part1() {

        Position closerCrossPath = getCloserLocation();
        int distance = distance(closerCrossPath);
        System.out.println(closerCrossPath);
        System.out.println("distance = " + distance);

    }


    public Position getCloserLocation()
    {
        ArrayList<Position> positionsList1 = createListOfPositions(0);
        ArrayList<Position> positionsList2 = createListOfPositions(1);

        Position closerPosit = new Position( Integer.MAX_VALUE/2, Integer.MAX_VALUE/2);
        positionsList1.forEach(item1 -> {
            positionsList2.forEach(item2 -> {
                if (item1.equals(item2)) {
                    if (distance(item1) < distance(closerPosit) && item1.getXp() != 0 && item2.getYp() != 0) {
                        closerPosit.setXp(item1.getXp());
                        closerPosit.setYp(item1.getYp());
                    }
                }
            });
        });

        return closerPosit;
    }



    public int distance(Position position) {
        return abs(position.getXp()) + abs(position.getYp());
    }

    private ArrayList<Position> createListOfPositions(int index) {

        String[] instruct = argList.get(index).split(",");
        ArrayList<String> instructArrList = new ArrayList<>();
        instructArrList.addAll(Arrays.asList(instruct));

        ArrayList<Position> positionsList = new ArrayList<>();
        Position currPosit = new Position(0, 0);
        instructArrList.forEach(
                instruction -> {

                    int value = Integer.parseInt(instruction.substring(1));
                    char direction = instruction.charAt(0);
                    int x = 0;
                    int y = 0;
                    if (direction == 'U')
                        y += 1;
                    else if (direction == 'D')
                        y -= 1;
                    else if (direction == 'R')
                        x += 1;
                    else
                        x -= 1;

                    for (int i = 0; i < abs(value); i++)
                    {
                        positionsList.add(new Position(currPosit.getXp() + x * i, currPosit.getYp() + y * i));
                    }
                    currPosit.setXp(currPosit.getXp() + x * value);
                    currPosit.setYp(currPosit.getYp() + y * value);

                }
        );

        return positionsList;
    }


    @Override
    public void part2() {

    }



    // UTILS

    public static class Position extends ArrayList{

        private int xp;
        private int yp;

        public Position(int xp, int yp){
            this.xp = xp;
            this.yp = yp;
        }

        public Position(Position src){
            this.xp = src.getXp();
            this.yp = src.getYp();
        }



        @Override
        public String toString() {
            return "[" + xp +
                    "," + yp +
                    "]";
        }

        public int getXp() {
            return xp;
        }

        public void setXp(int xp) {
            this.xp = xp;
        }

        public int getYp() {
            return yp;
        }

        public void setYp(int yp) {
            this.yp = yp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Position position = (Position) o;
            return xp == position.xp && yp == position.yp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), xp, yp);
        }
    }



}
