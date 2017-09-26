package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class CoinFlip {
	public static void main(String []args)
	  {
		Scanner scanner=new Scanner(System.in);
	    System.out.print("Enter the number of times to flip to coin: ");
	    int flipcount=scanner.nextInt();
	    Utility.coinGameStart(flipcount);
	    scanner.close();
	  }   
}
