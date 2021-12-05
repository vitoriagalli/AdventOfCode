import days.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        try {

            ArrayList< Class<? extends AbstractDay> > listOfClasses = new ArrayList<>();
//            listOfClasses.add(Day01.class);
//            listOfClasses.add(Day02.class);
//            listOfClasses.add(Day03.class);
//            listOfClasses.add(Day04.class);
//            listOfClasses.add(Day05.class);   // TODO
//            listOfClasses.add(Day06.class);
//            listOfClasses.add(Day07.class);   // TODO
//            listOfClasses.add(Day08.class);
//            listOfClasses.add(Day09.class);   // TODO
            listOfClasses.add(Day10.class);

            for(Class<? extends AbstractDay> dayClass : listOfClasses)
            {
                AbstractDay day = dayClass.getDeclaredConstructor().newInstance();
                day.readFileAndGetArgs();
                day.part1();
                day.part2();
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}


//https://cal.se/day02/02.html