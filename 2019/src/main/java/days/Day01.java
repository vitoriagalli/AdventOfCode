package days;


import java.util.ArrayList;

public class Day01 extends AbstractDay {

    public Day01() {
        super("01");
    }

    @Override
    public void main() {

        try {

            for(String str : argList)
            {
                System.out.println(str);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
