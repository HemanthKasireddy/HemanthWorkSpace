package com.bridgeit.datastrucers.Programs;

import java.util.ArrayList;
import java.util.Iterator;

class PrimeNumbersArray{
	
public  ArrayList<Integer> primeNumbers(int low,int high) {
		
		ArrayList<Integer> primeNumbersList=new ArrayList<Integer>();
		
			for(int i = 2; i <=high; i++) {
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
	public void printArray(	ArrayList<Integer> arrayList){
		int [][]integerArray=new int[10][25];
		Iterator<Integer> iterator=arrayList.iterator();
	    int k=0;
        int l=0;
        int m=0;

        while(iterator.hasNext()){
        	int temp=iterator.next();                    
        	k=temp/100;
        	if(k!=m){
        		m=k;
        		l=0;
        	}
        	integerArray[k][l++]=temp;	  
		}
        for(int ii[]:integerArray){
        	for(int j:ii){
        		if(j==0){
                	System.out.print("  ");
                	continue;
        		}
        	    System.out.printf("%5d",j);
        	}
        	System.out.println();
        }	
	}
}


public class Prime2DGreedyArray {
	public static void main(String []args){
		PrimeNumbersArray primeNumbersArray=new PrimeNumbersArray();
		ArrayList<Integer> arrayList=primeNumbersArray.primeNumbers(0,1000);
		primeNumbersArray.printArray(arrayList);
	}
}
