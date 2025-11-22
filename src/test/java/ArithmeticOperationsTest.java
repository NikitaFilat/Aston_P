import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.example.Lesson_7.ArithmeticOperations;

public class ArithmeticOperationsTest {

    @Test
    public void testAdd() {
        assertEquals(ArithmeticOperations.add(10, 5), 15);
        assertEquals(ArithmeticOperations.add(-10, 5), -5);
        assertEquals(ArithmeticOperations.add(0, 0), 0);
        assertEquals(ArithmeticOperations.add(-5, -3), -8);
        assertEquals(ArithmeticOperations.add(100, 200), 300);
    }

    @Test
    public void testSubtract() {
        assertEquals(ArithmeticOperations.subtract(10, 5), 5);
        assertEquals(ArithmeticOperations.subtract(-10, 5), -15);
        assertEquals(ArithmeticOperations.subtract(5, 5), 0);
        assertEquals(ArithmeticOperations.subtract(0, 5), -5);
        assertEquals(ArithmeticOperations.subtract(-5, -3), -2);
    }

    @Test
    public void testMultiply() {
        assertEquals(ArithmeticOperations.multiply(10, 5), 50);
        assertEquals(ArithmeticOperations.multiply(-10, 5), -50);
        assertEquals(ArithmeticOperations.multiply(0, 5), 0);
        assertEquals(ArithmeticOperations.multiply(-5, -3), 15);
        assertEquals(ArithmeticOperations.multiply(7, 8), 56);
    }

    @Test
    public void testDivide() {
        assertEquals(ArithmeticOperations.divide(10, 5), 2.0, 0.001);
        assertEquals(ArithmeticOperations.divide(-10, 5), -2.0, 0.001);
        assertEquals(ArithmeticOperations.divide(2, 5), 0.4, 0.001);
        assertEquals(ArithmeticOperations.divide(7, 2), 3.5, 0.001);
        assertEquals(ArithmeticOperations.divide(0, 5), 0.0, 0.001);
        assertEquals(ArithmeticOperations.divide(-8, -4), 2.0, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(10, 0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZeroWithNegative() {
        ArithmeticOperations.divide(-5, 0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZeroWithZero() {
        ArithmeticOperations.divide(0, 0);
    }
}