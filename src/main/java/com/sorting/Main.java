package com.sorting;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {

        // Comenta estas líneas si no quieres generar nuevos números
        NumGenerator generator = new NumGenerator(Path.of("data/numbers.txt"));
        generator.generate(100);

        // Leer números
        int[] original = Numreader.readNumbers(Path.of("data/numbers.txt"));

        // Ejecutar todos los sorts
        SortRunner.ejecutarSorts(original);
    }
}
