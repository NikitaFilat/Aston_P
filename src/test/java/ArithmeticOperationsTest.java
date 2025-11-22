import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Lesson_7.ArithmeticOperations;

class ArithmeticOperationsTest {

    @ParameterizedTest
    @CsvSource({
            "10, 5, 15",
            "-10, 5, -5",
            "0, 0, 0",
            "-5, -3, -8",
            "100, 200, 300",
            "15, -5, 10"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "-10, 5, -15",
            "5, 5, 0",
            "0, 5, -5",
            "-5, -3, -2",
            "8, 12, -4"
    })
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 50",
            "-10, 5, -50",
            "0, 5, 0",
            "-5, -3, 15",
            "7, 8, 56",
            "4, -3, -12"
    })
    void testMultiply(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 2.0",
            "-10, 5, -2.0",
            "2, 5, 0.4",
            "7, 2, 3.5",
            "0, 5, 0.0",
            "-8, -4, 2.0",
            "9, 4, 2.25"
    })
    void testDivide(int a, int b, double expected) {
        assertEquals(expected, ArithmeticOperations.divide(a, b), 0.001);
    }

    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(10, 0));
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }

    @Test
    void testDivideByZeroWithNegative() {
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(-5, 0));
    }

    @Test
    void testDivideByZeroWithZero() {
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(0, 0));
    }

    @Test
    void testAllOperationsWithBoundaryValues() {
        assertEquals(Integer.MAX_VALUE + 1, ArithmeticOperations.add(Integer.MAX_VALUE, 1));
        assertEquals(Integer.MIN_VALUE - 1, ArithmeticOperations.subtract(Integer.MIN_VALUE, 1));
    }
}