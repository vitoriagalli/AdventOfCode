import days.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        try {

            ArrayList< Class<? extends AbstractDay> > listOfClasses = new ArrayList<>();
            String filePath = getFilePath();

            for (String arg : args) {
                try {
                    Class c = Class.forName("days." + arg.toUpperCase().charAt(0) + arg.toLowerCase().substring(1));
                    listOfClasses.add(c);
                } catch (Exception e) { System.out.println("Error: " + e.getMessage() + " Class did not exist"); }
            }

            for(Class<? extends AbstractDay> dayClass : listOfClasses)
            {
                AbstractDay day = dayClass.getDeclaredConstructor().newInstance();
                day.readFileAndGetArgs(filePath);
                day.part1();
                day.part2();
            }

        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    private static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        return os;
    }

    private static String getFilePath() {

        if (getOperatingSystem().contains("Mac OS")) {
            return ".//args//day";
        } else {
            return ".\\args\\day";
        }
    }

}