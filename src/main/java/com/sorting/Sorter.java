package com.sorting;

public class Sorter {

    // gonome sort//////////////////////////////////////////
    public static void gnomeSort(int[] arr) {
        int index = 0;

        while (index < arr.length) {
            if (index == 0) {
                index++;
            } else if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

    //merge sort////////////////////////////////////////
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;
            mergeSort(arr, izq, medio);
            mergeSort(arr, medio + 1, der);
            merge(arr, izq, medio, der);
        }
    }

    private static void merge(int[] arr, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[izq + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[medio + 1 + j];

        int i = 0, j = 0;
        int k = izq;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1)
            arr[k++] = left[i++];

        while (j < n2)
            arr[k++] = right[j++];
    }

//quick sort/////////////////////////////////

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

//radix sort  /////////////////////////////////////////////////////////////
    public static void radixSort(int[] arr) {

        if (arr.length == 0) return;

        
        int negatives = 0;
        for (int num : arr)
            if (num < 0)
                negatives++;

        int[] neg = new int[negatives];
        int[] pos = new int[arr.length - negatives];

        int ni = 0, pi = 0;
        for (int num : arr) {
            if (num < 0)
                neg[ni++] = -num; 
            else
                pos[pi++] = num;
        }

        
        radixSortPositive(neg);
        radixSortPositive(pos);

        int index = 0;
    //neg
        for (int i = neg.length - 1; i >= 0; i--)
            arr[index++] = -neg[i];

        // Pos
        for (int num : pos)
            arr[index++] = num;
    }

    private static void radixSortPositive(int[] arr) {
        if (arr.length == 0) return;

        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);
    }


    
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr)
            if (num > max)
                max = num;
        return max;
    }

        private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int j : arr)
            count[(j / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }


// selection sort//////////////////////////////////////////////////
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
