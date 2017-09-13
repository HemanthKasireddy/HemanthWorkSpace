import java.util.*;
class CoinFlip
{
 public static void main(String []args)
  {
    Scanner scan=new Scanner(System.in);
    System.out.print("Enter the number of times to flip to coin: ");
    int flipcount=scan.nextInt();
    int heads=0;
    int tails=0;
 try{
    if (flipcount>0)
     {
       for (int i=0;i<flipcount;i++)  
        {
          double randnumber=0 +(Math.random() * ((1 - 0)));
          //double randnumber=(Math.random());
          //System.out.println(randnumber);
          if (randnumber<0.5)
           {
         
             tails++;
           }
          else
           {
             heads++;
           }
      
        }
       // System.out.println("heads "+heads+ " tails "+tails);

       System.out.println("heads "+((heads*100/flipcount))+"% , tails "+((tails*100/flipcount))+"%"); 
      }
      else
         System.out.println("Flip count should be positive number"); 
   }
    catch (Exception ex) 
      {
        System.out.println("Exception is:"+ex);
        

      }
  }
}
