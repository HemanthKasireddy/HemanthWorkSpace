import java.util.ArrayList;
import java.util.Scanner;

public class BinaryConverter {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		try{
			System.out.println("Enter a number: ");
			int number=scan.nextInt();
			
			ArrayList<Integer>binaryArrayList=UtilFunctions.convertToBinary(number);
			System.out.print("The binary form of \""+number+"\" is :  ");
			for(int index=binaryArrayList.size()-1;index>=0;index--)
				System.out.print(binaryArrayList.get(index));
		}
		catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		}
	}

}
