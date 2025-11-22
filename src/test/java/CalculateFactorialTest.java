
import org.testng.annotations.Test;
import org.example.Lesson_7.CalculateFactorial;
import static org.testng.Assert.*;

public class CalculateFactorialTest {

    @Test
    public void testFactorialWithZero() {
        assertEquals(CalculateFactorial.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialWithOne() {
        assertEquals(CalculateFactorial.calculateFactorial(1), 1);
    }

    @Test
    public void testFactorialWithPositiveNumber() {
        assertEquals(CalculateFactorial.calculateFactorial(5), 120);
        assertEquals(CalculateFactorial.calculateFactorial(10), 3628800L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialWithNegativeNumber() {
        CalculateFactorial.calculateFactorial(-5);
    }
}