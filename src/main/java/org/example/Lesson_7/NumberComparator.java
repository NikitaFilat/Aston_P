package org.example.Lesson_7;

public class NumberComparator {
    public static String compare(int a, int b) {
        if (a > b) {
            return a + " больше " + b;
        } else if (a < b) {
            return a + " меньше " + b;
        } else {
            return a + " равно " + b;
        }
    }
    public static void main(String[] args) {

    }
}
