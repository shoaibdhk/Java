import java.util.Random;
import java.util.Scanner;

public class Soduko
{
    //Constant
	public static final int ROWS = 9;
	public static final int COLS = 9;
    public static int[][] initialPuzzle = new int[ROWS][COLS]; // creating a intial puzzle to view the user
    public static int[][] solvedPuzzle = new int[ROWS][COLS]; // making a random puzzle and solve for the puzzle
   
    public static void main(String[] args)
    {
        //Declare the array
    	makePuzzle();
        int[][] workingPuzzle = new int[ROWS][COLS];
        Scanner scnr = new Scanner(System.in);
        int row, col, value; String operation;
        resetPuzzle(workingPuzzle);
        do{
            printpuzzle(workingPuzzle);
            System.out.println("What would you like to do?\n(S) Set Sqare, (R) Reset puzzle, (Q) quit");
            operation = scnr.next().toUpperCase();
            switch(operation)
            {
                case "S":
                    System.out.println("Which row(1-9) and column(1-9) you want to change?");
                    row = scnr.nextInt()-1;
                    col = scnr.nextInt()-1;
                    System.out.println("What should the value (1-9) be?");
                    value = scnr.nextInt();

                    if(initialPuzzle[row][col]==0)
                        workingPuzzle[row][col]= value;
                    else
                        System.out.println("Didn't expect from you.try again");

                    break;
                case "R":
                    resetPuzzle(workingPuzzle);
                    break;
                case "Q":
                    System.out.println("Thank you for playing!");
                    System.exit(0);
            }
        }while(!gameIsWon(workingPuzzle));
        scnr.close();
        System.out.println("CONGRATULATION! YOU WON THE GAME");
    }
    
    // let's create a random Puzzle 
    public static void makePuzzle() {
    	
        Random r = new Random();
        int i1=r.nextInt(8);
        int firstval = i1;
        
        int x = firstval, v = 1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((x + j + v) <= 9)
                    solvedPuzzle[i][j] = j + x + v;
                else
                    solvedPuzzle[i][j] = j + x + v - 9;
                if (solvedPuzzle[i][j] == 10)
                    solvedPuzzle[i][j] = 1;
                // To view the generated puzzle
                //System.out.print(solvedPuzzle[i][j]+"  ");
            }
            x += 3;
            if (x >= 9)
                x = x - 9;
            //System.out.println(" ");
            if (i == 2) {
                v = 2;
                x = firstval;
            }
            if (i == 5) {
                v = 3;
                x = firstval;
            }

        }

        // let the user have choice the option hard or easy
        int choice;
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Hey, lets play a GAME of SUDOKU");
        System.out.println("enter your option 1.hard  2.easy");
        choice = consoleScanner.nextInt();
        consoleScanner.close();
        // If choice (1) the initial puzzle will have some numbers and if choice (2) the initial puzzle will be more numbers
        switch (choice) {
            case 1:
                initialPuzzle[0][0] = solvedPuzzle[0][0];
                initialPuzzle[8][8] = solvedPuzzle[8][8];
                initialPuzzle[0][3] = solvedPuzzle[0][3];
                initialPuzzle[0][4] = solvedPuzzle[0][4];
                initialPuzzle[1][2] = solvedPuzzle[1][2];
                initialPuzzle[1][3] = solvedPuzzle[1][3];
                initialPuzzle[1][6] = solvedPuzzle[1][6];
                initialPuzzle[1][7] = solvedPuzzle[1][7];
                initialPuzzle[2][0] = solvedPuzzle[2][0];
                initialPuzzle[2][4] = solvedPuzzle[2][4];
                initialPuzzle[2][8] = solvedPuzzle[2][8];
                initialPuzzle[3][2] = solvedPuzzle[3][2];
                initialPuzzle[3][8] = solvedPuzzle[3][8];
                initialPuzzle[4][2] = solvedPuzzle[4][2];
                initialPuzzle[4][3] = solvedPuzzle[4][3];
                initialPuzzle[4][5] = solvedPuzzle[4][5];
                initialPuzzle[4][6] = solvedPuzzle[4][6];
                initialPuzzle[5][0] = solvedPuzzle[5][0];
                initialPuzzle[5][6] = solvedPuzzle[5][6];
                initialPuzzle[6][0] = solvedPuzzle[6][0];
                initialPuzzle[6][4] = solvedPuzzle[6][4];
                initialPuzzle[6][8] = solvedPuzzle[6][8];
                initialPuzzle[7][1] = solvedPuzzle[7][1];
                initialPuzzle[7][2] = solvedPuzzle[7][2];
                initialPuzzle[7][5] = solvedPuzzle[7][5];
                initialPuzzle[7][6] = solvedPuzzle[7][6];
                initialPuzzle[8][4] = solvedPuzzle[8][4];
                initialPuzzle[8][5] = solvedPuzzle[8][5];
                initialPuzzle[0][0] = solvedPuzzle[0][0];
                initialPuzzle[8][8] = solvedPuzzle[8][8];

                break;
            case 2:
                initialPuzzle[0][3] = solvedPuzzle[0][3];
                initialPuzzle[0][4] = solvedPuzzle[0][4];
                initialPuzzle[1][2] = solvedPuzzle[1][2];
                initialPuzzle[1][3] = solvedPuzzle[1][3];
                initialPuzzle[1][6] = solvedPuzzle[1][6];
                initialPuzzle[1][7] = solvedPuzzle[1][7];
                initialPuzzle[1][8] = solvedPuzzle[1][8];
                initialPuzzle[2][0] = solvedPuzzle[2][0];
                initialPuzzle[2][4] = solvedPuzzle[2][4];
                initialPuzzle[2][8] = solvedPuzzle[2][8];
                initialPuzzle[3][2] = solvedPuzzle[3][2];
                initialPuzzle[3][5] = solvedPuzzle[3][5];
                initialPuzzle[3][8] = solvedPuzzle[3][8];
                initialPuzzle[4][0] = solvedPuzzle[4][0];
                initialPuzzle[4][2] = solvedPuzzle[4][2];
                initialPuzzle[4][3] = solvedPuzzle[4][3];
                initialPuzzle[4][4] = solvedPuzzle[4][4];
                initialPuzzle[4][5] = solvedPuzzle[4][5];
                initialPuzzle[4][6] = solvedPuzzle[4][6];
                initialPuzzle[5][0] = solvedPuzzle[5][0];
                initialPuzzle[5][1] = solvedPuzzle[5][1];
                initialPuzzle[5][4] = solvedPuzzle[5][4];
                initialPuzzle[5][6] = solvedPuzzle[5][6];
                initialPuzzle[6][0] = solvedPuzzle[6][0];
                initialPuzzle[6][4] = solvedPuzzle[6][4];
                initialPuzzle[6][6] = solvedPuzzle[6][6];
                initialPuzzle[6][8] = solvedPuzzle[6][8];
                initialPuzzle[7][0] = solvedPuzzle[7][0];
                initialPuzzle[7][1] = solvedPuzzle[7][1];
                initialPuzzle[7][2] = solvedPuzzle[7][2];
                initialPuzzle[7][5] = solvedPuzzle[7][5];
                initialPuzzle[7][6] = solvedPuzzle[7][6];
                initialPuzzle[8][2] = solvedPuzzle[8][2];
                initialPuzzle[8][4] = solvedPuzzle[8][4];
                initialPuzzle[8][5] = solvedPuzzle[8][5];
                break;
            default:
                System.out.println("entered option is incorrect");
                break;
        }
	           
    }

    // Reset the puzzle
    public static void resetPuzzle(int[][] workingPuzzle){
        for(int i = 0; i<ROWS; i++){
            for(int j = 0; j < COLS; j++)
                workingPuzzle[i][j] = initialPuzzle[i][j];
        }
    }
        // after reseting the soduko, we are printing the puzle into the console
       public static void printpuzzle(int[][] workingPuzzle){
           System.out.println("  C 1  2  3  4  5  6  7  8  9"+
       "\nR  --------------------------");
           for(int i = 0; i<ROWS; i++){
               System.out.print((i+1) + "  |");
               for(int j = 0; j<COLS; j++){

                   System.out.print( ((workingPuzzle[i][j]==0)? ".": (workingPuzzle[i][j])) + "  ");
               }
               System.out.println();
           }
       }

    // deciding if the user won
    public static boolean gameIsWon(int[][] workingPuzzle){

        for (int i = 0; i< ROWS; i++){
            for(int j = 0; j< COLS; j++){
                if (workingPuzzle[i][j] != solvedPuzzle[i][j])
                    return false;
            }
        }
        return true;
    }
}