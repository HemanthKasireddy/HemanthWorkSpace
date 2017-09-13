import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumbersRange {
public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	System.out.print("Enter the first number : ");
	int low=scan.nextInt();
	System.out.print("Enter the second number : ");
	int high=scan.nextInt();
	//calling parent class method
	ArrayList<Integer> primeNumbersList=UtilFunctions.primeNumbers(low, high);
	
	for(int primeNumber:primeNumbersList)
		System.out.println("The prime number is:  "+primeNumber);
	scan.close();
}
}
