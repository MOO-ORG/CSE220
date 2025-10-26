// //Assignment Task 01: Row Rotation Policy
// class AssgnTask1{

//     //Complete this method so that it gives the Expected Output
//     //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
//     public static Integer rowRotation( Integer examWeek, String[][] matrix ){

//         //For this task you don't need to create new Matrix
// 	//You can create 1D array if you need (but you can do it without creating any 1D array as well)
//         //After rotation the Matrix should be printed inside the method
//         //Only the integer row number is to be returned

//         //TO DO
//         return null;
//     }

//     //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
//     public static void main(String[] args){
//         String[][] seatStatus = {
//                 {"A" , "B"  , "C"  , "D"  , "E"},
//                 {"F" , "G"  , "H"  , "I"  , "J"},
//                 {"K" , "L"  , "M"  , "N"  , "O"},
//                 {"P" , "Q"  , "R"  , "S"  , "T"},
//                 {"U" , "V"  , "W"  , "X"  , "Y"},
//                 {"Z" , "AA" , "BB" , "CC" , "DD"}
//         };
//         System.out.println("Given Seat Status: ");
//         Arr.print2D(seatStatus);
        
//         System.out.println("\nExpected Output:");
//         System.out.println("| U  | V  | W  | X  | Y  | ");
//         System.out.println("| Z  | AA | BB | CC | DD | ");
//         System.out.println("| A  | B  | C  | D  | E  | ");
//         System.out.println("| F  | G  | H  | I  | J  | ");
//         System.out.println("| K  | L  | M  | N  | O  | ");
//         System.out.println("| P  | Q  | R  | S  | T  | ");
//         System.out.println("Your friend AA will be on row 2");
        
//         System.out.print("\nYour Output:\n");
//         Integer examWeek = 3;
//         //This following should print modified seat status after rotation and return the current exam week
//         Integer rowNumber = rowRotation( examWeek, seatStatus );
//         //The following should print Your friend AA will be on row 2
//         System.out.println("Your friend AA will be on row "+rowNumber);
//     }
// }


// =======================================================================================================

//Assignment Task 01: Row Rotation Policy
class AssgnTask1 {

    // Complete this method so that it gives the Expected Output
    // YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static Integer rowRotation(Integer examWeek, String[][] matrix) {

        // For this task you don't need to create new Matrix
        // You can create 1D array if you need (but you can do it without creating any
        // 1D array as well)
        // After rotation the Matrix should be printed inside the method
        // Only the integer row number is to be returned

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int rotations = numRows - examWeek; // Adjust rotation count = 3

        for (int week = 1; week < rotations; week++) {
            String lastRow[] = matrix[numRows - 1]; // Store the last row
            // Shift all rows down by one
            for (int i = numRows - 1; i > 0; i--) {
                matrix[i] = matrix[i - 1];
            }
            matrix[0] = lastRow; // Put the last row at the top
        }

        // Print the matrix after rotation
        Arr.print2D(matrix);

        // Find the row number where "AA" is located (1-indexed)
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j].equals("AA")) {
                    return i + 1; // Return 1-indexed row number
                }
            }
        }

        return null;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        String[][] seatStatus = {
                { "A", "B", "C", "D", "E" },
                { "F", "G", "H", "I", "J" },
                { "K", "L", "M", "N", "O" },
                { "P", "Q", "R", "S", "T" },
                { "U", "V", "W", "X", "Y" },
                { "Z", "AA", "BB", "CC", "DD" }
        };
        System.out.println("Given Seat Status: ");
        Arr.print2D(seatStatus);

        System.out.println("\nExpected Output:");
        System.out.println("| U  | V  | W  | X  | Y  | ");
        System.out.println("| Z  | AA | BB | CC | DD | ");
        System.out.println("| A  | B  | C  | D  | E  | ");
        System.out.println("| F  | G  | H  | I  | J  | ");
        System.out.println("| K  | L  | M  | N  | O  | ");
        System.out.println("| P  | Q  | R  | S  | T  | ");
        System.out.println("Your friend AA will be on row 2");

        System.out.print("\nYour Output:\n");
        Integer examWeek = 3;
        // This following should print modified seat status after rotation and return
        // the current exam week
        Integer rowNumber = rowRotation(examWeek, seatStatus);
        // The following should print Your friend AA will be on row 2
        System.out.println("Your friend AA will be on row " + rowNumber);
    }
}
