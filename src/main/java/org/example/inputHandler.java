package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class inputHandler {

    public static List<String> provideListOfWords() {
        var inputString = readInputAsString();
        return splitStringToList(inputString);
    }

    public static int provideRepeatCount() {
        return readInputAsValidInt();
    }

    public static String readInputAsString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слова разделяя их пробелами: ");
        return scanner.nextLine();
    }

    public static List<String> splitStringToList(String inputString) {
        return Arrays.stream(inputString.trim()
                        .split("\\s+"))
                .collect(Collectors.toList());
    }

    public static int readInputAsValidInt() {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Введите искомое число повторений (должно быть введено целое число > 0): ");
            String input = scanner.nextLine();
            input = input.trim();

            try {
                number = Integer.parseInt(input);
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Целое число должно быть больше 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено неверное значение. Введите целое число > 0.");
            }
        }
        return number;
    }
}