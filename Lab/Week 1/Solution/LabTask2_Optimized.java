//Lab Task 02: Zigzag Walk
class LabTask2_Optimized {

    // Complete this method so that it gives the Expected Output
    // NO NEED TO SUBMIT LAB TASKS
    public static void walkZigzag(Integer[][] matrix) {

        // For this task you don't need to create new arrays
        // TO DO

        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of columns

        /*
         * Zigzag rule by columns:
         * - For even columns (0-based): print even rows in increasing order (0,2,4,...)
         * - For odd columns (0-based): print odd rows in decreasing order (...,3,1)
         * Time: O(m*n) Space: O(1)
         */
        for (int c = 0; c < n; c++) { // iterate columns left-to-right
            boolean printed = false;

            if (c % 2 == 0) {
                // Even column: walk even rows top-down
                for (int r = 0; r < m; r += 2) {
                    System.out.print(matrix[r][c] + " ");
                    printed = true;
                }
            } else {
                // Odd column: walk odd rows bottom-up
                int start = ((m - 1) % 2 == 1) ? (m - 1) : (m - 2); // last odd row index
                for (int r = start; r >= 1; r -= 2) {
                    System.out.print(matrix[r][c] + " ");
                    printed = true;
                }
            }

            if (printed) {
                System.out.println(); // newline after finishing this column
            }
        }
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        Integer[][] floor1 = {
                { 3, 8, 4, 6, 1 },
                { 7, 2, 1, 9, 3 },
                { 9, 0, 7, 5, 8 },
                { 2, 1, 3, 4, 0 },
                { 1, 4, 2, 8, 6 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(floor1);
        System.out.println("\nExpected Output:");
        System.out.print("3 9 1\n1 2\n4 7 2\n4 9\n1 8 6\n");
        System.out.print("\nYour Output:\n");
        walkZigzag(floor1);

        System.out.print("\n======================\n");

        Integer[][] floor2 = {
                { 3, 8, 4, 6, 1 },
                { 7, 2, 1, 9, 3 },
                { 9, 0, 7, 5, 8 },
                { 2, 1, 3, 4, 0 },
        };
        System.out.println("\nGiven Matrix: ");
        Arr.print2D(floor2);
        System.out.println("\nExpected Output:");
        System.out.print("3 9\n1 2\n4 7\n4 9\n1 8\n");
        System.out.print("\nYour Output:\n");
        walkZigzag(floor2);

    }
}