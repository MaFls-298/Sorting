package com.sorting;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {

        // generarnumeros ////////////////////////////////////
        NumGenerator generator = new NumGenerator(Path.of("data/numbers.txt"));
        generator.generate(3000);

        /////////////////////////////////////////////////////

        // Leer numeros
        int[] original = NumReader.readNumbers(Path.of("data/numbers.txt"));

        // Ejecutar todos los sorts
        Sortaplication.ejecutarSorts(original);
    }
}
