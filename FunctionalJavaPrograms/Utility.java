package com.bridgeit.javaFunctionalPrograms.Utility;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Utility {
	
	public static void coinGameStart(int flipcount) {
		int heads=0;
	    int tails=0;
	    
	    try {
	    	if (flipcount>0) {
	       
	    		for (int i=0;i<flipcount;i++) {
	    			
	    			double randnumber=0 +(Math.random() * ((1 - 0)));
	    			
	    			if (randnumber<0.5) {
	    				
	    				tails++;
	                 } else {
	                	 heads++;
	                 }
	      
	            }//for
	       System.out.println("heads "+((heads*100/flipcount))+"% , tails "+((tails*100/flipcount))+"%"); 
	       } else {
	    	   
	           System.out.println("Flip count should be positive number"); 
	       }
	   } catch (Exception ex) {
	        
		   System.out.println("Exception is:"+ex);
	        
	    } 
	}
	
	public static int getRandom( int minimum , int maximum ) {
	     int trial = 0;
	     try {
	 
	          trial=ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
	          
	        }

	     catch(Exception ex) {
	      System.out.println("The \" "+ex+ "\" Exception is raised");
	     }
	     return trial;
	   }//getRandom

	public static void iteration(String input){
		//int count=2;
		System.out.println("possible string by iteration: ");

		System.out.println(input);
		char[] array= input.toCharArray();
		int[] intArray= new int[array.length];
		int index =1;
		while(index<array.length){
			if(intArray[index]<index){
				int j=((index%2)==0)?0: intArray[index];
				swap(array,index,j);
				//count++;

				System.out.println(join(array));
				intArray[index]++;
				index=1;
			}else{
				intArray[index]=0;
				index++;
			}
		}
	}
	private static String join(char[] charArray1) {
	    StringBuilder builder = new StringBuilder();
	    builder.append(charArray1);
	    return builder.toString();
	}
	public static void recursion(String string,int low,int high){
		//int count=1;

		if(low==high) {
			System.out.println(string);
		//	count++;
		} else {
				for(int i=low; i<=high;i++) {
					string= swap(string,low,i);
					recursion(string,low+1,high);
					string= swap(string,low,i);
				}
		}
	}
	public static String swap(String string,int low,int index){
		
		char[] charArray= string.toCharArray();
		char a=charArray[index];
		charArray[index]=charArray[low];
		charArray[low]=a;
		return String.valueOf(charArray);
	}
	
	private static void swap(char[] charArray2, int i, int j) {
	    char temp = charArray2[i];
	    charArray2[i] = charArray2[j];
	    charArray2[j] = temp;
	}
	public static int getDistinctCuponNumber(int array[],int minimum,int maximum,int number) {
	   int count=0;
	   try {
	      
	       for(int i=0;i<number;i++) {
	          
	    	   count++;
	          int randomNumber=getRandom(minimum,maximum+1);
	          for (int j=0;j<i;j++) {

	             if (array[j]==randomNumber) {
	                 randomNumber=getRandom(minimum,maximum+1);
	                            count++;
	              } else {
	            	 array[i]=randomNumber;
	                } 
	           }//inside for
	       
	           array[i]=randomNumber;
	         }//outer for
	    
	     } catch(Exception ex) {
	    	 System.out.println("The \" "+ex+ "\" Exception is raised");
	      }
	   return count;
	    
	 }//getDistinctCuponNumber

	public static void gameStart( int stackAmount , int goalAmount , int number ) {
	
	  int bets = 0;
	  int wins = 0;

	  for ( int i = 1 ; i <= number; i ++ ) {
		  int cash = stackAmount;
		  while( cash > 0 && cash < goalAmount ) {
			 
			  bets ++;
			  double randnum = Math.random();
			  if ( randnum > 0.5 ) {
	       
				  cash ++;
			  } else {
				  
				  cash --;
			  }
			  if ( cash == goalAmount ) {
	        
				  wins ++;
			  }
		  }
	  }    
	  int winPercentage = (( wins*100  / number ));
	  System.out.println( " Wins: "+ wins +" of total ,bets  "+ bets );
	  System.out.print( "Wins percentage is  : "+ winPercentage );
	 
	}
	public static double harmonicValue(int number) {
		  double sum=0;
		  //double result;
		  for(int i=1;i<=number;i++)
		   {
		       sum=sum+(1/(double)i);
		       System.out.print(sum+" + ");
		   }
		     return sum;
		}

	public static void getTriplets(int[] tripletsArray) {
		
		// taking hash set to eliminate duplicate triplets in the triplets array
				//creating hash set object with type of integer list generic type
				
				HashSet<List<Integer>> ss = new HashSet<List<Integer>>();
				
				//triplets count initializing triplets count 0
				int tripletsCount=0;
				for(int i=0;i<tripletsArray.length;i++) {
					
					for(int j=0;j<tripletsArray.length;j++) {
						
						for(int k=0;k<tripletsArray.length;k++) {
							//checking the elements are triplets 
							if(tripletsArray[i]+tripletsArray[j]+tripletsArray[k]==0) {
								//incrementing triplets count 
								 tripletsCount++;
							  // adding triplets elements to hash set 
								 ss.add(Arrays.asList(tripletsArray[i],tripletsArray[j],tripletsArray[k]));	
								//ss.add(tripletsArray[i],tripletsArray[j],tripletsArray[k]);
							}		
						}
					}
				}
				//System.out.println(ss.size());
				
				//Iterator for iterating over the Hash Set 
				
				Iterator<List<Integer>> iterator = ss.iterator();
				System.out.print("Distinct Triplets are: ");
				while(iterator.hasNext()){
					
				    System.out.print(iterator.next()+" ");
			   }
				System.out.println();
			    System.out.println("Total Triplets Count is : "+tripletsCount);
			}

	public static boolean isLeapYear(String year) {
	       if ((Integer.parseInt(year) % 400 == 0) || ((Integer.parseInt(year) % 4 == 0) && (Integer.parseInt(year) % 100 != 0))) {
	    	 
	    	   return true;
	       } else {
	    	 
	    	   return false;
	       }
	}

	public static void findPowerOfTwo(int number) {

		  if (number >=0 && number <31)
			 {
			   for (int i=0;i<=number;i++)
			    {
			       	  System.out.println("2 to the power of "+i+ " is  "+(int)Math.pow(2,i));
			     }
			 }
		     else {
		    	 System.out.println("please enter below 31");
		     }
	}

	public static void primeFactors(int number) {
		
		   int n=number;
		   HashSet <Integer> hs=new HashSet<Integer>();
		   for(int i=2;i<=n;i++)
		  {
		    if(n%i==0)
		   {
		     hs.add(i);
		     n/=i;
		     i--;
		   }
		  }
		  for (Integer numberObject :hs) {
		 
			  System.out.println(numberObject);
		  }
		 
	}

	public static void print2DArray(int rows, int columns) {
		Scanner scanner=new Scanner(System.in);;
		 int []arryOfIntegers=new int[rows*columns];
		   for (int i=0;i<rows*columns;i++)
		    {
		     System.out.println("Elements : ");   
		     arryOfIntegers[i]=scanner.nextInt();
		       
		    }

		   PrintWriter writer = new PrintWriter(System.out);
		   int columnCount=0;
		for(int num:arryOfIntegers)
		   { 
			columnCount ++;
		     writer.print(num +" ");
		        writer.flush();
		        if(columnCount==columns) {
		        	System.out.println();
		        }

		   } 
		scanner.close();
	}
	public static long curretnTime()
	{
		long startTime=System.currentTimeMillis();
		return startTime;
	}
	public static long startStopWatch() {
		long startTime=0;
		boolean isStart=true;
		Scanner scanner=new Scanner(System.in);
			do {
				System.out.print("to Start the watch press \"S\" button : ");
				String start=scanner.nextLine().toLowerCase();
	      
				if(start.equals("s")) {
					startTime= curretnTime();
					isStart=false;
				} else {
					System.out.println("You are entered \"WRONG CHOICE \"");
					isStart=true;
				}
		    
			} while(isStart==true);
		
		return startTime;
	}

	public static long stopStopWatch(long startTime) {
		Scanner scanner=new Scanner(System.in);

        long endTime=0;
		boolean isEnd=true;

		do {
			System.out.print("to Stop the watch press \"E\"enter button : ");
			String end=scanner.next().toLowerCase();
			
			if(end.equals("e")) {   
				 endTime=curretnTime();
				isEnd=false;
			} else {
				System.out.println("You are entered \"WRONG CHOICE \"");
				isEnd=true;
			}
	     
		}while(isEnd==true);
		return endTime;
	}
	
	public static char[][] launchGame(char [][]gameTableArray) {
		char userChoice='X';
		char computerChoice='O';
		Scanner scanner=new Scanner(System.in);

		int index=0;
		try {
			    while(index<5) {
				
		
	            boolean check=true;
	   		    do {
						System.out.print("Enter the row to insert : ");
						int rowIndex=scanner.nextInt();
						System.out.print("Enter the column to insert : ");
						int columnIndex=scanner.nextInt();
						
						if (gameTableArray[rowIndex][columnIndex]==' ') {
							gameTableArray[rowIndex][columnIndex]=userChoice;			
			                check=false;
			       			}
						    else
							System.out.println("\"Your entered Wrong Choice\" please Try again");
			   		    }while(check==true);
                 // checking after three entries only winning or not
				 if (index>=2) {
					 //checking for whether user was won or not
						if(isUserWinner(gameTableArray)==true) {
							
							displayBoard(gameTableArray);
						  System.out.println("user is winner:");
						  System.exit(0);
						  
						}		
					}
					
				//using random function for computer entries
			      for(int i=0;i<=100;i++) {
					 int randRowIndex = ThreadLocalRandom.current().nextInt(0,3);
					 int randColumnIndex = ThreadLocalRandom.current().nextInt(0,3);
					 
					  if (gameTableArray[randRowIndex][randColumnIndex]==' ') {
						 gameTableArray[randRowIndex][randColumnIndex]=computerChoice;
						 break;
					 }
				 
			    }
			    if(index>2) {
			    	
					 //checking for whether Computer was won or not

			      if(isComputerWinner(gameTableArray)==true) {
					
			    	displayBoard(gameTableArray);
					  System.out.println("Computer is winner:");
					  System.exit(0);
				    }
			    }
			    index++;
				displayBoard(gameTableArray);
	
			    
			}	 
		 }
		catch(Exception ex)
		{
			System.out.println("The \" "+ex+" \" Exception is raised");
		} finally {
			scanner.close();
		}
		 return   gameTableArray;
}
    //for displaying board
	public static void displayBoard(char [][]table) 
	{

	    System.out.println("  0  " + table[0][0] + "|" + table[0][1] + "|" + table[0][2]);
	    System.out.println("    --+-+--");
	    System.out.println("  1  " + table[1][0] + "|" + table[1][1] + "|" + table[1][2]);
	    System.out.println("    --+-+--");
	    System.out.println("  2  " + table[2][0] + "|" + table[2][1] + "|" + table[2][2]);
	    System.out.println();
	    System.out.println("     0  1  2 ");
	    
	  
	}
    //checking for user is winning or not
   public static boolean isUserWinner(char [][]table) {
        if(   ( table [0][0]==table[1][0] && table[1][0] == table[2][0])&&table [0][0]=='X'||
        	  ( table [0][1]==table[1][1] && table[1][1] == table[2][1])&&table [0][1]=='X'||
        	  ( table [0][2]==table[1][2] && table[1][2] == table[2][2])&&table [0][2]=='X'||
        	  ( table [0][0]==table[0][1] && table[0][1] == table[0][2])&&table [0][0]=='X'||
        	  ( table [1][0]==table[1][1] && table[1][1] == table[1][2])&&table [1][0]=='X'||
        	  ( table [2][0]==table[2][1] && table[2][1] == table[2][2])&&table [2][0]=='X'||
        	  ( table [0][0]==table[1][1] && table[1][1] == table[2][2])&&table [0][0]=='X'||	
        	  ( table [2][0]==table[1][1] && table[1][1] == table[0][2])&&table [2][0]=='X' ) {
     	          
                   return true;
      
               }
           return false;

   }
   //checking for Computer is winning or not
   public static boolean isComputerWinner(char [][]table) {
	  if(     ( table [0][0]==table[1][0] && table[1][0] == table[2][0])&&table [0][0]=='O'||
        	  ( table [0][1]==table[1][1] && table[1][1] == table[2][1])&&table [0][1]=='O'||
        	  ( table [0][2]==table[1][2] && table[1][2] == table[2][2])&&table [0][2]=='O'||
        	  ( table [0][0]==table[0][1] && table[0][1] == table[0][2])&&table [0][0]=='O'||
        	  ( table [1][0]==table[1][1] && table[1][1] == table[1][2])&&table [1][0]=='O'||
        	  ( table [2][0]==table[2][1] && table[2][1] == table[2][2])&&table [2][0]=='O'||
        	  ( table [0][0]==table[1][1] && table[1][1] == table[2][2])&&table [0][0]=='O'||	
        	  ( table [2][0]==table[1][1] && table[1][1] == table[0][2])&&table [2][0]=='O' ) {
     	          
                   return true;
      
               }
           return false;
    }

   public static void findChill(double temperature, double velocity) {
	
	/*checking the  temperature is less than 50 in absolute value and 
	 velocity is less than 120 and less than 3 */
	
	if (temperature<=50.0 && (velocity>=3&&velocity<=120) ) {
		
		// Finding Wind Chill by using formula and taking into the weather variable 
		double weather=35.74+0.6215*temperature+((0.4275*temperature-35.75)*Math.pow(velocity, 0.16));
		System.out.println("Wind Chill is : "+weather);
	} else {
		
		System.out.println("Please enter the values in valid range:");
	  }
}
	
	
}
