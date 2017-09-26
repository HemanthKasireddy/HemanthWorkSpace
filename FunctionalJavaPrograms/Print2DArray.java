package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class Print2DArray {
	

	 public static void main(String[]args)
	 {
	   Scanner scanner=new Scanner(System.in);
	   System.out.print("Enter number of rows: ");
	   int rows=scanner.nextInt();
	   System.out.print("Enter number of columns: ");
	   int colomns=scanner.nextInt();
	   
	   Utility.print2DArray(rows,colomns);
	   scanner.close();
	 }
}
