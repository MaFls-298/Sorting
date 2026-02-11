package com.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class SorterTest {

    private final int[] baseArray = {5, 3, 8, 1, 2, 7, 4, 6};
    private final int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    void testGnomeSort() {
        int[] arr = baseArray.clone();
        Sorter.gnomeSort(arr);
        assertArrayEquals(sortedArray, arr);
    }

    @Test
    void testMergeSort() {
        int[] arr = baseArray.clone();
        Sorter.mergeSort(arr);
        assertArrayEquals(sortedArray, arr);
    }

    @Test
    void testQuickSort() {
        int[] arr = baseArray.clone();
        Sorter.quickSort(arr);
        assertArrayEquals(sortedArray, arr);
    }

    @Test
    void testRadixSort() {
        int[] arr = baseArray.clone();
        Sorter.radixSort(arr);
        assertArrayEquals(sortedArray, arr);
    }

    @Test
    void testSelectionSort() {
        int[] arr = baseArray.clone();
        Sorter.selectionSort(arr);
        assertArrayEquals(sortedArray, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        Sorter.mergeSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        Sorter.quickSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testRepeatedNumbers() {
        int[] arr = {4, 2, 4, 2, 1};
        int[] expected = {1, 2, 2, 4, 4};
        Sorter.gnomeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAllAlgorithmsProduceSameResult() {
        int[] expected = baseArray.clone();
        Arrays.sort(expected);

        int[] gnome = baseArray.clone();
        int[] merge = baseArray.clone();
        int[] quick = baseArray.clone();
        int[] radix = baseArray.clone();
        int[] selection = baseArray.clone();

        Sorter.gnomeSort(gnome);
        Sorter.mergeSort(merge);
        Sorter.quickSort(quick);
        Sorter.radixSort(radix);
        Sorter.selectionSort(selection);

        assertArrayEquals(expected, gnome);
        assertArrayEquals(expected, merge);
        assertArrayEquals(expected, quick);
        assertArrayEquals(expected, radix);
        assertArrayEquals(expected, selection);
    }
}
