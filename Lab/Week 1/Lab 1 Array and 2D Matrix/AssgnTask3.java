// //Assignment Task 03: Game Arena
// class AssgnTask3{

//     //Complete this method so that it gives the Expected Output
//     //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
//     public static void playGame( Integer[][] arena ){

//         //For this task you don't need to create any new 2D array
//         //just print the result inside the function

//         //TO DO
//     }

//     //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
//     public static void main(String[] args){
//         Integer[][] arena = {
//             {0,2,2,0},
//             {50,1,2,0},
//             {2,2,2,0},
//             {1,100,2,0}
//         };
//         System.out.println("Given Arena: ");
//         Arr.print2D(arena);

//         System.out.println("\nExpected Output:");
//         System.out.print("Points Gained: 6. Your team is out.\n");

//         System.out.print("\nYour Output:\n");
//         playGame( arena );

//         System.out.print("\n======================\n");

//         Integer[][] arena1 = {
//             {0,2,2,0,2},
//             {1,50,2,1,100},
//             {2,2,2,0,2},
//             {0,200,2,0,0}
//         };
//         System.out.println("\nGiven Arena: ");
//         Arr.print2D(arena1);

//         System.out.println("\nExpected Output:");
//         System.out.print("Points Gained: 14. Your team has survived the game.\n");

//         System.out.print("\nYour Output:\n");
//         playGame( arena1 );
//     }
// }

// =======================================================================================================

//Assignment Task 03: Game Arena
class AssgnTask3 {

    // Complete this method so that it gives the Expected Output
    // YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void playGame(Integer[][] arena) {

        // For this task you don't need to create any new 2D array
        // just print the result inside the function

        // TO DO

        int totalPoints = 0;
        int rows = arena.length;
        int cols = arena[0].length;

        // Traverse through the arena to find players (multiples of 50)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if current cell contains a player (multiple of 50 and greater than 0)
                if (arena[i][j] != null && arena[i][j] > 0 && arena[i][j] % 50 == 0) {
                    int playerPoints = 0;

                    // Check cell above
                    if (i - 1 >= 0 && arena[i - 1][j] != null && arena[i - 1][j] == 2) {
                        playerPoints++;
                    }

                    // Check cell below
                    if (i + 1 < rows && arena[i + 1][j] != null && arena[i + 1][j] == 2) {
                        playerPoints++;
                    }

                    // Check cell to the left
                    if (j - 1 >= 0 && arena[i][j - 1] != null && arena[i][j - 1] == 2) {
                        playerPoints++;
                    }

                    // Check cell to the right
                    if (j + 1 < cols && arena[i][j + 1] != null && arena[i][j + 1] == 2) {
                        playerPoints++;
                    }

                    // Each cell with 2 gives 2 points
                    totalPoints += playerPoints * 2;
                }
            }
        }

        // Print the result
        System.out.print("Points Gained: " + totalPoints + ". ");
        if (totalPoints >= 10) {
            System.out.print("Your team has survived the game.");
        } else {
            System.out.print("Your team is out.");
        }

    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        Integer[][] arena = {
                { 0, 2, 2, 0 },
                { 50, 1, 2, 0 },
                { 2, 2, 2, 0 },
                { 1, 100, 2, 0 }
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);

        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");

        System.out.print("\nYour Output:\n");
        playGame(arena);

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
                { 0, 2, 2, 0, 2 },
                { 1, 50, 2, 1, 100 },
                { 2, 2, 2, 0, 2 },
                { 0, 200, 2, 0, 0 }
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);

        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");

        System.out.print("\nYour Output:\n");
        playGame(arena1);
    }
}
