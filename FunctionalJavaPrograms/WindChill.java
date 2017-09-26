package com.bridgeit.javaFunctionalPrograms.Programs;

import com.bridgeit.javaFunctionalPrograms.Utility.Utility;

public class WindChill {
	
	public static void main(String[] args) {
	    try {	
			// Taking the temperature value as a command line argument 
			double temperature=Math.abs(Double.parseDouble(args[0]));			
			// Taking the velocity value as a command line argument 
			double velocity=Double.parseDouble(args[1]);
			
			Utility.findChill(temperature,velocity);
			
	    } catch(Exception ex) {
	    	
			System.out.println("The \" "+ex+" \" Exception is raised");
		 }
	}
}
