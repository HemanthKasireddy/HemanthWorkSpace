import java.util.ArrayList;
import java.util.Scanner;

public class PrimePalindrome {
	
	public static void main(String []args){
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Enter the first number : ");
		int low=scan.nextInt();
		System.out.print("Enter the second number : ");
		int high=scan.nextInt();
		
		ArrayList<Integer> primePalindromeList=UtilFunctions.primeNumberPalindrome(low,high);
		for(int primePalindrome:primePalindromeList)
			System.out.println("The prime palindrome is:  "+primePalindrome);
		scan.close();
	}

}
