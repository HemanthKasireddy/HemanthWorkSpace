import java.util.*;
class HarmonicSeries
{
public static double harmonicValue(int n)
{
  double sum=0;
  //double result;
  for(int i=1;i<=n;i++)
   {
       sum=sum+(1/(double)i);
   }
     return sum;
}
 public static void main(String [] args)
 {
   System.out.println("Enter the number you want: ");
   Scanner scan=new Scanner(System.in);
   int N=scan.nextInt();
   if (N!=0)
     {
         System.out.println("The harmonic value of "+N+" is "+ harmonicValue(N));
     }
     else
         System.out.println("The harmonic value of "+N+" is not possible");
 }
}
