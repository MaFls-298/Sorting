public class Sorter {

    public static void gnomeSort(int[] arr);

    public static void mergeSort(int[] arr);
    private static void mergeSort(int[] arr, int izq, int der);
    private static void merge(int[] arr, int izq, int medio, int der);

    public static void quickSort(int[] arr);
    private static void quickSort(int[] arr, int low, int high);
    private static int partition(int[] arr, int low, int high);

    public static void radixSort(int[] arr);

    public static void bubbleSort(int[] arr); // algoritmo extra
}
