package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class GamblerGame {
	
	public static void main(String[] args) {
	     Scanner scanner=new Scanner(System.in);
	     try { 
			     System.out.println("Enter The Stack Amount : ");
			     int stack=scanner.nextInt();
			     
			     System.out.println("Enter The Goal Amount : ");
			     int goal=scanner.nextInt();
			     
			     System.out.println("enter the number of times you want play : ");
			     int numberoftimes=scanner.nextInt();
			     
			     Utility.gameStart(stack,goal,numberoftimes);
	     	} catch(Exception ex) {
		    	 System.out.println("The \" "+ex+ "\" Exception is raised");
		     } finally {
		    	 scanner.close();
		     }
	} 
}
