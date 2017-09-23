import java.util.Scanner;

public class AddressBook {
	public static void main(String [] args){
		Person person=new Person();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your choice: ");
		System.out.println("1.Add \n 2. edit \n 3.delete \n 4.sort 5.Person Details");
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
		
		
	}
}
