package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

public class StringUserNameTemplate {
	public static void main(String []args)

	 {  
	     System.out.println("Enter User Name");
	     Scanner scanner=new Scanner(System.in);
	     String username=scanner.nextLine();
	     if (username.length() >= 3) 
	      {
		    	 System.out.println("Hello "+username+" hi, how are you");
	      } 
	     else
	     {
		    	 System.out.println("User Name sholud be minimum 3 characters");
	      }
	     scanner.close();
	 }
}
