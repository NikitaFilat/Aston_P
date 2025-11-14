package org.example;

// ЗАДАНИЕ 1 - Классы животных

/**
 * Базовый класс Животное
 */
class Animal {
    private static int animalCount = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

/**
 * Класс Собака
 */
class Dog extends Animal {
    private static int dogCount = 0;
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. Максимум: " + MAX_SWIM_DISTANCE + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

/**
 * Класс Кот
 */
class Cat extends Animal {
    private static int catCount = 0;
    private final int MAX_RUN_DISTANCE = 200;
    private boolean satiety; // сытость

    public Cat(String name) {
        super(name);
        this.satiety = false; // изначально голоден
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    /**
     * Метод для питания из миски
     */
    public void eatFromBowl(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            this.satiety = true;
            System.out.println(name + " покушал " + foodAmount + " еды и теперь сыт.");
        } else {
            System.out.println(name + " не смог покушать. В миске недостаточно еды.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public static int getCatCount() {
        return catCount;
    }
}

/**
 * Класс Миска
 */
class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0); // гарантируем неотрицательное значение
    }

    /**
     * Метод для уменьшения еды в миске
     * @param amount количество еды для уменьшения
     * @return true если еды хватило, false если нет
     */
    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    /**
     * Метод для добавления еды в миску
     * @param amount количество еды для добавления
     */
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + foodAmount + " еды.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = Math.max(foodAmount, 0);
    }
}

// ЗАДАНИЕ 2 - Геометрические фигуры

/**
 * Интерфейс для геометрических фигур
 */
interface GeometricFigure {
    String getColor();
    String getBorderColor();
    double calculateArea();

    /**
     * Дефолтный метод для расчета периметра
     */
    default double calculatePerimeter() {
        return 0.0;
    }

    /**
     * Дефолтный метод для вывода информации о фигуре
     */
    default void printInfo() {
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()) +
                ", Площадь: " + String.format("%.2f", calculateArea()) +
                ", Цвет фона: " + getColor() +
                ", Цвет границ: " + getBorderColor());
    }
}

/**
 * Класс Круг
 */
class Circle implements GeometricFigure {
    private double radius;
    private String color;
    private String borderColor;

    public Circle(double radius, String color, String borderColor) {
        this.radius = radius;
        this.color = color;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

/**
 * Класс Прямоугольник
 */
class Rectangle implements GeometricFigure {
    private double width;
    private double height;
    private String color;
    private String borderColor;

    public Rectangle(double width, double height, String color, String borderColor) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

/**
 * Класс Треугольник
 */
class Triangle implements GeometricFigure {
    private double sideA;
    private double sideB;
    private double sideC;
    private String color;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String color, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.color = color;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        // Используем формулу Герона
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

/**
 * Главный класс для демонстрации работы
 */
public class Homework2_4 {

    /**
     * Демонстрация работы с животными (Задание 1)
     */
    private static void demonstrateAnimals() {
        System.out.println("=== ЗАДАНИЕ 1 - ЖИВОТНЫЕ ===");

        // Создаем животных
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");

        // Тестируем бег и плавание
        System.out.println("\n--- Тестирование бега и плавания ---");
        dog1.run(300);
        dog1.run(600);  // превышение лимита
        dog1.swim(5);
        dog1.swim(15);  // превышение лимита

        cat1.run(150);
        cat1.run(250);  // превышение лимита
        cat1.swim(10);  // кот не умеет плавать

        // Работа с миской и котами
        System.out.println("\n--- Работа с миской ---");
        Bowl bowl = new Bowl(25);
        Cat[] cats = {cat1, cat2, cat3};

        System.out.println("\n--- Кормление котов ---");
        // Кормим котов
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, 10);
        }

        System.out.println("\n--- Состояние сытости котов ---");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isSatiety() ? "сыт" : "голоден"));
        }

        System.out.println("Остаток еды в миске: " + bowl.getFoodAmount());

        // Добавляем еду и кормим снова
        System.out.println("\n--- Добавление еды в миску ---");
        bowl.addFood(20);
        cat2.eatFromBowl(bowl, 10); // cat2 уже сыт, но пробуем еще раз

        // Статистика
        System.out.println("\n--- Статистика животных ---");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
    }

    /**
     * Демонстрация работы с геометрическими фигурами (Задание 2)
     */
    private static void demonstrateGeometricFigures() {
        System.out.println("\n\n=== ЗАДАНИЕ 2 - ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ ===");

        // Создаем массив фигур
        GeometricFigure[] figures = {
                new Circle(5.0, "Красный", "Черный"),
                new Rectangle(4.0, 6.0, "Синий", "Белый"),
                new Triangle(3.0, 4.0, 5.0, "Зеленый", "Желтый"),
                new Circle(3.5, "Желтый", "Красный"),
                new Rectangle(8.0, 3.0, "Фиолетовый", "Оранжевый"),
                new Triangle(5.0, 12.0, 13.0, "Голубой", "Серый")
        };

        // Выводим информацию о всех фигурах
        System.out.println("ХАРАКТЕРИСТИКИ ГЕОМЕТРИЧЕСКИХ ФИГУР:");
        for (int i = 0; i < figures.length; i++) {
            System.out.println("\nФигура " + (i + 1) + ":");
            figures[i].printInfo();
        }

        // Дополнительная демонстрация с конкретными фигурами
        System.out.println("\n\n--- ПОДРОБНАЯ ИНФОРМАЦИЯ О ФИГУРАХ ---");

        GeometricFigure circle = new Circle(10.0, "Голубой", "Серый");
        GeometricFigure rectangle = new Rectangle(7.0, 12.0, "Розовый", "Коричневый");
        GeometricFigure triangle = new Triangle(6.0, 8.0, 10.0, "Оранжевый", "Черный");

        System.out.println("\nКруг:");
        circle.printInfo();

        System.out.println("\nПрямоугольник:");
        rectangle.printInfo();

        System.out.println("\nТреугольник:");
        triangle.printInfo();
    }

    /**
     * Главный метод программы
     */
    public static void main(String[] args) {
        System.out.println("ДОМАШНЕЕ ЗАДАНИЕ 2.4");
        System.out.println("====================\n");

        // Демонстрация задания 1
        demonstrateAnimals();

        // Демонстрация задания 2
        demonstrateGeometricFigures();

        System.out.println("\n====================");
        System.out.println("ВЫПОЛНЕНИЕ ПРОГРАММЫ ЗАВЕРШЕНО");
    }
}