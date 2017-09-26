package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class PrimeFactorization {
	
	  public static void main(String[] args)
	   {
	     System.out.print("Enter a number: ");
	     Scanner scanner=new Scanner(System.in);
	     int number=scanner.nextInt();
	     Utility.primeFactors(number);
	     scanner.close();
	   }
}
