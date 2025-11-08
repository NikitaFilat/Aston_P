package org.example;

public class Homework2_3 {
}
// ЗАДАНИЕ 1: Класс Товар
class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    // Конструктор
    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    // Метод для вывода информации об объекте
    public void displayInfo() {
        System.out.println("=== Информация о товаре ===");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Забронирован: " + (isReserved ? "Да" : "Нет"));
        System.out.println("============================");
    }

    // Геттеры и сеттеры (опционально)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProductionDate() { return productionDate; }
    public void setProductionDate(String productionDate) { this.productionDate = productionDate; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) { this.countryOfOrigin = countryOfOrigin; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isReserved() { return isReserved; }
    public void setReserved(boolean reserved) { isReserved = reserved; }
}

// ЗАДАНИЕ 2: Массив товаров
class ProductArrayExample {
    public static void main(String[] args) {
        // Создаем массив из 5 товаров
        Product[] productsArray = new Product[5];

        // Заполняем массив объектами
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "15.01.2025",
                "Apple Inc.", "USA", 6499, false);
        productsArray[2] = new Product("Xiaomi Mi 14", "10.12.2024",
                "Xiaomi Corporation", "China", 3899, true);
        productsArray[3] = new Product("Sony WH-1000XM5", "20.11.2024",
                "Sony Corporation", "Japan", 2999, false);
        productsArray[4] = new Product("Lenovo ThinkPad X1", "05.03.2025",
                "Lenovo Group", "China", 8999, true);

        // Выводим информацию о всех товарах
        System.out.println("ИНФОРМАЦИЯ О ВСЕХ ТОВАРАХ:");
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("\nТовар #" + (i + 1) + ":");
            productsArray[i].displayInfo();
        }
    }
}

// ЗАДАНИЕ 3: Класс Park с внутренним классом
class Park {
    private String parkName;
    private Attraction[] attractions;

    // Конструктор парка
    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new Attraction[0];
    }

    // Внутренний класс для хранения информации об аттракционах
    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double price;

        // Конструктор аттракциона
        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        // Метод для отображения информации об аттракционе
        public void displayAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
        }

        // Геттеры
        public String getAttractionName() { return attractionName; }
        public String getWorkingHours() { return workingHours; }
        public double getPrice() { return price; }
    }

    // Метод для добавления аттракциона в парк
    public void addAttraction(String name, String hours, double price) {
        Attraction newAttraction = new Attraction(name, hours, price);

        // Увеличиваем массив аттракционов
        Attraction[] newArray = new Attraction[attractions.length + 1];
        System.arraycopy(attractions, 0, newArray, 0, attractions.length);
        newArray[attractions.length] = newAttraction;
        attractions = newArray;
    }

    // Метод для отображения информации о парке и всех аттракционах
    public void displayParkInfo() {
        System.out.println("=== ПАРК: " + parkName + " ===");
        System.out.println("Количество аттракционов: " + attractions.length);

        for (int i = 0; i < attractions.length; i++) {
            System.out.println("\nАттракцион #" + (i + 1) + ":");
            attractions[i].displayAttractionInfo();
        }
    }

    // Геттеры
    public String getParkName() { return parkName; }
    public Attraction[] getAttractions() { return attractions; }
}

// Демонстрация работы всех классов (без public)
class HomeworkDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ ВСЕХ КЛАССОВ ===\n");

        // Демонстрация задания 1 и 2
        System.out.println("1. ДЕМОНСТРАЦИЯ КЛАССА ТОВАР:");
        Product demoProduct = new Product("Demo Product", "01.01.2025",
                "Demo Manufacturer", "Demo Country",
                1000, false);
        demoProduct.displayInfo();

        // Демонстрация задания 3
        System.out.println("\n2. ДЕМОНСТРАЦИЯ КЛАССА ПАРК:");
        Park myPark = new Park("Сказочный парк");

        // Добавляем аттракционы
        myPark.addAttraction("Американские горки", "10:00-20:00", 350);
        myPark.addAttraction("Колесо обозрения", "09:00-22:00", 200);
        myPark.addAttraction("Комната страха", "12:00-23:00", 250);
        myPark.addAttraction("Автодром", "11:00-19:00", 300);

        // Выводим информацию о парке
        myPark.displayParkInfo();

        // Демонстрация работы с внутренним классом
        System.out.println("\n3. РАБОТА С ВНУТРЕННИМ КЛАССОМ:");
        Park.Attraction singleAttraction = myPark.new Attraction("Новый аттракцион", "10:00-18:00", 400);
        singleAttraction.displayAttractionInfo();
    }
}