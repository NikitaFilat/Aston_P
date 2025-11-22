import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.example.Lesson_7.TriangleAreaCalculator;

public class TriangleAreaCalculatorTest {

    @Test
    public void testCalculateAreaWithBaseAndHeight() {
        assertEquals(TriangleAreaCalculator.calculateArea(5, 4), 10.0, 0.001);
        assertEquals(TriangleAreaCalculator.calculateArea(10, 5), 25.0, 0.001);
        assertEquals(TriangleAreaCalculator.calculateArea(7, 3), 10.5, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaWithNegativeBase() {
        TriangleAreaCalculator.calculateArea(-5, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaWithNegativeHeight() {
        TriangleAreaCalculator.calculateArea(5, -4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaWithZeroBase() {
        TriangleAreaCalculator.calculateArea(0, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaWithZeroHeight() {
        TriangleAreaCalculator.calculateArea(5, 0);
    }

    @Test
    public void testCalculateAreaHeron() {
        assertEquals(TriangleAreaCalculator.calculateAreaHeron(3, 4, 5), 6.0, 0.001);
        assertEquals(TriangleAreaCalculator.calculateAreaHeron(7, 8, 9), 26.832815729997478, 0.001);
        assertEquals(TriangleAreaCalculator.calculateAreaHeron(5, 5, 5), 10.825, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaHeronWithInvalidTriangle() {
        TriangleAreaCalculator.calculateAreaHeron(1, 2, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaHeronWithNegativeSide() {
        TriangleAreaCalculator.calculateAreaHeron(-3, 4, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaHeronWithZeroSide() {
        TriangleAreaCalculator.calculateAreaHeron(0, 4, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaHeronWithImpossibleTriangle() {
        TriangleAreaCalculator.calculateAreaHeron(1, 1, 3);
    }
}