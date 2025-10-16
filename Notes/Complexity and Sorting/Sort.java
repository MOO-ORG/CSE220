import java.util.Arrays;

public class Sort {

    // Bubble sort function

    static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection sort function
    static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    public static void main(String[] args) {

        int arr[] = { 5, 2, 8, 1, 3 };
        System.out.println("Array length: " + arr.length);
        System.out.println();
        System.out.printf("%-15s: %s\n", "Original array", Arrays.toString(arr));
        System.out.println();

        // Bubble Sort
        int[] bubbleArr = Arrays.copyOf(arr, arr.length);
        System.out.println("========== Bubble Sort ==========");
        bubbleSort(bubbleArr);
        System.out.printf("%-15s: %s\n", "Sorted array", Arrays.toString(bubbleArr));
        System.out.println("========== End of Bubble Sort ==========");
        System.out.println();

        // Selection Sort
        int[] selectionArr = Arrays.copyOf(arr, arr.length);
        System.out.println("========== Selection Sort ==========");
        selectionSort(selectionArr);
        System.out.printf("%-15s: %s\n", "Sorted array", Arrays.toString(selectionArr));
        System.out.println("========== End of Selection Sort ==========");
        System.out.println();

    }
}