/**
 * @author Hemanth
 *  Desc -> Create a Slot of 10 to store Chain of Numbers that belong to each Slot
 *   to efficiently search a number from a given set of number
 *  I/P -> read a set of numbers from a file and take user input to search a number
 *  Logic ->  user entry  is found then pop it or else push it .
 *  Use Map of Slot Numbers and Ordered LinkedList to solve the problem. 
 * O/P -> Save the numbers in a file
 *
 */
package com.bridgeit.datastrucers.Programs;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgeit.datastrucers.Utility.Utility;

public class HashingFunction {
	
	public static void main (String[] args) {
		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/HashingSearchFile");

		Scanner scanner =new Scanner(System.in);
		try{
			 System.out.println("Enter the number to search : ");
			 String userSearch=scanner.nextLine();
			 		     
			 String []integersArray =Utility.readingDataFromFile(file);
			 HashMap<Integer,String> map= Utility.addingArrayElemntsToMap(integersArray);
			 LinkedList<String> linkedList=  Utility.addingMapElementsToLinkedList(map);
		     Utility.userEntrySearching(file,linkedList,userSearch); 
		     Utility.displayingListWords(file);
			  
		} catch(Exception ex) {
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
