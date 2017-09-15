/**
 * 
 * @author Hemanth
 * Desc -> Read the Text from a file, split it into words and arrange it as Linked List.
 *  Take a user input to search a Word in the List. If the Word is not found then add it to the list,
 *  and if it found then remove the word from the List. In the end save the list into a file
 * I/P -> Read from file the list of Words and take user input to search a Text
 * O/P -> The List of Words to a File.
 *
 */
package com.bridgeit.datastrucers.Programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;


class UnOrderLinkedList  {
	// creating a file object using file path
    File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/WordsSearchFile");
    
    //creating linked list object 
	LinkedList<String> linkedList=new LinkedList<String>();
	
	//creating required class objects and initializing with null
	BufferedWriter bufferedWriter=null;
	BufferedReader bufferedReader=null;
	FileWriter fileWriter=null;
	FileReader fileReader=null;
    private  String []wordsArray=null;
   
    private String userSearch;

	//allocating data to object using constructor
	public UnOrderLinkedList(String userSearch) {
	
		this.userSearch=userSearch;
	}
	/**
	 * this method for reading file data 
	 * by using of file reader reading data from file putting in to the buffer reader
	 * and reading line by line data from buffer reader 
	 * and splitting data by space and putting into the Words array
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
					    	
					    	wordsArray=s.trim().split(" ");
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
	 *  and adding elements form words array to linked list 
	 *  by using add method
	 */
	public void addingWordsArrayElementsToLinkedList() {
	//System.out.println(words.length);
	// adding data from words array to liked list object
		for(String word:wordsArray){
			linkedList.add(word);
		}
		
	}
	/**
	 * this method for checking the user entry is present in the linked list
	 * if user entry present in the linked list removing that element from list
	 * if element is not there adding that element to linked list
	 * and overwriting previous data on file with linked list data  
	 * by using file writer and buffer writer
	 */
   // method for searching user entry is present or not
	public void userEntrySearching()  {
        try{
        	//checking the user entry is present in the linked list
        	// if exist removing element from linked list
        	//if it's not there adding to linked list
        	
				if(linkedList.indexOf(userSearch)>=0){
					linkedList.remove(userSearch);
					//System.out.println(linkedList.size());
					System.out.println("\" "+userSearch+" \" Element was removed from file");
					
				  }else {
					  linkedList.add(userSearch);
					  //System.out.println(linkedList.size());
					   System.out.println("\" "+userSearch+" \" Element was added to file");
		
				  }
				
				//taking all the liked list data as a string 
				  String string="";
				  for(String word:linkedList){
					  string=string+" "+word;
				  }
				//string re writing into the file 
				   fileWriter = new FileWriter(file);
				   bufferedWriter = new BufferedWriter(fileWriter);
				   bufferedWriter.write(string);
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
public class UnOrderedList {
	
	public static void main (String []args){ 
		
		Scanner scanner=new Scanner(System.in);
		try{
		
			System.out.println("Enter the string you want to search");
			String userSearch=scanner.nextLine();
			// creating object UnOrderLinkedList class
			UnOrderLinkedList unOrderLinkedList=new UnOrderLinkedList(userSearch);
			
			// using object of UnOrderLinkedList calling UnOrderLinkedList objects

			unOrderLinkedList.readingDataFromFile();
			unOrderLinkedList.addingWordsArrayElementsToLinkedList();
			unOrderLinkedList.userEntrySearching();
			unOrderLinkedList.displayingListWords();
			
		}catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		} finally{
			scanner.close();
		}
	} 
} 