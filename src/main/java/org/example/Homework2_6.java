package org.example;

import java.util.*;

public class Homework2_6 {

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

        public double getAverageGrade() {
            return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
        }

        @Override
        public String toString() {

            return String.format("%s (курс: %d, группа: %d, средний балл: %.2f)", name, course, group, getAverageGrade());
        }
    }

    public static void removeLowGrades(Set<Student> students) {
        students.removeIf(s -> s.getAverageGrade() < 3);
    }


    public static void increaseCourse(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }


    public static void printStudents(Set<Student> students, int course) {

        students.stream()
                .filter(s -> s.getCourse() == course)
                .forEach(s -> System.out.println(s.getName()));
    }




    static class PhoneBook {

        private Map<String, List<String>> book = new HashMap<>();

        public void add(String surname, String phone) {

            book.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
        }


        public List<String> get(String surname) {

            return book.getOrDefault(surname, Collections.emptyList());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ЗАДАНИЕ 1 ===");

        Set<Student> students = new HashSet<>();
        students.add(new Student("Иванов", 101, 1, Arrays.asList(4, 3, 5))); // Ср. балл 4.0
        students.add(new Student("Петров", 102, 1, Arrays.asList(2, 2, 3))); // Ср. балл 2.33 (БУДЕТ УДАЛЕН)
        students.add(new Student("Сидоров", 103, 2, Arrays.asList(5, 5, 4))); // Ср. балл 4.67

        System.out.println("Студенты 1 курса до:");
        printStudents(students, 1); // Выведет: Иванов, Петров

        removeLowGrades(students);
        increaseCourse(students);

        System.out.println("\nПосле удаления и перевода:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nСтуденты 2 курса после:");
        printStudents(students, 2);

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