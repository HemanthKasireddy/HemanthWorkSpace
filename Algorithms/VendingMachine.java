
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {
	private static int oneCount,twoCount,fiveCount,tenCount,fiftyCount,hundredCount,fiveHundredCount,thousundCount;
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter how much change want: ");
		try{
			 int userAmount=scan.nextInt();
			 if(userAmount>0)
			   changeRequired(userAmount);
			 else 
				 System.out.println("Your entered wrong amount :");
		}
        catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			System.out.println("Exception Details are: ");
			ex.printStackTrace();
		}
		finally{
			scan.close();
		}
	}

	private static void changeRequired(int userAmount) {
		
		try{
			
			//storing notes according to notes name and values
			LinkedHashMap<String,Integer> mapChange=new LinkedHashMap<String,Integer>();
			// using recursion technique to denomination of money
			
			if(userAmount>=1000){
				userAmount=userAmount-1000;
				thousundCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=500){
				userAmount=userAmount-500;
				fiveHundredCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=100){
				userAmount-=100;
				hundredCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=50){
				userAmount-=50;
				fiftyCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=10){
				userAmount-=10;
				tenCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=5){
				userAmount-=5;
				fiveCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=2){
				userAmount-=2;
				twoCount++;
				changeRequired(userAmount);
			}
			else if(userAmount>=1){
				userAmount-=1;
				oneCount++;
				changeRequired(userAmount);
			}
			else{
				    // when denomination is 0 then it  will enter the else block 
				    // putting the all the values in to linkedHashMap according to key-value pair
					mapChange.put("five hundred",fiveHundredCount);
					mapChange.put("thousund", thousundCount);
					mapChange.put("hundred",hundredCount);
					mapChange.put("fifty",fiftyCount);
					mapChange.put("ten",tenCount);
					mapChange.put("five",fiveCount);
					mapChange.put("two",twoCount);
					mapChange.put("one",oneCount);
					
					//removing all the keys with have 0's by using singleton()
					//singleton() will return all the matching values of 0's and remove all remove those values keys in map
					mapChange.values().removeAll(Collections.singleton(0));
				    System.out.println("minimum " + mapChange.size()+" notes are required");
				    //taking the all keys in map by using keySet() and adding into set
					Set<String> keys = mapChange.keySet();
			        for(String k:keys){
			            System.out.println(k+"'s notes "+mapChange.get(k)+" are required");
		             }
			}
		}
		 catch(Exception ex){
				
				System.out.println("The \" "+ex+" \" Exception is raised");
				System.out.println("Exception Details are: ");

				ex.printStackTrace();
			}
	}
}
