import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Lesson_7.TriangleAreaCalculator;

class TriangleAreaCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "5, 4, 10.0",
            "10, 5, 25.0",
            "7, 3, 10.5",
            "12, 8, 48.0",
            "15, 10, 75.0"
    })
    void testCalculateAreaWithBaseAndHeight(double base, double height, double expected) {
        assertEquals(expected, TriangleAreaCalculator.calculateArea(base, height), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, 6.0",
            "7, 8, 9, 26.833",
            "5, 5, 5, 10.825",
            "6, 8, 10, 24.0",
            "13, 14, 15, 84.0"
    })
    void testCalculateAreaHeron(double a, double b, double c, double expected) {
        assertEquals(expected, TriangleAreaCalculator.calculateAreaHeron(a, b, c), 0.001);
    }

    @Test
    void testCalculateAreaWithNegativeBase() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(-5, 4));
        assertEquals("Основание и высота должны быть положительными числами", exception.getMessage());
    }

    @Test
    void testCalculateAreaWithNegativeHeight() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(5, -4));
    }

    @Test
    void testCalculateAreaWithZeroBase() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(0, 4));
    }

    @Test
    void testCalculateAreaWithZeroHeight() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(5, 0));
    }

    @Test
    void testCalculateAreaHeronWithInvalidTriangle() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateAreaHeron(1, 2, 5));
        assertEquals("Треугольник с такими сторонами не существует", exception.getMessage());
    }

    @Test
    void testCalculateAreaHeronWithNegativeSide() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateAreaHeron(-3, 4, 5));
    }

    @Test
    void testCalculateAreaHeronWithImpossibleTriangle() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateAreaHeron(1, 1, 3));
    }
}