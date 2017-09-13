
import java.util.ArrayList;
import java.util.Scanner;

 class UtilFunctions {
	
	//prime numbers utility function
	public static ArrayList<Integer> primeNumbers(int low,int high) {
		
		ArrayList<Integer> primeNumbersList=new ArrayList<Integer>();
		
			for(int i = 2; i <=high; i++) {
				
				/*if(i==2){
	        	 primeNumbersArray[index]=i;
	        	 break;
	             }*/
                 boolean isPrime=true;
	             for( int j = 2; j < i; j++){
	             
	                 if(i % j == 0) {
	                 
	                     isPrime=false;
	                 }    
	             }
	             if(isPrime) 
	            	 primeNumbersList.add(i);   
	             
	         }
		return primeNumbersList;
	}
	
	public static ArrayList<Integer> primeNumberPalindrome(int low, int high) {
		//calling prime numbers method
		ArrayList<Integer>primeNumbersList  =primeNumbers(low,high);
		// to store prime palindromes 
		ArrayList<Integer> palindromeList= new  ArrayList<Integer>();
		
		for(int index=0;index<primeNumbersList.size();index++){
			
			int primeNumber=primeNumbersList.get(index);
			// copied number into variable
			
			int palindrome = primeNumber; 
	        int reverse = 0;
	        while (palindrome != 0) {
	            int remainder = palindrome % 10;
	            reverse = reverse * 10 + remainder;
	            palindrome = palindrome / 10;
	        }
	
	        // if original and reverse of number is equal then only
	        // number is palindrome 
	        
	        if (primeNumber == reverse) {
	        	//System.out.println(primeNumber);
	        	palindromeList.add(primeNumber);
	
	        }
		}
		
		return palindromeList;
	}
	//Bubble sort for string 
	public static String bubbleSortForCharacter(String str) {
		char[] charArray = str.toCharArray();

		for(int i=0;i<charArray.length;i++){
			
			boolean isSwaped=false;
			
		   for(int j=0;j<charArray.length-i-1;j++){
		      
			   if (charArray[j] > charArray[j+1]) {
		          
				   char temp = charArray[j];
		           charArray[j]=charArray[j+1];
		           charArray[j+1]=temp;
		           isSwaped=true;
		          
		      }  
		   }
		   if(isSwaped==false)
		    	  break;
		}
		
		//System.out.println(charArray);
		//while returning converting char array to String
		return String.valueOf(charArray);
	}
	//utility function for strings anagram 
	public static boolean checkStringIsAnagram(String str1, String str2) {
	
		 if(str1.length()==str2.length()) {
		 //converting string to  string array 
		 char []charArr1=bubbleSortForCharacter(str1).toCharArray();
		 
		/* for(int i=0;i<charArr1.length;i++)
			 System.out.println(charArr1[i]);*/
		 
		 //converting string to  string array 
		 char []charArr2=bubbleSortForCharacter(str2).toCharArray();
		
		 /*for(int i=0;i<charArr2.length;i++)
			 System.out.println(charArr2[i]);*/
	     for (int i=0;i<charArr1.length;i++) {
	    	 if (charArr1[i]!=charArr2[i])
	    		 return false;
	     }
	     return true;
	 }
	 else
	 return false;
	}
	public static int [] bubbleSortForInteger(int[] unSortedArray){
		//int []primeArray=new int[primeNumbers.size()];
		//primeNumbers.toArray(new int[primeNumbers.size()]);
		for(int i=0;i<unSortedArray.length;i++){
			
			boolean isSwaped=false;
			
		   for(int j=0;j<unSortedArray.length-i-1;j++){
		      
			   if (unSortedArray[j]> unSortedArray[j+1]) {
		          
				   int temp = unSortedArray[j];
				   unSortedArray[j]=unSortedArray[j+1];
				   unSortedArray[j+1]=temp;
		           isSwaped=true;
		          
		      }  
		   }
		   if(isSwaped==false)
		    	  break;
		}
		return unSortedArray;
		
	}
	
	public static String[] bubbleSortForStrings(String [] strArray){

		for(int i=0;i<strArray.length;i++){
			
			boolean isSwaped=false;
			
		   for(int j=0;j<strArray.length-i-1;j++){
		      
			   if (strArray[j].compareTo(strArray[j+1])>0) {
		          
				   String temp = strArray[j];
				   strArray[j]=strArray[j+1];
				   strArray[j+1]=temp;
		           isSwaped=true;
		          
		      }  
		   }
		   if(isSwaped==false)
		    	  break;
		}
		
		return strArray;
	}
	
   
	public static int binarySearchForStrings(String[] SortedString, int low, int high, String userSearchForString) {
		// TODO Auto-generated method stub
          if(high>=low){
			
            int mid = low + (high - low)/2;

            if (SortedString[mid].compareTo(userSearchForString)==0)
            	return mid;
            
            if(SortedString[mid].compareTo(userSearchForString)>0)
            	
            	return binarySearchForStrings(SortedString,low,mid-1,userSearchForString);
            
            return binarySearchForStrings(SortedString,mid+1,high,userSearchForString);
		}
		return -1;

	}

	public static String[] insertionSortForStrings(String[] sortedStringArray) {
		// TODO Auto-generated method stub
		for(int i=1;i<sortedStringArray.length;i++){
			String key=sortedStringArray[i];
			int j=i-1;
			while(j>= 0 && sortedStringArray[j].compareTo(key)>0){
				sortedStringArray[j+1]=sortedStringArray[j];
				j--;
			}
			sortedStringArray[j+1]=key;
		}
		/*for(String i:sortedStringArray)
			System.out.println(i);*/
	return sortedStringArray;
	}

	public static int [] insertionSortForInteges(int[] userArray) {
		// TODO Auto-generated method stub
		for(int i=1;i<userArray.length;i++){
			int key=userArray[i];
			int j=i-1;
			while(j>=0 && userArray[j]>key){
				userArray[j+1]=userArray[j];
				j--;
				
			}
			userArray[j+1]=key;
		}
		return userArray;
	}

	public static int binarySearchForIntegers(int[] userArray,int low,int high, int userSearch) {
		//sorting the user input array 
		
		if(high>=low){
			
            int mid = low + (high - low)/2;

            if (userArray[mid]==userSearch)
            	return mid;
            
            if(userArray[mid]>userSearch)
            	
            	return binarySearchForIntegers(userArray,low,mid-1,userSearch);
            
            return binarySearchForIntegers(userArray,mid+1,high,userSearch);
		}
		return -1;

	}
	
	public static float temperaturConversion(float temperatur, String check){
		if(check=="c"){
		      return (temperatur-32f)*( 5f/9f); 
		}
		else
			{
			return (temperatur*(9f/5f))+32f ;
			}
	}
	 
	public static int findDayOfWeek(int month, int day, int year) {
		int y = year-(14 - month) / 12;
		int x = y + y/4-y/100 + y/400;
		int	m = month + 12 *((14-month) / 12)- 2;
		int	d = (day + x + (31*m)/12)% 7;

		return d;
	}
	
	
	public static double monthlyPayment(double principalAmount, double n, double r) {
		return (principalAmount*r)/(1-Math.pow(1+r, -n));
		
	}
	public static double findSquareRoot(double number) {
		double epsilon=1e-15;
		double temp=number;
		
		while(Math.abs(temp-(number/temp))> epsilon*temp){
			temp=((number/temp)+temp)/2.0;
		}
		return temp;
	}

	public static ArrayList<Integer> convertToBinary(int number) {
		ArrayList<Integer> binaryArray=new ArrayList<Integer>();
		try{
			int remainder=0;
			int temp=number;
			while(number>0){
				
				remainder=number%2;
				binaryArray.add(remainder);
				number=number/2;
				
			}

		}
		catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		}
		return binaryArray;
		
	}
	//*********************************main method

	
		
	//public static void main(String []args) {
			
		/*	Scanner scan=new Scanner(System.in);
			
			//**************prime numbers list 
			
			ArrayList<Integer> primeNumbersList=primeNumbers(0,1000);
			for(Integer primeNumber:primeNumbersList) {
				System.out.println(primeNumber);
			}
			
			//**********String Anagram
			boolean check=checkStringisAnnagram("heart","earth");
			if(check==false)
				System.out.println("given strings are not annagram");
			else
				System.out.println("given strings are  annagram");
			
			
			//************ prime palindrome 
			//passing primeNumbers list 
			 //primeNumberPalindrome(primeNumbersList);
			
			// ******************bubble sort for integers
			int []userArray={10,2,1,6,4,9};
			int[] sortedArray=bubbleSortForInteger(userArray);
			for(int i:sortedArray)
				System.out.println(i);
			//********binary search for Integers
			int []userArray={10,2,1,6,4,9};
			int[] sortedArray=bubbleSortForInteger(userArray);

			int userSearch=scan.nextInt();
			int low=sortedArray[0];
			int high=sortedArray.length;
			int loc=binarySearchForIntegers(sortedArray,low,high-1,userSearch);
			if(loc==-1){
				System.out.println("element not found");

			}
			System.out.println(loc);
			
			//*************insertionSortForInteges
			int []userArray={10,2,1,6,4,9};
			insertionSortForInteges(userArray);
			//**************insertion Sort for Strings
			String [] unSortedStringArray={"hemanth","sunny","kasireddy","reddy","Mr."};
			insertionSortForStrings(unSortedStringArray);
			
			//****************** binary search for strings

			String [] unSortedStringArray={"hemanth","sunny","kasireddy","reddy","Mr."};
			
			System.out.println("Enter the name you want search: ");
			String userSearch=scan.nextLine();
			
			// sorting the strings by using insertion sort technique
			String []sortedArray=insertionSortForStrings(unSortedStringArray);
			
			for(String i:sortedArray)
				System.out.println(i);
			
			int low=0;
			int high=sortedArray.length;
			//calling method for binary search 
			int loc=binarySearchForStrings(sortedArray,low,high-1,userSearch);
			
			if(loc==-1){
				
				System.out.println("name not found");
			}else
			System.out.println("The name position is :"+loc);
		*/
		//}

}
