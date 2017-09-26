package com.bridgeit.JavaAlgorithmPrograms.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Utility {
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
	private static int toDecimal(int binary) {
		  
        int decimal = 0;
        int power = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int temp = binary%10;
                decimal += temp*Math.pow(2, power);
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
	private static int [] padding(int[] binaryArrayList) {

		int paddingZeros=8-binaryArrayList.length;
		int []paddingArray=new int[8];
	
		for(int i=paddingZeros,j=0;i<paddingArray.length;i++,j++) {
			paddingArray[i]=binaryArrayList[j];
		}
		return paddingArray;
	}
	public static void printBinaryArray(ArrayList<Integer> binaryArrayList, int number) {
		
		
		int []binarySwapedArray=new int[binaryArrayList.size()];
		
		//storing Array list values into array in reverse order
		System.out.print("The binary form of \""+number+"\" is :  ");
		for(int index=binaryArrayList.size()-1,i=0;index>=0;index--,i++) {
			System.out.print(binaryArrayList.get(index));
			binarySwapedArray[i]=binaryArrayList.get(index);
		}
		System.out.println();
		int []paddingArray=padding(binarySwapedArray);

		int []swappedArray=new int[paddingArray.length];
		System.out.print("After padding binary form is: ");
		
		for(int i:paddingArray) {
		 System.out.print(i);
	    }
		//storing left half octal into swapped array 
		
		for(int i=0,j=(paddingArray.length/2);i<swappedArray.length/2;i++,j++) {
			swappedArray[i]=paddingArray[j];
		}
		
		//storing right half octal into swapped array 

		for(int i=(swappedArray.length/2),j=0;i<swappedArray.length;i++,j++) {
			swappedArray[i]=paddingArray[j];
		}
		System.out.println();
		String s="";
		for(int i=0;i<swappedArray.length;i++) {
			s=s+swappedArray[i];
		}
		System.out.print("After swaping octals binary form is :");
		System.out.println(s);
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
	

	public static void mergeStrings(String [] unSortedStringArray,int low,int mid,int high){
		
		int leftLength=mid-low+1;
		int rightLength=high-mid;
		int k=low;
		//temp arrays to sore data in unSortedStringArray 
		String []leftArray=new String[leftLength];
		String []rightArray=new String[rightLength];
		//copying data to arrays
		for (int i=0; i<leftLength; ++i)
		 leftArray[i] = unSortedStringArray[low + i];
		for (int j=0; j<rightLength; ++j)
    	 rightArray[j] = unSortedStringArray[mid + 1+ j];
    
		int i=0,j=0;
		//merging temp arrays 
		while( i < leftLength && rightLength > j ){
    	 
			if( rightArray[j].compareTo(leftArray[i])>=0){
    		 
				unSortedStringArray[k]=leftArray[i];
				i++;
    		 
			} else {
    	    	 unSortedStringArray[k]=rightArray[j];
    	    	 j++;
    	     }
    	 k++;
     }
     //Copy remaining elements of leftArray
     while (i < leftLength)
     {
    	 unSortedStringArray[k] = leftArray[i];
         i++;
         k++;
     }

     //Copy remaining elements of rightArray

     while (j < rightLength)
     {
    	 unSortedStringArray[k] = rightArray[j];
         j++;
         k++;
     }
    
	}
	public static void sortStrings(String[] unSortedStringArray,int low,int high){
		
		 int mid = low + (high - low) / 2;
		 
		 if(low<high){
		     //recursion algorithm
			 sortStrings(unSortedStringArray,low,mid);
			 sortStrings(unSortedStringArray,mid+1,high);
			 mergeStrings(unSortedStringArray,low,mid,high);
			
		 }
	}
	private static int oneCount,twoCount,fiveCount,tenCount,fiftyCount,hundredCount,fiveHundredCount,thousundCount;

	public static void changeRequired(int userAmount) {

	    try{

			//storing notes according to notes name and values
			LinkedHashMap<String,Integer> mapChange=new LinkedHashMap<String,Integer>();
			// using recursion technique to denomination of money
			
			if(userAmount>=1000){
				userAmount-=1000;
				thousundCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=500){
				userAmount-=500;
				fiveHundredCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=100){
				userAmount-=100;
				hundredCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=50){
				userAmount-=50;
				fiftyCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=10){
				userAmount-=10;
				tenCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=5){
				userAmount-=5;
				fiveCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=2){
				userAmount-=2;
				twoCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=1){
				userAmount-=1;
				oneCount++;
				changeRequired(userAmount);
			}
			else{
				    // when denomination is 0 then it  will enter the else block 
				    // putting the all the values in to linkedHashMap according to key-value pair
					mapChange.put("five hundred",fiveHundredCount);
					mapChange.put("thousund", thousundCount);
					mapChange.put("hundred",hundredCount);
					mapChange.put("fifty",fiftyCount);
					mapChange.put("ten",tenCount);
					mapChange.put("five",fiveCount);
					mapChange.put("two",twoCount);
					mapChange.put("one",oneCount);
					
					//removing all the keys with have 0's by using singleton()
					//singleton() will return all the matching values of 0's and remove all remove those values keys in map
					mapChange.values().removeAll(Collections.singleton(0));
				    System.out.println("minimum " + mapChange.size()+" types of notes are required");
				    //taking the all keys in map by using keySet() and adding into set
					Set<String> keys = mapChange.keySet();
			        for(String k:keys){
			            System.out.println(k+"'s notes "+mapChange.get(k)+" are required");
		             }
			}
		}
		 catch(Exception ex){
				
				System.out.println("The \" "+ex+" \" Exception is raised");
				System.out.println("Exception Details are: ");

				ex.printStackTrace();
			}
	}

	public static void gameStart(int[] UserGuesses, int low, int high) {

		Scanner scanner= new Scanner(System.in);
		try {
			 if(high<low) {
				 System.out.println("number NOT found");
				 System.exit(0);
			 }
			 int mid=(low+high)/2;
			 System.out.println("Is your number "+UserGuesses[mid]);
			 System.out.println("choose you choice: ");
		     System.out.println(" 1. for yes\n 2 .if your number is smaller\n 3. if its greater");
			 int response= scanner.nextInt();
			
			 if(response==1) {
				 System.out.println(UserGuesses[mid] +" is your number");
				 System.exit(0);
			 } else if(response==2) {
        	
				 gameStart(UserGuesses,low,(mid-1));
			 } else {
				 gameStart(UserGuesses,(mid+1),high);
              }
		System.out.println();	 
			 
       } catch(Exception ex) {
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		}
		finally{
			scanner.close();
		}
	}	

}
