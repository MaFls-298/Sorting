package com.sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumGenerator {

    private final Path filePath;
    private final Random random = new Random();

    public NumGenerator(Path filePath) {
        this.filePath = filePath;
    }

    public void generate(int count) throws IOException {
        List<String> numbers = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            numbers.add(String.valueOf(random.nextInt()));
        }

        Files.write(filePath, numbers);
    }
}
