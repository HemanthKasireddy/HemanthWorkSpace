package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class PermutationOfString {
	int c;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter string..");
		String input=sc.next();
		
		System.out.println("possible string by recursion: ");
		Utility.recursion(input, 0, input.length()-1);
		Utility.iteration(input);;
	}
}
