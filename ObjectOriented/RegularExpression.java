import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegularExpression {
	public static void main(String[] args){
		String message="Hello <<name>>, We have your full name as <<full name>> in our system."
				+ " your contact number is 91-xxxxxxxxxx."
				+ " Please,let us know in case of any clarification"
				+ " Thank you BridgeLabz 01/01/2016.";
		
		Scanner scanner=new Scanner(System.in);
		try{
				System.out.println("Enter your full name as First Name and Last Name: ");
				String name=scanner.nextLine();
				System.out.println("Enter your mobile number: ");
				String mobileNumber=scanner.nextLine();
				
				String []arrayName=name.split(" ");
				message=message.replace("<<name>>", arrayName[0]);
				message=message.replace("<<full name>>", name);
				message=message.replace("xxxxxxxxxx", mobileNumber);
				
			    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			    Date dateobj = new Date();
			    String []today=df.format(dateobj).toString().split(" ");
			    message=message.replace("01/01/2016",today[0]);
		
				System.out.println(message);
		
		}catch(Exception ex){
			ex.getMessage();
		} finally {
			scanner.close();
		}
	}

	
}
