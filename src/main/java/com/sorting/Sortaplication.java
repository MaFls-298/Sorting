package com.sorting;

import java.util.Arrays;

public class Sortaplication {

    public static void ejecutarSorts(int[] original) {

        for (int size = 10; size <= 3000; size += 10) {

            if (size > original.length) break;

            System.out.println("\n==============================");
            System.out.println("Tamano: " + size);
            System.out.println("==============================");

            int[] subset = Arrays.copyOf(original, size);

            // gnome sort
            ejecutarAlgoritmo("Gnome Sort", subset, Sorter::gnomeSort);

            // merge sort
            ejecutarAlgoritmo("Merge Sort", subset, Sorter::mergeSort);

            // quick sort
            ejecutarAlgoritmo("Quick Sort", subset, Sorter::quickSort);

            // radix sort
            ejecutarAlgoritmo("Radix Sort", subset, Sorter::radixSort);

            // selection sort
            ejecutarAlgoritmo("Selection Sort", subset, Sorter::selectionSort);
        }
    }

    private static void ejecutarAlgoritmo(String nombre, int[] base, java.util.function.Consumer<int[]> algoritmo) {

         // desordenado
        int[] desordenado = base.clone();
        long inicio = System.nanoTime();
        algoritmo.accept(desordenado);
        long fin = System.nanoTime();
        long tiempoDesordenado = fin - inicio;

        // ordenado
        int[] ordenado = desordenado.clone();
        inicio = System.nanoTime();
        algoritmo.accept(ordenado);
        fin = System.nanoTime();
        long tiempoOrdenado = fin - inicio;

        System.out.println(nombre);
        System.out.println("   Desordenado -> " + tiempoDesordenado + " ns");
        System.out.println("   Ordenado    -> " + tiempoOrdenado + " ns");
        System.out.println();
    }
}
