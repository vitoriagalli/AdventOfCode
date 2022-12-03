import days.Day01;
import org.junit.Assert;
import org.junit.Test;

public class Day01Test {

    Day01 dayObj = new Day01();

    @Test
    public void part01Test_00() {
        Assert.assertEquals(dayObj.calculateFuel(12), 2);
    }

    @Test
    public void part01Test_01() {
        Assert.assertEquals(dayObj.calculateFuel(14), 2);
    }

    @Test
    public void part01Test_02() {
        Assert.assertEquals(dayObj.calculateFuel(1969), 654);
    }

    @Test
    public void part01Test_03() {
        Assert.assertEquals(dayObj.calculateFuel(100756), 33583);
    }

    @Test
    public void part01Test_04() {
        Assert.assertEquals(dayObj.calculateFuel(12), 2);
    }

    @Test
    public void part02Test_00() {
        Assert.assertEquals(dayObj.calculateRecursiveFuel(14), 2);
    }

    @Test
    public void part02Test_01() {
        Assert.assertEquals(dayObj.calculateRecursiveFuel(1969), 966);
    }

    @Test
    public void part02Test_02() {
        Assert.assertEquals(dayObj.calculateRecursiveFuel(100756), 50346);
    }
}
