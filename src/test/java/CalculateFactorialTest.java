import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Lesson_7.CalculateFactorial;

class CalculateFactorialTest {

    @Test
    void testFactorialWithZero() {
        assertEquals(1, CalculateFactorial.calculateFactorial(0));
    }

    @Test
    void testFactorialWithOne() {
        assertEquals(1, CalculateFactorial.calculateFactorial(1));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "7, 5040",
            "8, 40320",
            "9, 362880",
            "10, 3628800"
    })
    void testFactorialWithPositiveNumbers(int input, long expected) {
        assertEquals(expected, CalculateFactorial.calculateFactorial(input));
    }

    @Test
    void testFactorialWithNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> CalculateFactorial.calculateFactorial(-5));
        assertEquals("Факториал отрицательного числа не определен", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    void testFactorialWithVariousNegativeNumbers(int number) {
        assertThrows(IllegalArgumentException.class,
                () -> CalculateFactorial.calculateFactorial(number));
    }
}