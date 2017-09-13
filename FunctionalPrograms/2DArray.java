import java.util.Scanner;
import java.io.*;

class Print2DArray
{
 public static void main(String[]args)
 {
   Scanner scan=new Scanner(System.in);
   System.out.print("Enter number of rows: ");
   int m=scan.nextInt();
   System.out.print("Enter number of columns: ");
   int n=scan.nextInt();
   int [] arryOfIntegers=new int[m*n];
   for (int i=0;i<arryOfIntegers.length;i++)
        arryOfIntegers[i]=scan.nextInt();
   //String a=Arrays.toString(arryOfIntegers);
   PrintWriter writer =null; 
   PrintStream stream =null; 
  for(int num:arryOfIntegers)
   {
    //new PrintStream(num);
     writer.print(num);
   }  
 }
}
