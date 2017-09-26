package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

public class QuadraticEquation {
	public static int deltaOfEquation(int x,int y,int z) {
		return (y*y-(4*x*z));
	}
	public static void main(String []args) {
		Scanner scan=new Scanner(System.in);
		try {
			
		
				System.out.print("Enter the value of a: ");
				int a=scan.nextInt();
				
				System.out.print("Enter the value of b: ");
				int b=scan.nextInt();
				
				System.out.print("Enter the value of c: ");
				int c=scan.nextInt();
				
				//System.out.println("your quadratic equation is "+a+" X*X "+b+" X "+c);
				int delta=deltaOfEquation(a,b,c);
				//System.out.println(delta);
		        int root1=(-b+(int)Math.sqrt(delta))/(2*a);
		        int root2=(-b-(int)Math.sqrt(delta))/(2*a);
				//System.out.println("The quadratic equation of "+a+" X*X "+b+" X "+c+"roots is:"+root1+" and "+root2);
		        System.out.println("The given quadratic equation roots is: "+root1+" and "+root2);
		}
		catch(Exception ex)
		{
			System.out.println("The \" "+ex+" \" Exception is raised");
		}
		finally {
			scan.close();
		}
	}
}
