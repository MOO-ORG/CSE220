//Lab Task 01: Merge Sorted Array

class LabTask1_Optimized {

    /*
     * Merge two sorted arrays into one sorted array.
     * Time: O(m + n), Space: O(m + n)
     */
    public static Integer[] mergeSortedArray(Integer[] arr1, Integer[] arr2) {

        // TO DO
        // DELETE the following return statement when you're ready to return the newly
        // Created array

        int m = arr1.length;
        int n = arr2.length;

        Integer mergedArray[] = new Integer[n + m];

        int i = 0, j = 0, k = 0;

        // Merge while both arrays have elements: pick the smaller of arr1[i] and arr2[j]
        // i -> index in arr1, j -> index in arr2, k -> index in mergedArray
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        // Copy any leftovers from arr1 (if arr1 is longer)
        while (i < m) {
            mergedArray[k++] = arr1[i++];
        }

        // Copy any leftovers from arr2 (if arr2 is longer)
        while (j < n) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        Integer[] a1 = { 1, 2, 3 };
        Integer[] a2 = { 2, 5, 6 };
        System.out.print("Array 1: ");
        Arr.print(a1);
        System.out.print("Array 2: ");
        Arr.print(a2);
        System.out.println("Expected Output: [ 1 2 2 3 5 6 ]");
        Integer[] returned_val_1 = mergeSortedArray(a1, a2);
        System.out.print("Your Output: ");
        Arr.print(returned_val_1);
        System.out.print("\n======================\n");
        Integer[] a3 = { 1, 3, 5, 11 };
        Integer[] a4 = { 2, 7, 8 };
        System.out.print("\nArray 3: ");
        Arr.print(a3);
        System.out.print("Array 4: ");
        Arr.print(a4);
        System.out.println("Expected Output: [ 1 2 3 5 7 8 11 ]");
        Integer[] returned_val_2 = mergeSortedArray(a3, a4);
        System.out.print("Your Output: ");
        Arr.print(returned_val_2);
    }
}
