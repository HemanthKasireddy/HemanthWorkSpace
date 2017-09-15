/**
 * @author Hemanth
 * Read .a List of Numbers from a file and arrange it ascending Order in a Linked List. 
 * Take user input for a number, if found then pop the number out of the list else insert the number in appropriate position
 * I/P -> Read from file the list of Numbers and take user input for a new number
 * Logic -> Create a Ordered Linked List having Numbers in ascending order. 
 * O/P -> The List of Numbers to a File.
 */

package com.bridgeit.datastrucers.Programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


class OrderedLinkedList{
	
    private	int userSearch;
    private  String []integersArray=null;
    public OrderedLinkedList(int userSearch) {
    	this.userSearch=userSearch;
	}
 
	// creating a file object using file path

	File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/IntegerSearchFile");
	
    //creating linked list object 
	LinkedList<Integer> linkedList=new LinkedList<Integer>();

	//creating required class objects and initializing with null
	BufferedWriter bufferedWriter=null;
	BufferedReader bufferedReader=null;
	FileWriter fileWriter=null;
	FileReader fileReader=null;
	
	/**
	 * this method for reading file data 
	 * by using of file reader reading data from file putting in to the buffer reader
	 * and reading line by line data from buffer reader 
	 * and splitting data by space and putting into the Integer array
	 */
	public void readingDataFromFile() {

	    try{
	    	//checking file is exist or not
			if (file.exists()) {
				// checking file can have read permission or not
				
				 if(file.canRead()) {
					 
				    	//creating file reader object with parameter of file object 
					    fileReader=new FileReader(file); 
	 
					    // creating bufferedReader object of BufferedReader
					    //reading entire data of file into bufferedReader 
					    bufferedReader=new BufferedReader(fileReader);
					    String s;
					    
					    //reading line by line data  of bufferedReader and storing into string
					    // splitting with space and storing into words array

					    while((s=bufferedReader.readLine())!=null){    	
						       integersArray=s.trim().split(" ");
				        }	
					    
				   } else {
					   System.out.println("you can't read this file");
				  }
				
	         } else {
	      	       System.out.println("File not exists");
	         }
	} catch(Exception ex){
		
		System.out.println("The \" "+ex+" \" Exception is raised");
		ex.printStackTrace();
	}
		
	}
	/**
	 *  This method for creating linked list
	 *  and adding elements form integer array to linked list 
	 *  by using add method  and while adding converting to integer
	 *  because integers Array data is string type
	 */
	public void addingIntegersArrayElementsToLinkedList() {
		// adding data from words array to liked list object
			for( String s:integersArray){
				linkedList.add(Integer.parseInt(s));
			}		
	}
	
	/**
	 * this method for checking the user entry is present in the linked list
	 * if user entry present in the linked list removing that element from list
	 * if element is not there adding that element to linked list
	 * and overwriting previous data on file with linked list data  
	 * by using file writer and buffer writer
	 */
	public void userEntrySearching() {
		  try{
	        	//checking the user entry is present in the linked list
	        	// if exist removing element from linked list
	        	//if it's not there adding to linked list
	        	
					if(linkedList.contains(userSearch)==true){
						linkedList.remove((Integer)userSearch);
						//System.out.println(linkedList.size());
						System.out.println("\" "+userSearch+" \" Element was removed from file");
						
					  }else {
						  linkedList.add(userSearch);
						  //System.out.println(linkedList.size());
						   System.out.println("\" "+userSearch+" \" Element was added to file");
			               Collections.sort(linkedList);
					  }
					
					//taking all the liked list data as a string 
					  String ss="";
					  for(int i:linkedList){
						  ss=ss+" "+i;
					  }
					   //string re writing into the file 
					   fileWriter = new FileWriter(file);
					   bufferedWriter = new BufferedWriter(fileWriter);
					   bufferedWriter.write(ss);
					   bufferedWriter.flush();
					   bufferedWriter.close();
					   
	            }catch(Exception ex){
				
				    System.out.println("The \" "+ex+" \" Exception is raised");
				    ex.printStackTrace();
			}
		
	}
	/**
	 * this method for displaying file data to user screen 
	 * by using of file reader reading a data from file putting in to the buffer reader
	 * and reading line by line data from buffer reader 
	 */
	public void displayingListWords() {
		try{
			
			if(file.canRead()) {
					fileReader=new FileReader(file);
					bufferedReader=new BufferedReader(fileReader);
					String s;
					while((s=bufferedReader.readLine())!=null){
						 System.out.println(s);	
						}
			 } else {
				
					   System.out.println("you can't read this file");
				    }
	     }catch(Exception ex){
				
				System.out.println("The \" "+ex+" \" Exception is raised");
				ex.printStackTrace();
			}
		finally{
			try{
				fileReader.close();
				bufferedReader.close();
				fileWriter.close();
				bufferedWriter.close();
			}catch(Exception ex){
				
				System.out.println("The \" "+ex+" \" Exception is raised");
				ex.printStackTrace();
			}
		}
	
		
	}
	
}

public class OrderedList {
 
public static void main(String []args){
	  Scanner scanner=new Scanner(System.in);
	 try {
		 
		  System.out.println("Enter the integer element want to serach: ");
		  int userSearch=scanner.nextInt();
		  OrderedLinkedList orderedLinkedList=new OrderedLinkedList(userSearch);
		  orderedLinkedList.readingDataFromFile();
		  orderedLinkedList.addingIntegersArrayElementsToLinkedList();
		  orderedLinkedList.userEntrySearching();
		  orderedLinkedList.displayingListWords();
        }catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
}

}
