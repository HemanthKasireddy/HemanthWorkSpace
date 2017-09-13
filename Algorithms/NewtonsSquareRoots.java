import java.util.Scanner;

public class NewtonsSquareRoots {
public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	try{
		System.out.println("Enter a number to find square root: ");
		double number=scan.nextDouble();
		System.out.println("The square root of "+number+" is "+UtilFunctions.findSquareRoot(number));
		
	}catch(Exception ex){
		
		System.out.println("The \" "+ex+" \" Exception is raised");
		ex.printStackTrace();
	}
	finally{
		scan.close();
	}
}

}
