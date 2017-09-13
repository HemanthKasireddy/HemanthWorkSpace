import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class DstinctCouponNumbers
{
  public static void main(String[] args)
  {
    Scanner scan= new Scanner(System.in);
    
    int mincoupon=1;
    try{
	    System.out.print("Enter  number of cupons: "); 
	    int numberofcoupon=scan.nextInt();
	    
	    int maxcoupon=numberofcoupon+1;
	    
	    int [] couponarr=new int[numberofcoupon];
	    int value=getDistinctCuponNumber( couponarr,mincoupon,maxcoupon,numberofcoupon);
            System.out.println(value+" random number needed to have all distinct numbers");
        }
    catch(Exception ex)
    {
      System.out.println("The \""+ex+ "\" Exception is raised");
    }
  }//main

  public static int getRandom(int mi,int ma)
   {
     int trial=0;
     try{
 
          trial=ThreadLocalRandom.current().nextInt(mi, ma + 1);
          
        }

     catch(Exception ex)
     {
      System.out.println("The \" "+ex+ "\" Exception is raised");
     }
     return trial;
   }//getRandom


public static int getDistinctCuponNumber(int arr[],int min,int max,int num)
 {
   int count=0;
   try{
      
       for(int i=0;i<num;i++)
        {
          count++;
          int rand=getRandom(min,max+1);
          for (int j=0;j<i;j++)
           {

             if (arr[j]==rand)
              {
                 rand=getRandom(min,max+1);
                            count++;
               }
              else
              {
                arr[i]=rand;
               } 
           }//inside for
       
          arr[i]=rand;
         }//outer for

    /* for(int i=0;i<num;i++)
     {
       System.out.println("Cupons are: "+arr[i]);
     } */
    
     }

  catch(Exception ex)
    {
      System.out.println("The \" "+ex+ "\" Exception is raised");
    }
   return count;
    
 }//getDistinctCuponNumber

}//class

