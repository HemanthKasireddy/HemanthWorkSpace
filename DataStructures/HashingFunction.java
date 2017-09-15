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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


class SearchingWordInFile{
	
	private int userSearch;
	
	public SearchingWordInFile(int userSearch) {
		this.userSearch=userSearch;
	}
	
	File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/HashingSearchFile");
	
    //creating linked list object 
	LinkedList<Integer> linkedList=new LinkedList<Integer>();
   
	Map<Integer,String> map=new HashMap<Integer,String>();

	//creating required class objects and initializing with null
	String []integersArray=null;
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

	    try {
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
	 *  This method for adding elements to Map 
	 *  and adding elements form integer array to Map 
	 *  by using put method  
	 */
	
	public void addingArrayElemntsToMap(){
		for(int i=0;i<integersArray.length;i++){
				map.put(i, integersArray[i]);
		}
	}
	
	/**
	 *  This method for adding elements to linked list
	 *  and adding elements form Map to linked list 
	 *  by using add method  and while adding converting to integer
	 *  because in Map data is string type
	 */
	
	public void addingMapElementsToLinkedList() {
		// adding data from words array to liked list object
			for( String s:map.values()) {
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
		  try {
	        	//checking the user entry is present in the linked list
	        	// if exist removing element from linked list
	        	//if it's not there adding to linked list
	        	
					if(linkedList.contains(userSearch)==true) {
						
						linkedList.remove((Integer)userSearch);
						//System.out.println(linkedList.size());
						System.out.println("\" "+userSearch+" \" Element was removed from file");
						
					  } else {
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
					   
	            } catch(Exception ex) {
				
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
		try {
			
			if(file.canRead()) {
					fileReader=new FileReader(file);
					bufferedReader=new BufferedReader(fileReader);
					String s;
					while((s=bufferedReader.readLine())!=null) {
						
						 System.out.println(s);	
						
						}
			 } else {
				
					   System.out.println("you can't read this file");
				    }
	     } catch(Exception ex) {
				
				System.out.println("The \" "+ex+" \" Exception is raised");
				ex.printStackTrace();
			} finally {
				 try {
						fileReader.close();
						bufferedReader.close();
						fileWriter.close();
						bufferedWriter.close();
				} catch(Exception ex) {
					
					System.out.println("The \" "+ex+" \" Exception is raised");
					ex.printStackTrace();
				}
		}
		
	}
}



public class HashingFunction {
	
	public static void main (String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		try{
			 System.out.println("Enter the number to search : ");
			 int userSearch=scanner.nextInt();
			 
		     SearchingWordInFile searchingwordInFile=new SearchingWordInFile(userSearch);
		     
		     searchingwordInFile.readingDataFromFile();
		     searchingwordInFile.addingArrayElemntsToMap();
		     searchingwordInFile.addingMapElementsToLinkedList();
		     searchingwordInFile.userEntrySearching(); 
		     searchingwordInFile.displayingListWords();
			  
		} catch(Exception ex) {
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
