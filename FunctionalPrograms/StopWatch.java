
import java.util.Scanner;
public class StopWatch {
	public static long curretnTime()
	{
		long startTime=System.currentTimeMillis();
		return startTime;
	}
public static void main(String[] args)
 
{
	
	Scanner scan=new Scanner(System.in);
	
	long startTime=0;
	boolean isStart=true;
	boolean isEnd=true;
	try {
		do
		{
			System.out.print("to Start the watch press \"S\" button : ");
			String start=scan.nextLine().toLowerCase();
      
			if(start.equals("s"))
			{
				startTime=curretnTime();
				isStart=false;
			}else
		  
			{
				System.out.println("You are entered \"WRONG CHOICE \"");
				isStart=true;
			}
	    
		}while(isStart==true);
	
		
		do
		{
			System.out.print("to Stop the watch press \"E\"enter button : ");
			String end=scan.next().toLowerCase();
			
			if(end.equals("e"))
			{
				long elapsedtime=curretnTime()-startTime;
				System.out.println("Total Elapsed Time is :"+elapsedtime);
				isEnd=false;
			}else
		  
			{
				System.out.println("You are entered \"WRONG CHOICE \"");
				isEnd=true;
			}
	     
	    
		}while(isEnd==true);
	}
	catch(Exception ex)
	{
		System.out.println("The \" "+ex+" \" Exception is raised");
	}
	finally{
	scan.close();
	}
}
}
