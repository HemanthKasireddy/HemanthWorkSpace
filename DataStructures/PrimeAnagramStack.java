package com.bridgeit.datastrucers.Programs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class AnagramStack{
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

	public void generateAnagramStack(ArrayList<Integer> primeArrayList) {
		
		LinkedList<Integer> stack=new LinkedList<Integer>();
		Iterator<Integer> iterator=null;
		iterator=primeArrayList.iterator();
		while(iterator.hasNext()){
			stack.addFirst(iterator.next());
		}
		iterator=stack.iterator();

		while(iterator.hasNext()){
			System.out.println(stack.removeFirst());
		}
		
	}
		
}
public class PrimeAnagramStack {
	public static void main(String[] args){
		AnagramStack anagramStack=new AnagramStack();
		ArrayList<Integer> primeArrayList=anagramStack.primeNumbers(0, 1000);
		anagramStack.generateAnagramStack(primeArrayList);
	}
}
