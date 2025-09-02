package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DataExtractor {
    public static int[] getArrayFromFile(String fileName) {
        return convertStringToIntArray(readStringFromResource(fileName));
    }

    public static String readStringFromResource(String fileName) {
        ClassLoader classLoader = DataExtractor.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            String content = result.toString().trim();
            System.out.println("Строка из файла " + fileName + ": " + content);
            return content;
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка преобразования вцелое число: " + e.getMessage());
        }
        return null;
    }

    public static int[] convertStringToIntArray(String inputString) {
        var cleanedString = cleanInputString(inputString);
        int[] numbers = Arrays.stream(cleanedString.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Полученный массив: " + Arrays.toString(numbers));
        return numbers;
    }

    public static String cleanInputString(String inputString) {
        return inputString.replaceAll("[\\[\\]\\{\\}\\(\\)]", "").trim();
    }
}