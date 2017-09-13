import java.util.*;
import java.util.regex.*;
class LeapYear
{
public static boolean isValidYear(String y)
{
  return y.matches("\\d{4}");
}
 public static void main(String []args)
 {
   System.out.print("Enter a Year to check to leap year: ");
   Scanner scan=new Scanner(System.in);
   String year=scan.nextLine();
   if(isValidYear(year)==true)
     {
       if (Integer.parseInt(year)%4==0) 
        {
          System.out.println(year+" is leap year");
        }
       else
	{
	  System.out.println(year+" is not a leap year");
	}

     }
   else
    System.out.println("Please Enter a 4 digit year");  
 }
} 
