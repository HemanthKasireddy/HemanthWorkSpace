package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class HarmonicSeries {
	
	 public static void main(String [] args) {
	   System.out.println("Enter the number you want: ");
	   Scanner scanner=new Scanner(System.in);
	   int number=scanner.nextInt();
	   if (number!=0)
	     { 
		     double value= Utility.harmonicValue(number);
	         System.out.println();
	         System.out.println("The harmonic value of "+number+" is "+value);
	     } else {
	     
	    	 System.out.println("The harmonic value of "+number+" is not possible");
	     }
	 }
}
