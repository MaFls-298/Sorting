package com.sorting;

import java.util.Arrays;

public class Sortaplication {

    public static void ejecutarSorts(int[] original) {

        // Gnome sort
        int[] gnome = original.clone();
        medirTiempo("Gnome Sort", () -> Sorter.gnomeSort(gnome));

        // Merge sort
        int[] merge = original.clone();
        medirTiempo("Merge Sort", () -> Sorter.mergeSort(merge));

        // Quick sort
        int[] quick = original.clone();
        medirTiempo("Quick Sort", () -> Sorter.quickSort(quick));

        // Radix sort
        int[] radix = original.clone();
        medirTiempo("Radix Sort", () -> Sorter.radixSort(radix));

        // Bubble sort
        int[] bubble = original.clone();
        medirTiempo("Bubble Sort", () -> Sorter.bubbleSort(bubble));

        // Verificación
        System.err.println("Ejemplo de arreglo ordenado");
        System.err.println(Arrays.toString(quick));
    }

    private static void medirTiempo(String nombre, Runnable algoritmo) {
        long inicio = System.nanoTime();
        algoritmo.run();
        long fin = System.nanoTime();
        System.out.println(nombre + " -> " + (fin - inicio) + " ns");
    }
}
