import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import model.*;
import validation.InputValidator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator validator = new InputValidator(scanner);

        while (true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("1 - Задача 1.3: Имена");
            System.out.println("2 - Задача 2.2: Человек с именем");
            System.out.println("3 - Задача 2.3: Человек с родителем");
            System.out.println("4 - Задача 3.2: Ломаная");
            System.out.println("5 - Задача 4.9: Создаем Ломаную");
            System.out.println("6 - Задача 5.7: Длина Ломаной");
            System.out.println("0 - Выход");

            int choice = validator.getValidChoice();

            if (choice == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            switch (choice) {
                // ЗАДАНИЕ 1.3 - ИМЕНА
                case 1:
                    System.out.println("\n=== ЗАДАЧА 1.3 - ИМЕНА ===");

                    System.out.println("\n1. Создание имени (только личное имя):");
                    String firstNameOnly = validator.getNonEmptyString("Введите личное имя: ");
                    Name nameOnly = new Name(firstNameOnly);
                    System.out.println("Результат: " + nameOnly);

                    System.out.println("\n2. Создание имени (фамилия и имя):");
                    String lastNameFirst = validator.getNonEmptyString("Введите фамилию: ");
                    String firstNameFirst = validator.getNonEmptyString("Введите личное имя: ");
                    Name nameFirstLast = new Name(lastNameFirst, firstNameFirst);
                    System.out.println("Результат: " + nameFirstLast);

                    System.out.println("\n3. Создание полного имени:");
                    String lastNameFull = validator.getNonEmptyString("Введите фамилию: ");
                    String firstNameFull = validator.getNonEmptyString("Введите личное имя: ");
                    String middleNameFull = validator.getNonEmptyString("Введите отчество: ");
                    Name nameFull = new Name(lastNameFull, firstNameFull, middleNameFull);
                    System.out.println("Результат: " + nameFull);
                    break;

                // ЗАДАНИЕ 2.2 - ЧЕЛОВЕК С ИМЕНЕМ
                case 2:
                    System.out.println("\n=== ЗАДАЧА 2.2 - ЧЕЛОВЕК С ИМЕНЕМ ===");

                    System.out.println("\nСоздание человека с объектом Имя:");

                    System.out.println("\nВыберите тип имени:");
                    System.out.println("1 - Только имя");
                    System.out.println("2 - Фамилия и имя");
                    System.out.println("3 - Полное имя (ФИО)");
                    int nameType = validator.getValidIntInRange("Ваш выбор: ", 1, 3);

                    Name personName = null;

                    switch (nameType) {
                        case 1:
                            String firstName = validator.getNonEmptyString("Введите имя: ");
                            personName = new Name(firstName);
                            break;
                        case 2:
                            String lastName = validator.getNonEmptyString("Введите фамилию: ");
                            String firstName2 = validator.getNonEmptyString("Введите имя: ");
                            personName = new Name(lastName, firstName2);
                            break;
                        case 3:
                            String lastName3 = validator.getNonEmptyString("Введите фамилию: ");
                            String firstName3 = validator.getNonEmptyString("Введите имя: ");
                            String middleName = validator.getNonEmptyString("Введите отчество: ");
                            personName = new Name(lastName3, firstName3, middleName);
                            break;
                    }

                    int personHeight = validator.getValidIntInRange("Введите рост (см): ", 50, 250);
                    PersonSimple person = new PersonSimple(personName, personHeight);

                    System.out.println("\n--- Результат ---");
                    System.out.println(person);
                    break;

                // ЗАДАНИЕ 2.3 - ЧЕЛОВЕК С РОДИТЕЛЕМ
                case 3:
                    System.out.println("\n=== ЗАДАЧА 2.3 - ЧЕЛОВЕК С РОДИТЕЛЕМ ===");

                    System.out.println("\nСоздание семьи с вводом данных:");

                    System.out.println("\n=== СОЗДАНИЕ ОТЦА ===");
                    String fatherLastName = validator.getNonEmptyString("Введите фамилию отца: ");
                    String fatherFirstName = validator.getNonEmptyString("Введите имя отца: ");
                    int fatherHeight = validator.getValidIntInRange("Введите рост отца (см): ", 50, 250);
                    Person fatherPerson = new Person(new Name(fatherLastName, fatherFirstName), fatherHeight);

                    System.out.println("\n=== СОЗДАНИЕ СЫНА ===");
                    System.out.println("Фамилия будет унаследована автоматически");
                    String sonFirstName = validator.getNonEmptyString("Введите имя сына: ");
                    int sonHeight = validator.getValidIntInRange("Введите рост сына (см): ", 50, 250);
                    Person sonPerson = new Person(new Name(sonFirstName), sonHeight);

                    System.out.println("\n=== СОЗДАНИЕ ВНУКА ===");
                    System.out.println("Фамилия и отчество будут унаследованы автоматически");
                    String grandsonFirstName = validator.getNonEmptyString("Введите имя внука: ");
                    int grandsonHeight = validator.getValidIntInRange("Введите рост внука (см): ", 50, 250);
                    Person grandsonPerson = new Person(new Name(grandsonFirstName), grandsonHeight);

                    sonPerson.setFather(fatherPerson);
                    grandsonPerson.setFather(sonPerson);

                    System.out.println("\n--- После установки родственных связей ---");
                    System.out.println("Отец: " + fatherPerson);
                    System.out.println("Сын: " + sonPerson);
                    System.out.println("Внук: " + grandsonPerson);
                    break;

                // ЗАДАНИЕ 3.2 - ЛОМАНАЯ
                case 4:
                    System.out.println("\n=== ЗАДАЧА 3.2 - ЛОМАНАЯ ===");

                    System.out.println("\nСоздание двух ломаных с общими точками:");

                    System.out.println("\n=== СОЗДАНИЕ ПЕРВОЙ ЛОМАНОЙ ===");
                    Polyline line1 = new Polyline();

                    int pointsCount1 = validator.getValidIntInRange("Сколько точек в первой ломаной? ", 2, 10);
                    for (int i = 0; i < pointsCount1; i++) {
                        System.out.println("\nТочка " + (i + 1) + " для первой ломаной:");
                        double x = validator.getValidDouble("Введите координату X: ");
                        double y = validator.getValidDouble("Введите координату Y: ");
                        line1.addPoint(new Point(x, y));
                    }

                    System.out.println("\nПервая ломаная: " + line1);

                    System.out.println("\n=== СОЗДАНИЕ ВТОРОЙ ЛОМАНОЙ ===");
                    Polyline line2 = new Polyline();

                    Point firstPoint = line1.getFirstPoint();
                    line2.addPoint(firstPoint);
                    System.out.println("Добавлена первая точка из первой ломаной: " + firstPoint);

                    int middlePoints = validator.getValidIntInRange("Сколько промежуточных точек? ", 1, 5);
                    for (int i = 0; i < middlePoints; i++) {
                        System.out.println("\nПромежуточная точка " + (i + 1) + ":");
                        double x = validator.getValidDouble("Введите X: ");
                        double y = validator.getValidDouble("Введите Y: ");
                        line2.addPoint(new Point(x, y));
                    }

                    Point lastPoint = line1.getLastPoint();
                    line2.addPoint(lastPoint);
                    System.out.println("Добавлена последняя точка из первой ломаной: " + lastPoint);

                    System.out.println("\nВторая ломаная: " + line2);

                    System.out.println("\n=== СДВИГ НАЧАЛА ЛОМАНЫХ ===");
                    double dx = validator.getValidDouble("Введите смещение по X: ");
                    double dy = validator.getValidDouble("Введите смещение по Y: ");

                    System.out.println("Сдвигаем первую точку на (" + dx + ", " + dy + ")");
                    firstPoint.move(dx, dy);

                    System.out.println("\nРезультат после сдвига:");
                    System.out.println("Первая ломаная: " + line1);
                    System.out.println("Вторая ломаная: " + line2);
                    break;

                // ЗАДАНИЕ 4.9 - СОЗДАЕМ ЛОМАНУЮ
                case 5:
                    System.out.println("\n=== ЗАДАЧА 4.9 - СОЗДАЕМ ЛОМАНУЮ ===");

                    System.out.println("1. Создание пустой ломаной и добавление точек:");
                    Polyline emptyLine = new Polyline();
                    System.out.println("Пустая ломаная: " + emptyLine);

                    int pointsToAdd = validator.getValidIntInRange("Сколько точек добавить? ", 1, 10);
                    for (int i = 0; i < pointsToAdd; i++) {
                        System.out.println("\nТочка " + (i + 1) + ":");
                        double x = validator.getValidDouble("Введите X: ");
                        double y = validator.getValidDouble("Введите Y: ");
                        emptyLine.addPoint(x, y);
                    }
                    System.out.println("Ломаная после добавления: " + emptyLine);

                    System.out.println("\n2. Создание ломаной с готовым набором точек:");
                    int predefinedPointsCount = validator.getValidIntInRange("Сколько точек создать? ", 2, 10);
                    List<Point> predefinedPoints = new ArrayList<>();

                    for (int i = 0; i < predefinedPointsCount; i++) {
                        System.out.println("\nТочка " + (i + 1) + ":");
                        double x = validator.getValidDouble("Введите X: ");
                        double y = validator.getValidDouble("Введите Y: ");
                        predefinedPoints.add(new Point(x, y));
                    }

                    Polyline predefinedLine = new Polyline(predefinedPoints);
                    System.out.println("Ломаная с предустановленными точками: " + predefinedLine);
                    break;

                // ЗАДАНИЕ 5.7 - ДЛИНА ЛОМАНОЙ
                case 6:
                    System.out.println("\n=== ЗАДАЧА 5.7 - ДЛИНА ЛОМАНОЙ ===");

                    System.out.println("Создание ломаной и вычисление её длины:");

                    PolylineWithLength line = new PolylineWithLength();

                    System.out.println("Создание начальной ломаной:");
                    int initialPoints = validator.getValidIntInRange("Сколько точек в ломаной? ", 2, 10);

                    for (int i = 0; i < initialPoints; i++) {
                        System.out.println("\nТочка " + (i + 1) + ":");
                        double x = validator.getValidDouble("Введите X: ");
                        double y = validator.getValidDouble("Введите Y: ");
                        line.addPoint(x, y);
                    }

                    System.out.println("\nЛоманая: " + line);
                    System.out.println("Длина ломаной: " + String.format("%.2f", line.getLength()));

                    System.out.println("\nДобавление новых точек:");
                    int additionalPoints = validator.getValidIntInRange("Сколько точек добавить? ", 1, 5);

                    for (int i = 0; i < additionalPoints; i++) {
                        System.out.println("\nДополнительная точка " + (i + 1) + ":");
                        double x = validator.getValidDouble("Введите X: ");
                        double y = validator.getValidDouble("Введите Y: ");
                        line.addPoint(x, y);
                    }

                    System.out.println("\nЛоманая после добавления: " + line);
                    System.out.println("Новая длина ломаной: " + String.format("%.2f", line.getLength()));
                    break;

                default:
                    System.out.println("Неверный выбор!");
            }
        }
        scanner.close();
    }
}