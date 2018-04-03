import java.text.DecimalFormat;
import java.util.Scanner;

public class BasalMetabolicRate
{

    public static void main(String[] args)
    {
        // Step 1: Declare any needed variable

        double weight, height, age, bmrF, bmrM, barsM, barsF;
        Scanner consoleScanner= new Scanner(System.in);
        DecimalFormat noDPs= new DecimalFormat("0");
        DecimalFormat oneDPs= new DecimalFormat("0.0");
        // Step:2 Prompt user for input

        System.out.print("Please enter your weight (lb): ");
        weight= consoleScanner.nextDouble();

        System.out.print("Please enter your height (in): ");
        height= consoleScanner.nextDouble();

        System.out.print("Please enter you age: ");
        age = consoleScanner.nextDouble();

        //Perform calculation
        bmrF= 655 + (4.35*weight) + (4.7* height) - (4.7* age);
        bmrM = 66 + (6.23* weight) + (12.7* height) - (6.8* age);

        //calculating chocolate bars for female and male
        barsF = bmrF/230;
        barsM = bmrM/230;

        System.out.println("\nBMR (female): " + noDPs.format(barsF) + " calories\n"
                + "BMR(male): "+ noDPs.format(barsM) + " calories\n"
                );

        System.out.print("If you are female, you need to consume "+ oneDPs.format(barsF) + " chocolate bars to maintain weight.\n"
                + "If you are male, you need to consume "+ oneDPs.format(barsM)+ " chocolate bars to maintain weight.");

            consoleScanner.close();

    }

}
