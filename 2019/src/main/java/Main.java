import days.AbstractDay;
import days.Day01;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        try {

            ArrayList< Class<? extends AbstractDay> > listOfClasses = new ArrayList<>();
            listOfClasses.add(Day01.class);


            for(Class<? extends AbstractDay> dayClass : listOfClasses)
            {
                AbstractDay day = dayClass.getDeclaredConstructor().newInstance();
                day.readFileAndGetArgs();
                day.part1();
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
