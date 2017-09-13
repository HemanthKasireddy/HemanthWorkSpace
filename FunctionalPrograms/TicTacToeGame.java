

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Game {
	char userChoice='X';
	char computerChoice='O';
	Scanner scan=new Scanner(System.in);
	
	public char[][] launchGame(char [][]gameTableArray) {
		int index=0;
		try {
			    while(index<5) {
		
			            boolean check=true;
			   		    do {
							System.out.print("Enter the row to insert : ");
							int rowIndex=scan.nextInt();
							System.out.print("Enter the column to insert : ");
							int columnIndex=scan.nextInt();
								
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
					       if(index>=2) {
					    	
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
			/*if (gameTableArray.length==3)
				System.out.println("match drawn");*/
			//displayBoard(gameTableArray);
			 
		 }
		 catch(Exception ex){

			System.out.println("The \" "+ex+" \" Exception is raised");
		 }
		 return   gameTableArray;
       }
        //for displaying board
	public void displayBoard(char [][]table) 
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
       public boolean isUserWinner(char [][]table) {
    	
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
     public boolean isComputerWinner(char [][]table) {
    	
	     if(  ( table [0][0]==table[1][0] && table[1][0] == table[2][0])&&table [0][0]=='O'||
        	  ( table [0][1]==table[1][1] && table[1][1] == table[2][1])&&table [0][1]=='O'||
        	  ( table [0][2]==table[1][2] && table[1][2] == table[2][2])&&table [0][2]=='O'||
        	  ( table [0][0]==table[0][1] && table[0][1] == table[0][2])&&table [0][0]=='O'||
        	  ( table [1][0]==table[1][1] && table[1][1] == table[1][2])&&table [1][0]=='O'||
        	  ( table [2][0]==table[2][1] && table[2][1] == table[2][2])&&table [2][0]=='O'||
        	  ( table [0][0]==table[1][1] && table[1][1] == table[2][2])&&table [0][0]=='O'||	
        	  ( table [2][0]==table[1][1] && table[1][1] == table[0][2])&&table [2][0]=='O'   ){
     	          
                   return true;
               }
           return false;
    }
}


public class TicTacToeGame {
	
	public static void main(String[] args) {
		//Scanner scan=new Scanner(System.in);
		 char [][]ticTacToeArray=new char[3][3];
		try {
			   for(int i=0;i<3;i++) {
		
			      for(int j=0;j<3;j++) {
				      ticTacToeArray[i][j]=' ';
			        }
		           }
				Game g=new Game();
				char[][]finalTableArray=g.launchGame(ticTacToeArray);
				boolean winner=g.isUserWinner(finalTableArray);
				if(winner==false) {
					if(finalTableArray.length==3)
				
		   	        {
						//g.displayBoard(finalTableArray);
			    	    System.out.println("\"Match is Drawn\"");	
			    	    System.exit(0);
			    	 }
				}
		  }
		  catch(Exception ex)
		  {
			 System.out.println("The \" "+ex+" \" Exception is raised");
		  }
	}
}

