import java.util.*;
class Gambler
{
 public static void main(String[] args)
  {
     Scanner scan=new Scanner(System.in);
     
     System.out.println("Enter The Stack Amount : ");
     int stack=scan.nextInt();
     
     System.out.println("Enter The Goal Amount : ");
     int goal=scan.nextInt();
     
     System.out.println("enter the number of times you want play : ");
     int numberoftimes=scan.nextInt();
     
     gameStart(stack,goal,numberoftimes);
  }
 public static void gameStart(int st, int go, int num)
 {
  int bets=0;
  int wins=0;
  //int losses=0;

for (int i=1;i<=num;i++){
   int cash=st;
        //System.out.println("inside for  ");
   while(cash > 0 && cash<go)
   {
             //System.out.println("inside while  ");
     bets++;
     double randnum=Math.random();
      if (randnum>0.5)
       {
                //System.out.println("inside if  ");
        cash++;
       }
      else
      {
        //System.out.println("inside else  ");
       cash--;
      }
      if (cash==go)
        //System.out.println("inside if2  ");
        wins++;
 }
}
       
        System.out.println(" Wins: "+wins+" of total bets  "+bets);
         System.out.println("Wins percentage is: "+( (float) wins*100 / (float)bets) );
 }
}
