package days;



import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Day04 extends AbstractDay {

    private int min;
    private int max;

    public Day04() {
        super("04");
    }

    @Override
    public void part1() {

        System.out.println("Part1:");
        getMinAndMaxValue();
        System.out.println(solvePart1(min, max));
    }


    @Override
    public void part2() {

        System.out.println("Part2:");
        System.out.println(solvePart2(min, max));

    }

    public int solvePart1(int min, int max) {

        int count = 0;
        for (int n = min; n < max; n++)
        {
            int[] digits = Integer.toString(n).chars().map(c -> c-'0').toArray();
            if (hasSameAdjacentValue(digits) && isCrescent(digits))
                count ++;

        }
        return count;
    }

    public int solvePart2(int min, int max) {

        int count = 0;
        for (int n = min; n < max; n++)
        {
            int[] digits = Integer.toString(n).chars().map(c -> c-'0').toArray();
            if (hasSameAdjacentValueButNotBiggerGroup(digits) && isCrescent(digits))
                count ++;
        }
        return count;
    }


    private boolean hasSameAdjacentValueButNotBiggerGroup(int[] n) {

        int count[] = new int[]{0, 0, 0, 0, 0, 0};
        int value[] = new int[]{n[0], 0, 0, 0, 0, 0};

        int countValues = 0;
        if (hasSameAdjacentValue(n))
        {
            for (int i = 1; i < 6; i++) {
                if (n[i] == value[countValues])
                    count[countValues]++;
                else
                {
                    countValues++;
                    value[countValues] = n[i];
                }
            }

            if (ArrayUtils.indexOf(count, 1) > -1)
                return true;
            return false;
        }
        return false;
    }

    public int getIndexOfLargest( int[] array )
    {
        if ( array == null || array.length == 0 ) return -1; // null or empty

        int largest = 0;
        for ( int i = 1; i < array.length; i++ )
        {
            if ( array[i] > array[largest] ) largest = i;
        }
        return largest;
    }

    private boolean hasSameAdjacentValue(int[] n) {

        int j = 0;
        for (int i = 0; i < 5; i++) {
            j = i + 1;
            if (n[i] == n[j])
                return true;
        }
        return false;

    }

    private boolean isCrescent(int[] n) {

        int j = 0;
        for (int i = 0; i < 5; i++) {
            j = i + 1;
            if (n[i] > n[j])
                return false;
        }
        return true;
    }

    private void getMinAndMaxValue() {
        String [] values = argList.get(0).split("-");
        min = Integer.parseInt(values[0]);
        max = Integer.parseInt(values[1]);
        System.out.println(min + " " + max);
    }


}
