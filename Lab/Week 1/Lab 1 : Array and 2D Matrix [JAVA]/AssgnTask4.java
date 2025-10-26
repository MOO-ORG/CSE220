// //Assignment Task 04: Rotate Secret
// class AssgnTask4{

//     //Complete this method so that it gives the Expected Output
//     //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
//     //If needed you can create extra helper static methods
//     //if extra helper methods are used then you must submit those as well
//     public static void rotateSecret( Character[][] board ){

//         //Print the message inside of this method
//         //TO DO

//     }

//     //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
//     public static void main(String[] args){
//         System.out.print("===========Test#1===========\n");
//         Character[][] board = {
//           {'T','A','U','S'},
//           {'A','R','I','.'},
//           {'D','T','T','N'},
//           {'S','C','F','U'}
//         };
//         System.out.println("Given Board: ");
//         Arr.print2D(board);

//         System.out.println("\nExpected Output:");
//         Character[][] outputBoard = {
//             {'D','A','T','A'},
//             {'S','T','R','U'},
//             {'C','T','I','S'},
//             {'F','U','N','.'}
//         };
//         System.out.print("DATASTRUCTISFUN.\n");
//         Arr.print2D(outputBoard);
        
//         System.out.print("\nYour Output:\n");
//         rotateSecret( board );
//         Arr.print2D(board);
        
//         if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 1 Success");
//         else System.out.println("Test 1 FAILED");
        
//         System.out.print("\n===========Test#2===========\n");

//         board = new Character[][]{
//           {'O','R','I','R','N','P'},
//           {'G','S','A','A','L','R'},
//           {'L','M','N','O','N','Y'},
//           {'A','H','U','O','O','P'},
//           {'T','F','C','T','H','S'},
//           {'E','D','Y','O','C','K'}
//         };
//         System.out.println("Given Board: ");
//         Arr.print2D(board);

//         System.out.println("\nExpected Output:");
//         outputBoard = new Character[][]{
//             {'A','L','G','O','R','I'},
//             {'T','H','M','S','A','R'},
//             {'E','F','U','N','A','N'},
//             {'D','C','O','O','L','P'},
//             {'Y','T','H','O','N','R'},
//             {'O','C','K','S','P','Y'}
//         };
//         System.out.print("ALGORITHMSAREFUNANDCOOLPYTHONROCKS\n");
//         Arr.print2D(outputBoard);
        
//         System.out.print("\nYour Output:\n");
//         rotateSecret( board );
//         Arr.print2D(board);
        
//         if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 2 Success");
//         else System.out.println("Test 2 FAILED");
//     }
// }


// =======================================================================================================

//Assignment Task 04: Rotate Secret
class AssgnTask4 {

    // Complete this method so that it gives the Expected Output
    // YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    // If needed you can create extra helper static methods
    // if extra helper methods are used then you must submit those as well
    public static void rotateSecret(Character[][] board) {

        // Rotate each square layer clockwise.
        // Outer layer rotates more times, inner layer rotates fewer times.
        // After rotating all layers, print the message row-wise.

        int n = board.length;
        int layers = n / 2; // number of square "rings"

        for (int layer = 0; layer < layers; layer++) {
            int start = layer;
            int end = n - 1 - layer;
            int len = end - start;
            if (len <= 0)
                continue; // single center cell (odd n) has no ring

            int perimeter = 4 * len; // number of cells around this ring
            int times = (layers - layer) % perimeter; // effective clockwise steps
            if (times == 0)
                continue; // no net movement

            // 1) Read the ring in clockwise order into a linear list
            char[] ring = new char[perimeter];
            int idx = 0;

            // top row (left -> right)
            for (int j = start; j < end; j++)
                ring[idx++] = board[start][j];
            // right column (top -> bottom)
            for (int i = start; i < end; i++)
                ring[idx++] = board[i][end];
            // bottom row (right -> left)
            for (int j = end; j > start; j--)
                ring[idx++] = board[end][j];
            // left column (bottom -> top)
            for (int i = end; i > start; i--)
                ring[idx++] = board[i][start];

            // 2) Rotate the linear list clockwise by 'times'
            // Clockwise ring rotation == shifting array forward by 'times'
            char[] rotated = new char[perimeter];
            for (int k = 0; k < perimeter; k++) {
                rotated[(k + times) % perimeter] = ring[k];
            }

            // 3) Write back to the board in the same traversal order
            idx = 0;
            // top row (left -> right)
            for (int j = start; j < end; j++)
                board[start][j] = rotated[idx++];
            // right column (top -> bottom)
            for (int i = start; i < end; i++)
                board[i][end] = rotated[idx++];
            // bottom row (right -> left)
            for (int j = end; j > start; j--)
                board[end][j] = rotated[idx++];
            // left column (bottom -> top)
            for (int i = end; i > start; i--)
                board[i][start] = rotated[idx++];
        }

        // Print recovered message (row-wise)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        System.out.println(sb.toString());
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.print("===========Test#1===========\n");
        Character[][] board = {
                { 'T', 'A', 'U', 'S' },
                { 'A', 'R', 'I', '.' },
                { 'D', 'T', 'T', 'N' },
                { 'S', 'C', 'F', 'U' }
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        Character[][] outputBoard = {
                { 'D', 'A', 'T', 'A' },
                { 'S', 'T', 'R', 'U' },
                { 'C', 'T', 'I', 'S' },
                { 'F', 'U', 'N', '.' }
        };
        System.out.print("DATASTRUCTISFUN.\n");
        Arr.print2D(outputBoard);

        System.out.print("\nYour Output:\n");
        rotateSecret(board);
        Arr.print2D(board);

        if (Arr.compare2D(outputBoard, board))
            System.out.print("Test 1 Success");
        else
            System.out.println("Test 1 FAILED");

        System.out.print("\n===========Test#2===========\n");

        board = new Character[][] {
                { 'O', 'R', 'I', 'R', 'N', 'P' },
                { 'G', 'S', 'A', 'A', 'L', 'R' },
                { 'L', 'M', 'N', 'O', 'N', 'Y' },
                { 'A', 'H', 'U', 'O', 'O', 'P' },
                { 'T', 'F', 'C', 'T', 'H', 'S' },
                { 'E', 'D', 'Y', 'O', 'C', 'K' }
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        outputBoard = new Character[][] {
                { 'A', 'L', 'G', 'O', 'R', 'I' },
                { 'T', 'H', 'M', 'S', 'A', 'R' },
                { 'E', 'F', 'U', 'N', 'A', 'N' },
                { 'D', 'C', 'O', 'O', 'L', 'P' },
                { 'Y', 'T', 'H', 'O', 'N', 'R' },
                { 'O', 'C', 'K', 'S', 'P', 'Y' }
        };
        System.out.print("ALGORITHMSAREFUNANDCOOLPYTHONROCKSPY\n");
        Arr.print2D(outputBoard);

        System.out.print("\nYour Output:\n");
        rotateSecret(board);
        Arr.print2D(board);

        if (Arr.compare2D(outputBoard, board))
            System.out.print("Test 2 Success");
        else
            System.out.println("Test 2 FAILED");
    }
}
