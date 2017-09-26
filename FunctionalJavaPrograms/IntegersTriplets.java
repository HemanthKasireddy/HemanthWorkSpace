package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class IntegersTriplets {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter The number of elements you want: ");
		
		//Storing user input to numberOfElements
		int numberOfElements=scanner.nextInt();
		
		//creating tripletsArray with size of user input choice
		int []tripletsArray=new int[numberOfElements];
		
		//Inserting user elements to triplets array
		for (int i=0;i<numberOfElements;i++) {
			
			System.out.print("Enter element you want: ");
			tripletsArray[i]=scanner.nextInt();
		}
		Utility.getTriplets(tripletsArray);
		scanner.close();
   }
		
}
