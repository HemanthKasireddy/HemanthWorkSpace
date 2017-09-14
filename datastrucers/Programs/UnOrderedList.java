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
	
	//creating required class objects and intialzing with null
	BufferedWriter bufferedWriter=null;
	BufferedReader bufferedReader=null;
	FileWriter fileWriter=null;
	FileReader fileReader=null;
    String []words=null;
   
    String userSerach;

	//UnOrderLinkedList is a constructor to allocate data for object
	public UnOrderLinkedList(String userSerach) {
	
		this.userSerach=userSerach;
	}
	//method for reading data from file and storing into linked list
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
					    	
						words=s.split(" ");
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


	public void createLinkedList() {
	//System.out.println(words.length);
	// adding data from words array to liked list object
		for(String s:words){
			linkedList.add(s);
		}
		
	}

   // method for searching user entry is present or not
	public void userEntrySearching()  {
        try{
        	//checking the user entry is present in the linked list
        	// if exist removing element from linked list
        	//if it's not there adding to linked list
        	
				if(linkedList.indexOf(userSerach)>=0){
					linkedList.remove(userSerach);
					//System.out.println(linkedList.size());
					System.out.println("\" "+userSerach+" \" Element was removed from list");
					
				  }else {
					  linkedList.add(userSerach);
					  //System.out.println(linkedList.size());
					   System.out.println("\" "+userSerach+" \" Element was added to list");
		
				  }
				
				//taking all the liked list data as a string 
				  String ss="";
				  for(String s:linkedList){
					  ss=ss+" "+s;
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
	
    //displaying the file data to user screen 
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
			String userSerach=scanner.nextLine();
			// creating object UnOrderLinkedList class
			UnOrderLinkedList unOrderLinkedList=new UnOrderLinkedList(userSerach);
			
			// using object of UnOrderLinkedList calling UnOrderLinkedList objects

			unOrderLinkedList.readingDataFromFile();
			unOrderLinkedList.createLinkedList();
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