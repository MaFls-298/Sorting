package com.sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NumReader {
    
    public static int[] readNumbers(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        int[] numbers = new int[lines.size()];
        for (int i_=0; i<lines.size(); i++){
            numbers[i] = Integer.parseInt(lines.get(i));

        }

        return numbers;
    }
}
