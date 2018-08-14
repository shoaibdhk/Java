import java.util.Scanner;

public class AverageOfThree
{

    public static void main(String[] args)
    {
        //Declare 4 Variables(3int, 1double)
        int value1,value2, value3;
        double average;


        // We need something to read input from the user
        Scanner consoleScanner= new Scanner(System.in);

        // Prompt the user for input integer

        System.out.print("Print enter number 1: ");
        // Reads an integer value from scanner
        value1= consoleScanner.nextInt();
        System.out.print("Print enter number 2: ");
        value2= consoleScanner.nextInt();
        System.out.print("Print enter number 3: ");
        value3= consoleScanner.nextInt();

        //calculate the average
        average = (value1+ value2+ value3) / 3;
        // Print the average
        System.out.print("\nThe average of the three number is: " + average);
        
        //Closing the Scanner
        consoleScanner.close();

    }

}
