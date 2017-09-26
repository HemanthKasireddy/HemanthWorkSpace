package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class LeapYear {
	public static boolean isValidYear(String y)
	{
	  return y.matches("\\d{4}");
	}
	public static void main(String []args) {
		
	   System.out.print("Enter a Year to check to leap year: ");
	   Scanner scanner=new Scanner(System.in);
	   String year=scanner.nextLine();
	   if(isValidYear(year)==true)
	     { 
		   if(Utility.isLeapYear(year))
	        {
	          System.out.println(year+" is leap year");
	        }
	       else
		{
		  System.out.println(year+" is not a leap year");
		}

	     } else {
	    	 
	    	 System.out.println("Please Enter a 4 digit year");  
	     }
	    scanner.close();
	 }
}
