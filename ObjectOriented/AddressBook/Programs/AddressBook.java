package com.bridgeit.HemanthJava.Programs;
import java.util.Scanner;

import com.bridgeit.HemanthJava.Utility.Person;

public class AddressBook {
	
	public static void main(String [] args){
		Person person=new Person();
		Scanner scanner=new Scanner(System.in);
		boolean check=true;
		do{
			
		
		System.out.println(" 1.Add \n 2. edit \n 3.delete \n 4.sort \n 5.Person Details");
		System.out.println("Enter your choice: ");
		int choice=scanner.nextInt();
		switch(choice) {
		case 1 : person.addPerson();
				 break;
		case 2 : person.editPerson();
				 break;
		case 3 : person.deletePerson();
				 break;
		case 4 : person.sortDetails();
				 break;
		case 5 : person.personDetails();
		         break;			 
		default: System.out.println("Wrong choice: ");
		
		
		}
		System.out.println();
		System.out.println("You want continue again press \"Y\" else press \"N\"");
		 String innerChoice=scanner.next().toLowerCase();
		 if(innerChoice.equals("y")){
		check=true;
		}else {
			check=false;
		}
	}while(check);
}
}