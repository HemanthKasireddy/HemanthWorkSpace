import java.util.Scanner;

public class GuesserGame {
	public static void main(String[] args){
		try{
			 int num=Integer.parseInt(args[0]);
			 gameStart(num);
		}
		catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		}
}

	private static void gameStart(int num) {
		
		Scanner scan =new Scanner(System.in);
	// calculating number of choices by log function
		int numberOfchoices=(int)((Math.log(num)/Math.log(2)));
		int [] userGuessArray=new int[numberOfchoices];
		try{
				for (int i=0;i<numberOfchoices;i++){
						System.out.print("Enter your number: ");
						int userGuess=scan.nextInt();
						if (userGuess <= num && userGuess > 0){
							System.out.println("The number is in between range: ");
							userGuessArray[i]=userGuess;
						}
						else{
							System.out.println("The number is in not between range: ");
							userGuessArray[i]=userGuess;
		
						}
				}
				int [] sortedArray=UtilFunctions.insertionSortForInteges(userGuessArray);
				int low=0;
				int high=sortedArray.length-1;
			 int loc=	UtilFunctions.binarySearchForIntegers(sortedArray, low, high, num);
			 if (loc==-1)
				 System.out.println("\"your lost:\"");
			  else
				 System.out.println("\"your Won:\"");
			 System.out.print("Your guess are: ");
			 for(int i=0;i<userGuessArray.length;i++)
				 System.out.print(userGuessArray[i]+"  ");
			 System.out.println();
			 System.out.println("The numbers is  :"+num);
		}	
		catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		}
		finally{
			scan.close();
		}
	}
}
