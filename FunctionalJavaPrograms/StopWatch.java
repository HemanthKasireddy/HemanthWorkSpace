package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class StopWatch {
	
	
public static void main(String[] args)
 
{
	Scanner scanner=new Scanner(System.in);
	long startTime=0;

	try {
		
			startTime=Utility.startStopWatch();
		    long totalElapsedTime=Utility.stopStopWatch(startTime)-startTime;
		        
		    System.out.println("The Total elapsed time is: "+totalElapsedTime+" ms");
				
	  }
	catch(Exception ex)
	{
		System.out.println("The \" "+ex+" \" Exception is raised");
	}
	finally{
	scanner.close();
	}
}
}
