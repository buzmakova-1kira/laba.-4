package validation;

import java.util.Scanner;

/** Валидатор ввода данных с консоли */
public class InputValidator {
    // FIX_ME: в поле scanner не было final
    // старый код: private Scanner scanner;
    private final Scanner scanner;

    /** Конструктор: принимает Scanner */
    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    /** Возвращает целое число */
    public int getValidInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("Ошибка! Введите целое число.");
                scanner.nextLine();
            }
        }
    }

    /** Возвращает целое число в диапазоне [min, max] */
    public int getValidIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = getValidInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Ошибка! Число должно быть от " + min + " до " + max + ".");
        }
    }

    /** Возвращает число double */
    public double getValidDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("Ошибка! Введите число.");
                scanner.nextLine();
            }
        }
    }

    /** Возвращает непустую строку */
    public String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Ошибка! Ввод не может быть пустым.");
        }
    }

    /** Возвращает выбор задачи (0-6) */
    public int getValidChoice() {
        return getValidIntInRange("Выберите задачу (0-6): ", 0, 6);
    }
}