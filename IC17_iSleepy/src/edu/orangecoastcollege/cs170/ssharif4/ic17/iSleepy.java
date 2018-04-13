package edu.orangecoastcollege.cs170.ssharif4.ic17;

import java.util.Scanner;

public class iSleepy {
	public static int SIZE =7;
	public static void main(String[] args) {
		
		double[] hoursSlept = new double[SIZE];
		double average, total = 0.0;
		//Variables to store rec, app, notrec
		int rec=0, app=0, notRec=0;
		Scanner scnr = new Scanner(System.in);
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saterday"};
		
		for (int i =0; i < days.length; i++) {
			System.out.print("Enter the number of hours slept on " + days[i] + ":");
			hoursSlept[i] = scnr.nextDouble();
			if(hoursSlept[i]>=7 && hoursSlept[i]<=9) 
				rec++;
			else if ((hoursSlept[i]>=6 && hoursSlept[i]<7) || (hoursSlept[i]>=10 && hoursSlept[i]<=11))
					app++;
			else
				notRec++;
			
			total += hoursSlept[i];
			
		}
		scnr.close();
		average = total/ days.length;
		
		System.out.println();
		System.out.println("Total number of hours slept last week : " + total);
		System.out.println("Average number of hours slept per night: " + average);
		System.out.println("\nAccording to the NSF, last week, you slept:\n");
		System.out.println(rec + ((rec==1)? " night ":" nights ") + "of \"recommended\" sleep.");
		System.out.println(app + ((app==1)? " night ":" nights ") + "of \"recommended\" sleep.");
		System.out.println(notRec + ((notRec==1)? " night ":" nights ") + "of \"recommended\" sleep.");
		
	}

}
