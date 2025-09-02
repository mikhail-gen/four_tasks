package org.example;

import static org.example.DataExtractor.*;
import static org.example.ArrayHandler.*;

public class Main {
    private static final String fileWithInitialArray = "initial_array.txt";

    public static void main(String[] args) {
        prepareArrayWithoutDuplicates(getArrayFromFile(fileWithInitialArray));
    }
}