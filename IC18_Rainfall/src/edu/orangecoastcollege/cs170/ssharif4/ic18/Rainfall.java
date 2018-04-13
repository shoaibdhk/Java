package edu.orangecoastcollege.cs170.ssharif4.ic18;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Rainfall {
	public static final int SIZE =12;
	public static void main(String[] args) {
		//Declare all the variable
		
		String[] months = {"January", "February", "March", "April", "May", "June", 
				"July", "August", "September", "October", "November", "December"};
		
		double[] rainfallInches = new double[SIZE];
		double total=0.0, average=0.0;
		Scanner consoleScanner = new Scanner(System.in);
		DecimalFormat twoDPs = new DecimalFormat("0.00");
		
		for(int i = 0; i< months.length ; i++) {
			System.out.print("\nEnter rainfall amount (in inches) for " + months[i] + " >> ");
			rainfallInches[i] = consoleScanner.nextDouble();
			
			total += rainfallInches[i];
		}
		consoleScanner.close();
		average = total / months.length;
		Arrays.sort(rainfallInches);
		
		System.out.println("\nTotal Rainfall for the year (in inches): " + twoDPs.format(total) + 
				"\nAverage Rainfall for the Year (in inches): " + twoDPs.format(average)
				+"\nMinimum Monthly rainfall (in inches): " + twoDPs.format(rainfallInches[0])
				+"\nMaximum Monthly rainfall (in inches): " + twoDPs.format(rainfallInches[rainfallInches.length-1]));
		
		
		

	}

}
