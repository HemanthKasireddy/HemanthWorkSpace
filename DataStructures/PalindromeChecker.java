package com.bridgeit.datastrucers.Programs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class StringPalindromeChecker{
	private String userString;
	private String popingString="";
	Deque<Character> deque=new ArrayDeque<Character>();
	
	public StringPalindromeChecker(String userString) {
		this.userString=userString;
	}

	/**
	 * 
	 * this method for extracting characters from string 
	 * and pushing in to the dequeue by the rare end.
	 * pushing rare end by using addLast method
	 * 
	 */
	public void pushingElementsDequeRare() {
		try {
		
				for(int i=0;i<userString.length();i++){
					deque.addLast(userString.charAt(i));
				}
				//System.out.println(deque);
		}catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * this method for removing dequeue elements by the rare end
	 * by using remove last method and concatenating with popingString
	 * 
	 */
	public void popingElementsDequeRare() {
		try {
			//System.out.println(deque.size());
			while(!deque.isEmpty()){
				popingString=popingString+deque.removeLast();
			}
		}catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * checking  popingString and userString are equals by using equals method
	 * if both strings are same the given string is palindrome 
	 * else not a palindrome
	 * 
	 */
	public void isStringPalindrome() {
           if(userString.equals(popingString)){
        	   System.out.println("Given string is palindrome: ");
           } else {
        	   System.out.println("Given string is not palindrome: ");
           }
	}
	
}
public class PalindromeChecker {
	public static void main(String []args) {
		Scanner scanner =new Scanner(System.in);
		try {
			
			System.out.println("Enter a string :");
			String userString=scanner.nextLine();
			StringPalindromeChecker stringPalindromeChecker=new StringPalindromeChecker(userString);
			stringPalindromeChecker.pushingElementsDequeRare();
			stringPalindromeChecker.popingElementsDequeRare();
			stringPalindromeChecker.isStringPalindrome();
			
		} catch(Exception ex) {
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}

}
