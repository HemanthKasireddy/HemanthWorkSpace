package com.bridgeit.datastrucers.Programs;

import java.util.Arrays;

class PrimeNumberOperations{
	int [][]primeNumbersArray= new int[10][25];
	
	public int[][] primeNumbers(int low, int high){
		int l=0;
		int k=0;
		int m=0;
		for(int i=2;i<high;i++){
			int flag=0;
			for(int j=2;j<=(i/2);j++){
				if(i%j==0){
					flag=1;
					break;
				}
			}if(flag==0){
				k=i/100;
				if(k!=m){
					m=k;
					l=0;
				}
				primeNumbersArray[k][l++]=i;
				
			}
		}
		return primeNumbersArray;
	}
	
	public void printPrimeAnagram(int [][]primeAnagrams){
		System.out.println("*****************Anagramsss are : ");
		for(int i=0;i<primeAnagrams.length;i++){
			for(int j=0;j<primeAnagrams[i].length;j++){
				if(primeAnagrams[i][j]!=0)
					System.out.print(primeAnagrams[i][j]+"\t");
				else
					System.out.print("   "+"\t");
			}System.out.println();
		}
	}
	
	public void printPrimeNonAnagram(int [][]primeNonAnagrams){
		System.out.println("**********************Non Anagramsss");
		for(int i=0;i<primeNonAnagrams.length;i++){
			for(int j=0;j<primeNonAnagrams[i].length;j++){
				if(primeNonAnagrams[i][j]==0)
					System.out.print("");
				else
					System.out.printf(primeNonAnagrams[i][j]+"\t");
			}System.out.println();
		}
	}
	

	
	public int[][] anagramChecking(int[][] primes) {
		
		int primeAnagramsArray[][]= new int[10][8];
		for(int i=0; i<primeNumbersArray.length;i++){
			int a=0;
			for(int j=0;j<primeNumbersArray[i].length;j++){
				if(primeNumbersArray[i][j]==0) {
					break;
				}
				int flag1=0;
				char[] c1=Integer.toString(primeNumbersArray[i][j]).toCharArray();
				char[] c2=Arrays.copyOf(c1, c1.length);
				Arrays.sort(c2);
				
				for(int k=j+1;k<primeNumbersArray[i].length;k++) {
					char[] c3=String.valueOf(primeNumbersArray[i][k]).toCharArray();
					char[] c4=Arrays.copyOf(c3, c3.length);
					Arrays.sort(c4);
					if(Arrays.equals(c2, c4)){
						flag1=1;
						int s=Integer.parseInt(new String(c3));
						primeAnagramsArray[i][a++]=s;
					}
				} if(flag1==1) {
					int s=Integer.parseInt(new String(c1));
					primeAnagramsArray[i][a++]=s;
				}
			}
		}
		return primeAnagramsArray;
	}
	
	public int[][] nonAnagram( int[][] primeAnagramsArray){
		int[][] nonAnagramsArray= new int[10][17];
		for(int i=0;i<primeNumbersArray.length;i++){
			int a=0;
			for(int j=0;j<primeNumbersArray[i].length;j++){
				int flag=0;
				for(int k=0;k<primeAnagramsArray[i].length;k++){
					if(primeNumbersArray[i][j]==primeAnagramsArray[i][k]){
						flag=1;
						break;
					}
				 }if(flag==0) {
					nonAnagramsArray[i][a++]=primeNumbersArray[i][j];
				  }
			}
		}
		return nonAnagramsArray;
	}

}
public class PrimeAnagrams {
	public static void main(String[] args){
		PrimeNumberOperations primeNumberOperations=new PrimeNumberOperations();
		int [][]primes = primeNumberOperations.primeNumbers(0,1000);
		int [][]primeAnagrams = primeNumberOperations.anagramChecking(primes);
		int [][]primeNonAnagrams = primeNumberOperations.nonAnagram(primeAnagrams);
		primeNumberOperations.printPrimeAnagram(primeAnagrams);
		primeNumberOperations.printPrimeNonAnagram(primeNonAnagrams);
		// primeNumberOperations.primeAnagrams();
	}
}
