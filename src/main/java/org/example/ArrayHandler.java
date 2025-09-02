package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayHandler {

    public static List<int[]> findPairsInInitialArray(int[] intArray, int targetSum) {
        intArray = sortArrayIfUnsorted(intArray);
        var listOfPairs = findPairsWithSum(intArray, targetSum);
        System.out.println(
                listOfPairs.stream()
                        .map(Arrays::toString)
                        .collect(Collectors.joining(", ", "[", "]"))
        );
        return listOfPairs;
    }

    private static int[] sortArrayIfUnsorted(int[] intArray) {
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < intArray[i - 1]) {
                System.out.println("Внимание! Задан не отсортированный массив. Массив будет отсортирован");
                intArray = Arrays.stream(intArray).sorted().toArray();
                return intArray;
            }
        }
        return intArray;
    }

    private static List<int[]> findPairsWithSum(int[] intArray, int targetSum) {
        List<int[]> listOfPairs = new ArrayList<>();
        int left = 0;
        int right = findClosestIndex(intArray, targetSum);

        while (left < right) {
            int sum = intArray[left] + intArray[right];

            if (sum == targetSum) {
                listOfPairs.add(new int[]{intArray[left], intArray[right]});
                left++;
                right--;

                while (left < right && intArray[left] == intArray[left - 1]) {
                    left++;
                }
                while (left < right && intArray[right] == intArray[right + 1]) {
                    right--;
                }

            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return listOfPairs;
    }


    public static int findClosestIndex(int[] intArray, int targetSum) {
        int closestIndex = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < intArray.length; i++) {
            int diff = Math.abs(intArray[i] - targetSum);
            if (diff < minDiff) {
                minDiff = diff;
                closestIndex = i;
            }
        }
        return closestIndex;
    }
}