import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Lesson_7.NumberComparator;

class NumberComparatorTest {

    @ParameterizedTest
    @CsvSource({
            "10, 5, '10 больше 5'",
            "100, 50, '100 больше 50'",
            "-5, -10, '-5 больше -10'",
            "0, -5, '0 больше -5'",
            "15, 3, '15 больше 3'",
            "999, 1, '999 больше 1'"
    })
    void testCompareGreater(int a, int b, String expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 10, '5 меньше 10'",
            "-10, 5, '-10 меньше 5'",
            "-15, -5, '-15 меньше -5'",
            "2, 8, '2 меньше 8'",
            "-3, 0, '-3 меньше 0'",
            "1, 100, '1 меньше 100'"
    })
    void testCompareLess(int a, int b, String expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, '10 равно 10'",
            "0, 0, '0 равно 0'",
            "-5, -5, '-5 равно -5'",
            "25, 25, '25 равно 25'",
            "-100, -100, '-100 равно -100'",
            "777, 777, '777 равно 777'"
    })
    void testCompareEqual(int a, int b, String expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }

    @Test
    void testCompareWithZero() {
        assertEquals("0 равно 0", NumberComparator.compare(0, 0));
        assertEquals("1 больше 0", NumberComparator.compare(1, 0));
        assertEquals("0 меньше 1", NumberComparator.compare(0, 1));
        assertEquals("-1 меньше 0", NumberComparator.compare(-1, 0));
        assertEquals("0 больше -1", NumberComparator.compare(0, -1));
    }

    @Test
    void testCompareWithLargeNumbers() {
        assertEquals("1000 больше 500", NumberComparator.compare(1000, 500));
        assertEquals("500 меньше 1000", NumberComparator.compare(500, 1000));
        assertEquals("999 равно 999", NumberComparator.compare(999, 999));
    }

    @Test
    void testCompareWithIntegerBoundaries() {
        assertEquals(Integer.MAX_VALUE + " больше " + Integer.MIN_VALUE,
                NumberComparator.compare(Integer.MAX_VALUE, Integer.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE + " меньше " + Integer.MAX_VALUE,
                NumberComparator.compare(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}