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
   int []arryOfIntegers=new int[m*n];
   for (int i=0;i<m*n;i++)
    {
     System.out.println("Elements : ");   
     arryOfIntegers[i]=scan.nextInt();
       
    }

   /* String strArray[] = new String[arryOfIntegers.length];

    for (int i = 0; i < arryOfIntegers.length; i++)
	 strArray[i] = String.valueOf(arryOfIntegers[i]);

    //System.out.println(Arrays.toString(strArray));

    //String a= Arrays.toString(arryOfIntegers);
        
    //OutputStream stream =new OutputStream(); 
  */
   PrintWriter writer = new PrintWriter(System.out);
for(int num:arryOfIntegers)
   {
   // PrintStream stream = new PrintStream(num);
   // PrintWriter writer = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
    //System.out.println(num);
    //new PrintStream(num);
     writer.println(num);
        writer.flush();

   }  
 }
}
