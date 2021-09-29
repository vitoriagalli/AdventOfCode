package days;

import days.exceptions.getArgsException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public abstract class AbstractDay {

    protected String dayStr;
    protected ArrayList<String> argList;

    private static final String filePath = ".\\args\\day";

    public AbstractDay(String dayStr) {
        this.dayStr = dayStr;
        this.argList = new ArrayList<>();
    }

    public void readFileAndGetArgs() throws Exception {

        System.out.println("--- DAY " + dayStr + " ---");

        try {

            File file = new File(filePath + dayStr);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null)
            {
                argList.add(line);
            }

        } catch (Exception e)
        {
            throw new getArgsException(e.getMessage());
        }
    }


    public void part1() {}

    public void part2() {};

}
