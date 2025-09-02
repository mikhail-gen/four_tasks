package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {

    public static List<String> countRepeatingWords(List<String> wordList, int repeatCount) {
        List<String> repeatingWords = wordList.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == repeatCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Слова, которые повторяются " + repeatCount + " раз: " + repeatingWords);
        return repeatingWords;
    }
}