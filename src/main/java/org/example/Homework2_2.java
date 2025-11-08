public class Homework2_2 {

    // 1. Задание
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2. Задание
    public static void checkSumSign() {
        int a = 5;
        int b = -3;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3. Задание
    public static void printColor() {
        int value = 75;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // 4. Задание
    public static void compareNumbers() {
        int a = 10;
        int b = 20;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // 5. Задание
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // 6. Задание
    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // 7. Задание
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // 8. Задание
    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    // 9. Задание
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 10. Задание
    public static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.print("Исходный массив: ");
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }

        System.out.print("Инвертированный массив: ");
        printArray(array);
    }

    // 11. Задание
    public static void fillArray() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.print("Массив от 1 до 100: ");
        printArray(array);
    }

    // 12. Задание
    public static void multiplyLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.print("Исходный массив: ");
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        System.out.print("Преобразованный массив: ");
        printArray(array);
    }

    // 13. Задание
    public static void fillDiagonals() {
        int size = 5;
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1; // Главная диагональ
            array[i][size - 1 - i] = 1; // Побочная диагональ
        }

        System.out.println("Массив с диагоналями:");
        print2DArray(array);
    }

    // 14. Задание
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    // Вспомогательные методы для вывода массивов
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Главный метод для тестирования всех методов
    public static void main(String[] args) {
        System.out.println("=== Метод 1: printThreeWords() ===");
        printThreeWords();

        System.out.println("\n=== Метод 2: checkSumSign() ===");
        checkSumSign();

        System.out.println("\n=== Метод 3: printColor() ===");
        printColor();

        System.out.println("\n=== Метод 4: compareNumbers() ===");
        compareNumbers();

        System.out.println("\n=== Метод 5: isSumInRange() ===");
        System.out.println("Сумма 5 и 10 в диапазоне 10-20: " + isSumInRange(5, 10));
        System.out.println("Сумма 5 и 5 в диапазоне 10-20: " + isSumInRange(5, 5));

        System.out.println("\n=== Метод 6: checkNumberSign() ===");
        checkNumberSign(10);
        checkNumberSign(-5);
        checkNumberSign(0);

        System.out.println("\n=== Метод 7: isNegative() ===");
        System.out.println("10 отрицательное: " + isNegative(10));
        System.out.println("-5 отрицательное: " + isNegative(-5));
        System.out.println("0 отрицательное: " + isNegative(0));

        System.out.println("\n=== Метод 8: printStringMultipleTimes() ===");
        printStringMultipleTimes("Hello", 3);

        System.out.println("\n=== Метод 9: isLeapYear() ===");
        System.out.println("2020 високосный: " + isLeapYear(2020));
        System.out.println("2021 високосный: " + isLeapYear(2021));
        System.out.println("2000 високосный: " + isLeapYear(2000));
        System.out.println("1900 високосный: " + isLeapYear(1900));

        System.out.println("\n=== Метод 10: invertArray() ===");
        invertArray();

        System.out.println("\n=== Метод 11: fillArray() ===");
        fillArray();

        System.out.println("\n=== Метод 12: multiplyLessThanSix() ===");
        multiplyLessThanSix();

        System.out.println("\n=== Метод 13: fillDiagonals() ===");
        fillDiagonals();

        System.out.println("\n=== Метод 14: createArray() ===");
        int[] newArray = createArray(5, 7);
        System.out.print("Созданный массив: ");
        printArray(newArray);
    }
}