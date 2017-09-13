import java.util.*;
class PrimeFactorization
{
  public static void primeFactors(int num)
 {
   int n=num;
   HashSet <Integer> hs=new HashSet<Integer>();
   for(int i=2;i<=n;i++)
  {
    if(n%i==0)
   {
     //System.out.println(i);
     hs.add(i);
     n/=i;
     i--;
   }
  }
  for (Integer nn :hs)
  System.out.println(nn);

 }
  public static void main(String[] args)
   {
     System.out.print("Enter a number: ");
     Scanner scan=new Scanner(System.in);
     int number=scan.nextInt();
     primeFactors(number);
   }
}
