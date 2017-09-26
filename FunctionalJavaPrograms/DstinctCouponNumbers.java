package com.bridgeit.javaFunctionalPrograms.Programs;

import java.util.Scanner;
import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class DstinctCouponNumbers {
	
	 public static void main(String[] args) {
	    Scanner scanner= new Scanner(System.in);
	    int mincoupon=1;
	    try {
	    		System.out.print("Enter  number of cupons: "); 
	    		int numberofcoupon=scanner.nextInt();
		    
	    		int maxcoupon=numberofcoupon+1;
		    
	    		int [] couponarr=new int[numberofcoupon];
	    		int value=Utility.getDistinctCuponNumber( couponarr,mincoupon,maxcoupon,numberofcoupon);
	            System.out.println(value+" Random numbers needed to have all distinct numbers");
	            
	        } catch(Exception ex) {
	        	
	        	System.out.println("The \""+ex+ "\" Exception is raised");
	        	
	        } finally {
	        	
	        	scanner.close();
	        }
	  }//main
	  
}
