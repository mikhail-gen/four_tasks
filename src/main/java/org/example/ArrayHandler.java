package org.example;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayHandler {

    public static int[] prepareArrayWithoutDuplicates(int[] intArray) {
        isArraySorted(intArray);
        int[] noDuplicatesArray = removeDuplicates(intArray);
        System.out.println("Массив без дубликатов: " + Arrays.toString(noDuplicatesArray));
        return noDuplicatesArray;
    }

    public static void isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("Внимание! Задан не отсортированный массив.");
                return;
            }
        }
    }

    public static int[] removeDuplicates(int[] input) {
        Set<Integer> uniqueIntSet = new LinkedHashSet<>();
        for (int num : input) {
            uniqueIntSet.add(num);
        }
        return uniqueIntSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}