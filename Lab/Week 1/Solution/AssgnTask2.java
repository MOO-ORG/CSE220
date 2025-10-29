//Assignment Task 02: Matrix Compression
class AssgnTask2 {

    // Complete this method so that it gives the Expected Output
    // YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static Integer[][] compressMatrix(Integer[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int newNumRows = rows / 2;
        int newNumCols = cols / 2;

        Integer[][] compressedMatrix = new Integer[newNumRows][newNumCols];

        for (int i = 0; i < newNumRows; i++) {
            for (int j = 0; j < newNumCols; j++) {

                int r = 2 * i;
                int c = 2 * j;
                int sum = matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c] + matrix[r + 1][c + 1];
                compressedMatrix[i][j] = sum;
            }
        }
        return compressedMatrix;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        Integer[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 1, 3, 5, 2 },
                { -2, 0, 6, -3 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);

        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");

        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix(matrix);
        Arr.print2D(returnedArray);
    }
}
