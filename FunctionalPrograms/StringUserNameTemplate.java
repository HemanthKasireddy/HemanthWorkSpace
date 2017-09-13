import java.util.*;

class StringUserNameTemplate  {

public static void main(String []args)

 {  
     System.out.println("Enter User Name");
     Scanner scan=new Scanner(System.in);
     String username=scan.nextLine();
     if (username.length() >= 3) 
      {
	    	 System.out.println("Hello "+username+" hi, how are you");
      } 
     else
     {
	    	 System.out.println("User Name sholud be minimum 3 characters");
      }
 }


}
