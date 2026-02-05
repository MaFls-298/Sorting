package com.sorting;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {

        //comentar estas dos lineas para no generar mas n umeros

        //////////////////
        
        NumGenerator generator = new NumGenerator(Path.of("data/numbers.txt"));
        generator.generate(100); //cambiar cantidad de numeros a generar

        ///////////////
        


    }
}