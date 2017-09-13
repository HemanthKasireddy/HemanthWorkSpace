import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args){
		int []noteArray={1,2,5,10,50,100,500,1000};
		int noteArrayLength=noteArray.length;
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter how much change want: ");
		int userAmount=scan.nextInt();
	System.out.println(	changeRequired(noteArray,noteArrayLength,userAmount));
		
	}

	private static long changeRequired(int[] noteArray, int noteArrayLength, int userAmount) {
	if(userAmount==0)
		return 0;
	// Initialize result
	long res = Long.MAX_VALUE;
	
	// Try every coin that has smaller value than V
	for (int i=0; i<noteArrayLength; i++)
	{
		if (noteArray[i] <= userAmount)
		{
			long sub_res = changeRequired(noteArray,noteArrayLength, userAmount-noteArray[i]);
	
			// Check for INT_MAX to avoid overflow and see if
			// result can minimized
			if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
				res = sub_res + 1;
		}
	}
	return res;
	
	}


}
