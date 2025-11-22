import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.example.Lesson_7.NumberComparator;

public class NumberComparatorTest {

    @Test
    public void testCompareGreater() {
        assertEquals(NumberComparator.compare(10, 5), "10 больше 5");
        assertEquals(NumberComparator.compare(100, 50), "100 больше 50");
        assertEquals(NumberComparator.compare(-5, -10), "-5 больше -10");
        assertEquals(NumberComparator.compare(0, -5), "0 больше -5");
        assertEquals(NumberComparator.compare(15, 3), "15 больше 3");
    }

    @Test
    public void testCompareLess() {
        assertEquals(NumberComparator.compare(5, 10), "5 меньше 10");
        assertEquals(NumberComparator.compare(-10, 5), "-10 меньше 5");
        assertEquals(NumberComparator.compare(-15, -5), "-15 меньше -5");
        assertEquals(NumberComparator.compare(2, 8), "2 меньше 8");
        assertEquals(NumberComparator.compare(-3, 0), "-3 меньше 0");
    }

    @Test
    public void testCompareEqual() {
        assertEquals(NumberComparator.compare(10, 10), "10 равно 10");
        assertEquals(NumberComparator.compare(0, 0), "0 равно 0");
        assertEquals(NumberComparator.compare(-5, -5), "-5 равно -5");
        assertEquals(NumberComparator.compare(25, 25), "25 равно 25");
        assertEquals(NumberComparator.compare(-100, -100), "-100 равно -100");
    }

    @Test
    public void testCompareWithZero() {
        assertEquals(NumberComparator.compare(0, 0), "0 равно 0");
        assertEquals(NumberComparator.compare(1, 0), "1 больше 0");
        assertEquals(NumberComparator.compare(0, 1), "0 меньше 1");
        assertEquals(NumberComparator.compare(-1, 0), "-1 меньше 0");
        assertEquals(NumberComparator.compare(0, -1), "0 больше -1");
    }

    @Test
    public void testCompareWithLargeNumbers() {
        assertEquals(NumberComparator.compare(1000, 500), "1000 больше 500");
        assertEquals(NumberComparator.compare(500, 1000), "500 меньше 1000");
        assertEquals(NumberComparator.compare(999, 999), "999 равно 999");
    }
}