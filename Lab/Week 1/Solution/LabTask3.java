//Lab Task 03: Decryption Process
class LabTask3 {

    // Complete this method so that it gives the Expected Output
    public static Integer[] decryptMatrix(Integer[][] matrix) {

        // For this task you'll need to create new arrays
        // we recommend you to use Integer type.
        // example: Integer[] array = new Integer[5]
        
        int row = matrix.length;
        int col = matrix[0].length; 

        int sum[] = new int[matrix.length];
        Integer newArr[] = new Integer[2];

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                sum[j] += matrix[i][j];
            }
        }

        newArr[0] = sum[1] - sum[0];
        newArr[1] = sum[2] - sum[1];
        // TO DO
        return newArr;
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