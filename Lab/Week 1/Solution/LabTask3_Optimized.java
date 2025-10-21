//Lab Task 03: Decryption Process
class LabTask3_Optimized {

    // Complete this method so that it gives the Expected Output
    public static Integer[] decryptMatrix(Integer[][] matrix) {

        // For this task you'll need to create new arrays
        // we recommend you to use Integer type.
        // example: Integer[] array = new Integer[5]
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Calculate column-wise sums
        int[] colSums = new int[cols];
        for (int c = 0; c < cols; c++) {
            int sum = 0;
            for (int r = 0; r < rows; r++) {
                sum += matrix[r][c];
            }
            colSums[c] = sum;
        }

        // Step 2: Calculate differences between consecutive column sums
        Integer[] decryptedArray = new Integer[cols - 1];
        for (int i = 0; i < cols - 1; i++) {
            decryptedArray[i] = colSums[i + 1] - colSums[i];
        }

        return decryptedArray;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        Integer[][] matrix = {
                { 1, 3, 1 },
                { 6, 4, 2 },
                { 5, 1, 7 },
                { 9, 3, 3 },
                { 8, 5, 4 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        System.out.println("\nExpected Output:\n[ -13 1 ]");
        Integer[] returned_val_1 = decryptMatrix(matrix);
        System.out.print("\nYour Output:\n");
        Arr.print(returned_val_1);

    }
}