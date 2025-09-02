package org.example;

import static org.example.ArrayHandler.*;
import static org.example.DataExtractor.*;

public class Main {
    private static final String fileWithInitialArray = "initial_array.txt";
    private static final String fileWithTargetSum = "target_sum.txt";

    public static void main(String[] args) {
        findPairsInInitialArray(getArrayFromFile(fileWithInitialArray),
                getIntFromFile(fileWithTargetSum));
    }
}