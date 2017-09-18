package com.bridgeit.datastrucers.Programs;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Months and Days are taking into Enums

class MonthlyCalender {
	enum Months { January,February,March,April,May,June,July,August,September,October,November,December} 
	enum Days   { Sun,Mon,Tue,Wed,Thu,Fri,Sat }

    int daysInMonth[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
       
    //Method to match the given month and return its maximum days
    public  int findMaxDay(int mname, int y) {    
    	
        if((y%400==0) || (y%4==0)) {
        	daysInMonth[2]=29;
        }   
        return  daysInMonth[mname];     
    }
     
    // Method to match the given weekday name and return its weekday no.
     public  int findDayNo(String wname){ 
    	 
    	 int find = 0;
    	 for(int i=0; i<Days.values().length; i++) {
    		 
    	 	if(wname.equalsIgnoreCase(Days.values()[i].name())) {
    	 		find = i; 
    	 		break;
    	 	}
          }
         return find;
    }
     
    // Method for creating the calendar
    public void fillCalendar(int maxDaysInMonth, int dayNumberInMonth, int month, int year) {
         int [][]calenderArray = new int[6][7];
         int datesCount = 1 ;
     
         for(int i=0;i<calenderArray.length;i++) {
            for(int j=dayNumberInMonth; j<calenderArray[i].length; j++) {
            	//Assigning days to calendar
                if(datesCount<=maxDaysInMonth) {
                	calenderArray[i][j] = datesCount;
                	datesCount++;
                }
            }
            dayNumberInMonth = 0;
        }   
        printCalendar(calenderArray, month, year); //Calling method to print the calendar
    }
     
    //Method for printing the calendar
    void printCalendar(int calenderArray[][], int month, int year) {  
        
    	System.out.println("\n\t----------------------------------------------------");
        System.out.println("\t\t\t   "+Months.values()[month-1]+" "+year); 
        System.out.println("\t----------------------------------------------------"); 
        System.out.println("\tSUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
        System.out.println("\t----------------------------------------------------"); 
         
        for(int i = 0; i < calenderArray.length; i++) {
            for(int j = 0; j < calenderArray[i].length; j++) {
                if(calenderArray[i][j]!=0){
                    System.out.print("\t "+calenderArray[i][j]);
                } else {
                    System.out.print("\t ");
                 }
            }
            System.out.println("\n\t----------------------------------------------------"); 
        }
    }

	/**
	 * This method for finding a first day in month
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public String findMonthDay(int year, int month) {
		  
		 Calendar c=new GregorianCalendar();
		 c.set(Calendar.DAY_OF_MONTH, 1);		
		 YearMonth yearMonth = YearMonth.of( year,month );  
		 LocalDate firstOfMonth = yearMonth.atDay( 1 );
		 //System.out.println(Days.values()[(firstOfMonth.getDayOfWeek().getValue())]);
		 String startingDayOfMonth =Days.values()[firstOfMonth.getDayOfWeek().getValue()].name();
		
		 return startingDayOfMonth;
	}   
}

public class Calender {
	
		 public static void main(String args[])
		    {
				int mname=Integer.parseInt(args[0]);
				int year=Integer.parseInt(args[1]);
				
				MonthlyCalender monthlyCalender = new MonthlyCalender();

		        int maxDaysInMonth = monthlyCalender.findMaxDay(mname,year);
		        
		        String firstDayOfMonth=monthlyCalender.findMonthDay(year,mname);
		        
		        int dayNumberInMonth = monthlyCalender.findDayNo(firstDayOfMonth); 
		        
		        monthlyCalender.fillCalendar(maxDaysInMonth,dayNumberInMonth,mname,year);
		    }
	}

