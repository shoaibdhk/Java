import java.util.Scanner;

public class BirthdayWizard
{

    public static void main(String[] args)
    {
        int year, age, futureage, futureyear;
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Please enter your birth year...");
        year= consoleScanner.nextInt();
        age= 2018- year;
        System.out.println("Your age " + age + " years old\n");
        System.out.println("Please enter a future age...");
        futureage = consoleScanner.nextInt();
        futureyear= year + futureage;

        System.out.println("You will be "+ futureage+ " in the year "+ futureyear + ".");

        consoleScanner.close();
    }

}
