import days.*;

import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws Exception {

        try {

            ArrayList< Class<? extends AbstractDay> > listOfClasses = new ArrayList<>();

            for (String arg : args) {
                try {
                    Class c = Class.forName("days." + arg.toUpperCase().charAt(0) + arg.toLowerCase().substring(1));
                    listOfClasses.add(c);
                } catch (Exception e) { System.out.println("Error: " + e.getMessage() + " Class did not exist"); }
            }

            for(Class<? extends AbstractDay> dayClass : listOfClasses)
            {
                AbstractDay day = dayClass.getDeclaredConstructor().newInstance();
                day.readFileAndGetArgs();
                day.part1();
                day.part2();
            }

        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

}