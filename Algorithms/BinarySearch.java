import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearch {
public static void main(String [] args){
	File file=new File("BinarySearchFile.txt");
	
	FileWriter fw=null;
	FileReader fr=null;
	BufferedReader br=null;
	String []words=null;
	Scanner scan=new Scanner(System.in);
	try {
			if (file.exists()){
				
				if (file.canWrite()){
			
					 fw=new FileWriter(file);
					 fw.write("hi,hello,this,is,hemanth,kasireddy,nice,to,meet,you,i,hope,your,good,thanks");
					 fw.flush();
					 fw.close();
		        }else
			         System.out.println("you can't write in this file");
				
				 if(file.canRead()){
				
					fr=new FileReader(file);
					br=new BufferedReader(fr);
					String s;
					while((s=br.readLine())!=null){
						//System.out.println(s);
						words=s.split(",");
					}	
					/*for(String ss:words)
						System.out.println(ss);*/
				 }else
				
					System.out.println("you can't read this file");
				
				
	         }else
	        	 System.out.println("File not exists");
			
			 System.out.println("Enter The word you want to search: ");
			 String usersearch=scan.nextLine();
			 String [] sortedArray=UtilFunctions.insertionSortForStrings(words);
			 int low=0;
			 int high=sortedArray.length;
			 int check=UtilFunctions.binarySearchForStrings(sortedArray, low, high, usersearch);
			 if(check==-1){
				 System.out.println("Word is not found");
           }else
    	    System.out.println("Word is found");
	    } catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
finally{
	try {
		fw.close();
		fr.close();
		br.close();
		scan.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
}
