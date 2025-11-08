package org.example;

// Импорт должен быть здесь, сразу после объявления пакета
import java.util.*;
import java.util.stream.Collectors; // (Необязательно, но полезно для стримов)

public class Homework2_6 { // <-- Только одно объявление класса

    // ---------------------- ЗАДАНИЕ 1 ----------------------

    // Класс Student
    static class Student {
        private String name;
        private int group;
        private int course;
        private List<Integer> grades;

        public Student(String name, int group, int course, List<Integer> grades) {
            this.name = name;
            this.group = group;
            this.course = course;
            this.grades = grades;
        }

        public String getName() {
            return name;
        }

        public int getGroup() {
            return group;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        // Вычисляем средний балл (использует метод Optional.orElse(0) на случай пустых оценок)
        public double getAverageGrade() {
            return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
        }

        @Override
        public String toString() {
            // Форматируем средний балл до двух знаков после запятой
            return String.format("%s (курс: %d, группа: %d, средний балл: %.2f)", name, course, group, getAverageGrade());
        }
    }

    // Удаляет студентов со средним баллом < 3
    // Использование Set.removeIf() — это правильный и эффективный способ.
    public static void removeLowGrades(Set<Student> students) {
        students.removeIf(s -> s.getAverageGrade() < 3);
    }

    // Переводит студентов на следующий курс при среднем балле >= 3
    public static void increaseCourse(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    // Печатает студентов, обучающихся на указанном курсе
    public static void printStudents(Set<Student> students, int course) {
        // Улучшенное использование Stream API (не обязательно, но часто приветствуется)
        students.stream()
                .filter(s -> s.getCourse() == course)
                .forEach(s -> System.out.println(s.getName()));
    }


    // ---------------------- ЗАДАНИЕ 2 ----------------------

    static class PhoneBook {
        // Используем Map<Фамилия, Список_Телефонов>
        private Map<String, List<String>> book = new HashMap<>();

        // Добавляет телефон к существующей фамилии или создает новую запись
        public void add(String surname, String phone) {
            // computeIfAbsent() - это отличный, современный и потокобезопасный способ
            book.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
        }

        // Получает список телефонов
        public List<String> get(String surname) {
            // getOrDefault() - предотвращает NullPointerException
            return book.getOrDefault(surname, Collections.emptyList());
        }
    }


    // ---------------------- MAIN ----------------------
    public static void main(String[] args) {
        // ... (Ваш код в main остается без изменений)
        System.out.println("=== ЗАДАНИЕ 1 ===");

        Set<Student> students = new HashSet<>();
        students.add(new Student("Иванов", 101, 1, Arrays.asList(4, 3, 5))); // Ср. балл 4.0
        students.add(new Student("Петров", 102, 1, Arrays.asList(2, 2, 3))); // Ср. балл 2.33 (БУДЕТ УДАЛЕН)
        students.add(new Student("Сидоров", 103, 2, Arrays.asList(5, 5, 4))); // Ср. балл 4.67

        System.out.println("Студенты 1 курса до:");
        printStudents(students, 1); // Выведет: Иванов, Петров

        removeLowGrades(students); // Удаляет Петрова
        increaseCourse(students); // Иванов перейдет на 2 курс

        System.out.println("\nПосле удаления и перевода:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nСтуденты 2 курса после:");
        printStudents(students, 2); // Выведет: Иванов, Сидоров

        System.out.println("\n=== ЗАДАНИЕ 2 ===");

        PhoneBook pb = new PhoneBook();
        pb.add("Иванов", "123-45-67");
        pb.add("Иванов", "987-65-43");
        pb.add("Петров", "555-55-55");

        System.out.println("Телефоны Иванова: " + pb.get("Иванов"));
        System.out.println("Телефоны Петрова: " + pb.get("Петров"));
        System.out.println("Телефоны несуществующей фамилии: " + pb.get("Сидоров"));
    }
}
