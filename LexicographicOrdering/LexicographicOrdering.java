import java.util.Scanner;

public class LexicographicOrdering
{

    public static void main(String[] args)
    {
        String s1, s2, s3, max, med, min;
        Scanner consoleScanner = new Scanner(System.in);

        System.out.println("Please enter 3 strings (in any order):");
        s1 = consoleScanner.next();
        s2 = consoleScanner.next();
        s3 = consoleScanner.next();
        consoleScanner.close();
        max =""; min= ""; med="";
        if (s1.compareTo(s2) <= 0 && s1.compareTo(s3) <= 0){
            min = s1;
            med = (s2.compareTo(s3) <= 0)? s2 : s3;
            max = (s2.compareTo(s3) <= 0)? s3 : s2;
        } else if (s2.compareTo(s1) <= 0 && s2.compareTo(s3) <= 0){
            min = s2;
            med = (s1.compareTo(s3) <= 0)? s1 : s3;
            max = (s1.compareTo(s3) <= 0)? s3 : s1;
        } else if (s3.compareTo(s2) <= 0 && s3.compareTo(s1) <= 0){
            min = s3;
            med = (s1.compareTo(s2) <= 0)? s1 : s2;
            max = (s1.compareTo(s2) <= 0)? s2 : s1;
        }
        System.out.println("\nIn lexicographic ordering, the string you entered are:");
        System.out.println(min + "\n" + med + "\n" + max);
    }

}
