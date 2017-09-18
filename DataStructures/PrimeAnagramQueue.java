package com.bridgeit.datastrucers.Programs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class AnagramQueue{
	
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

	public void generateAnagramQueue(ArrayList<Integer> primeArrayList) {
	
		LinkedList<Integer> queue=new LinkedList<Integer>();
		Iterator<Integer> iterator=null;
		iterator=primeArrayList.iterator();
		while(iterator.hasNext()){
			queue.addLast(iterator.next());
		}
		iterator=queue.iterator();

		while(iterator.hasNext()){
			System.out.println(queue.removeFirst());
		}
	}

}
public class PrimeAnagramQueue {
	public static void main(String[] args){
		AnagramQueue anagramQueue=new AnagramQueue();
		ArrayList<Integer> primeArrayList=anagramQueue.primeNumbers(0, 1000);
		anagramQueue.generateAnagramQueue(primeArrayList);
	}
}
