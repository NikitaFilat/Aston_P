package org.example;

// Исключение для ошибки размера массива
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

// Исключение для ошибки данных
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class Homework2_5 {

    // Метод, который складывает элементы массива 4х4
    public static int sum4x4Array(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Неверное количество строк: " + arr.length);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(
                        "Неверное количество столбцов в строке " + i + ": " + arr[i].length
                );
            }
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Ошибка в ячейке [" + i + "][" + j + "]: \"" + arr[i][j] + "\""
                    );
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        // Корректный массив
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Массив с неправильным элементом
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "X", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sum4x4Array(wrongDataArray);
            System.out.println("Сумма = " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        // Пример ловли ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // Ошибка
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
