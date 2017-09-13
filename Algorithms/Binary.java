import java.util.ArrayList;
import java.util.Scanner;

public class Binary {
	//decimal converting
	private static int toDecimal(int binary) {
		  
        int decimal = 0;
        int power = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int tmp = binary%10;
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        return decimal;
		
	}
	//checking number is power of two
	private static boolean isPowerOfTwo(int decimalNumber) {
		if (decimalNumber == 0)
		    return false;
		  while (decimalNumber!= 1)
		  {
		    if (decimalNumber%2 != 0)
		      return false;
		    decimalNumber = decimalNumber/2;
		  }
		return true;
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		try{
			System.out.println("Enter a number: ");
			int number=scan.nextInt();
			
			//Storing result into Array list
			ArrayList<Integer>binaryArrayList=UtilFunctions.convertToBinary(number);
			
			int []binarySwapedArray=new int[binaryArrayList.size()];
			
			//storing Array list values into array in reverse order
			System.out.print("The binary form of \""+number+"\" is :  ");
			for(int index=binaryArrayList.size()-1,i=0;index>=0;index--,i++){
				System.out.print(binaryArrayList.get(index));
				binarySwapedArray[i]=binaryArrayList.get(index);
			}
			
			
			int []swappedArray=new int[binarySwapedArray.length];
		
			//storing left half octal into swapped array 
			
			for(int i=0,j=(binarySwapedArray.length/2);i<swappedArray.length/2;i++,j++){
				swappedArray[i]=binarySwapedArray[j];
			}
			
			//storing right half octal into swapped array 

			for(int i=(swappedArray.length/2),j=0;i<swappedArray.length;i++,j++){
				swappedArray[i]=binarySwapedArray[j];
			}
			/*for (int i=0,j=(binarySwapedArray.length/2)+1;i<(binarySwapedArray.length/2)-1;i++,j++){
				swapedArray[i]= binarySwapedArray[j];
				swapedArray[j]= binarySwapedArray[i];

			}*/
			
		/*	for(int i:swapedArray)
				System.out.print(i+" ");*/
		
			
			/*ArrayList<Integer>swapedList=new ArrayList<Integer>(binaryArrayList.size());
            System.out.println("++++++++++++++156");

			System.out.println(swapedList.size());
			for (int i=0,j=swapedList.size()-1;i<swapedList.size()/2;i++,j--){
				swapedList.add(i, binaryArrayList.get(i));
				swapedList.add(j, binaryArrayList.get(j));

			}
			for(int i:swapedList)
				System.out.println(i+" ");
		
			*/
		
			
			//concatenating all the array elements  
			String s="";
			for(int i=0;i<swappedArray.length;i++)
				s=s+swappedArray[i];
			System.out.println();
			
			//while passing converting into integer
		    int decimalNumber=toDecimal(Integer.parseInt(s));
		    System.out.println("After swapping octals number is: "+decimalNumber);
		  
		  //calling isPowerOfTwo method with argument of Decimal number
		    boolean check= isPowerOfTwo(decimalNumber);
		    if(check==true)
			   System.out.println(decimalNumber+" is power of two");
		    else
			   System.out.println(decimalNumber+" is \" NOT \" a power of two");

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
