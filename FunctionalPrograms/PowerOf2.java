//import java.util.Scanner;
class PowerOf2
{
 public static void main(String[] args)
 {
   //System.out.print("Entar up to where want power of 2 valuse: ");
   //Scanner scan=new Scanner(System.in);
   //int N=scan.nextInt();
     int N=Integer.parseInt(args[0]);
     if (N >=0 && N <31)
	 {
	   for (int i=0;i<=N;i++)
	    {
	       	  System.out.println("2 to the power of "+i+ " is  "+(int)Math.pow(2,i));
	     }
	 }
     else
         System.out.println("please enter below 31");
 }

}
