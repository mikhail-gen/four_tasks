package org.example;

import static org.example.WordCounter.*;
import static org.example.inputHandler.*;

public class Main {
    public static void main(String[] args) {
             countRepeatingWords(provideListOfWords(), provideRepeatCount());
    }
}