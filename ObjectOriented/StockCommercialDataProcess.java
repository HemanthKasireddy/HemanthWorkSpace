import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class StockAccount1 {

	private File file;
	FileReader fileReader=null;
	FileWriter fileWriter=null;
	String userName;
	public StockAccount1(File file) {
		this.file=file;
	}
	public double valueOf() {
		try {
			fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONObject json=(JSONObject)parser.parse(fileReader);
			System.out.println("The account balance is: "+json.get("Balance"));
			 //}
			} catch ( IOException | ParseException e) {
			
				e.printStackTrace();
		}		
		return 1;
	}
	
	public void buy(int amount, String symbol) {
		
		JSONObject object=null;
		JSONObject obj=null;
		JSONParser parser=null;
		
		try {
			 fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
			 parser=new JSONParser();
			 object=(JSONObject) parser.parse(fileReader);
			 int numshare=0;
			 int finalShares=0;
			 Iterator itr=object.keySet().iterator();
			
			
			while(itr.hasNext()) {
				
				String key=(String) itr.next();
				obj=(JSONObject)object.get(key);
				
				if(key.equals(symbol)) {
					
					numshare=amount/Integer.parseInt(obj.get("SharePrice").toString());
					
					if(numshare<=Integer.parseInt(obj.get("NumberOfShares").toString())) {
						
						finalShares=Integer.parseInt(obj.get("NumberOfShares").toString())-numshare;
					
					} else {
						System.out.println("buying shares is not possible: ");
					}
				}	
			}
			String check="buy";
		//	System.out.println(finalShares);
			userAccountUpdated(numshare,amount,check);
			// saving sahre details in with new share values
			save(finalShares,symbol);
			
			
		} catch (  IOException | ParseException ex) {
			ex.printStackTrace();
			System.out.println("Exception is:"+ex);
		}
		
		}

	public void sell(String symbol) {
		 JSONObject obj=null;
		 JSONParser parser=null;
		 JSONObject object=null;
		 Scanner scanner=null;
		try {
			 fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
			 parser=new JSONParser();
			 object=(JSONObject) parser.parse(fileReader);
			 
			 scanner=new Scanner(System.in);
			 System.out.println("number of shares: ");
			 int userNumber=scanner.nextInt();
			 
			 int amount=0;
			 int numShares=0;
			 Iterator itr=object.keySet().iterator();
			 
		   	 while(itr.hasNext()) {
				
				String key=(String) itr.next();
				obj=(JSONObject)object.get(key);
				
				if(key.equals(symbol)) {
					
					 amount=Integer.parseInt(obj.get("SharePrice").toString())*userNumber;
					 numShares=Integer.parseInt(obj.get("NumberOfShares").toString())+userNumber;
				}
			
			}
		   	 String check="sell";
		   	 save(numShares,symbol);
		   	 userAccountUpdated(userNumber,amount,check);
		//System.out.println(numShares);
		
		} catch (IOException | ParseException ex) {

			ex.printStackTrace();
			System.out.println("Exception is:"+ex);
		}
			
	}
	
	public void userAccountUpdated(int numShares, int amount, String check) {
		JSONObject object=null;
		try {
			fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			 object=(JSONObject) parser.parse(fileReader); 
				 if(check.equals("sell")) {
					if(object.get("Name").equals(userName)){
						int finalShares=Integer.parseInt(object.get("NumberOfShares").toString())-numShares;

						object.remove("NumberOfShares");
						object.put("NumberOfShares", finalShares);
						double finalAmount=Double.parseDouble(object.get("Balance").toString())+amount;
						object.remove("Balance");
						object.put("Balance", finalAmount);
					}
				 } if(check.equals("buy")) {
					 if(object.get("Name").equals(userName)){
							int finalShares=Integer.parseInt(object.get("NumberOfShares").toString())+numShares;

							object.remove("NumberOfShares");
							object.put("NumberOfShares", finalShares);
							double finalAmount=Double.parseDouble(object.get("Balance").toString())-amount;
							object.remove("Balance");
							object.put("Balance", finalAmount);
						}
				 }
					fileWriter =new FileWriter(file);
					fileWriter.write(JSONValue.toJSONString(object));
					fileWriter.flush();
					
					System.out.println("User Account is updated succesfully: ");
				
		}catch(Exception ex){
			System.out.println(ex);
		}
		 
	}
	public void save(int numShares,String symbol) {
		try {
			fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
			JSONParser parser1=new JSONParser();
			JSONObject json=(JSONObject) parser1.parse(fileReader);
			
			try {
                 Iterator iterator1 = json.keySet().iterator(); 
				
				 while(iterator1.hasNext()) {
					
					String key1=(String) iterator1.next();
					JSONObject obj=(JSONObject)json.get(key1);

					if(key1.equals(symbol)){
						obj.remove("NumberOfShares");
						obj.put("NumberOfShares", numShares);
						
						}
					}
				fileWriter =new FileWriter(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
				fileWriter.write(JSONValue.toJSONString(json));
				fileWriter.flush();
				
				System.out.println("Shares Account is udated succesfully: ");

			} catch (IOException ex) {
				ex.printStackTrace();
				System.out.println("Exception is:"+ex);

			} 
		}catch(Exception ex){
			System.out.println(ex);
			ex.printStackTrace();
		}
	}

	public void printReport() {
		JSONParser parser=null;
		JSONObject object=null;
		try {
			 fileReader=new FileReader(file);
			 parser=new JSONParser();
			 object=(JSONObject) parser.parse(fileReader);
			 Iterator itr=object.keySet().iterator();
			 while(itr.hasNext()) {
				
				 String key=(String) itr.next();
				 System.out.println(key+" : "+object.get(key));
			}
		} catch(Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
   
	public void createAccount(String name, double balance) {

		JSONObject json=new JSONObject();
		json.put("Name", name);
		json.put("Balance", balance);
		json.put("NumberOfShares", 1000);
		
		try {
			  fileWriter =new FileWriter(file);
			  fileWriter.write(JSONValue.toJSONString(json));
			  fileWriter.flush();
			  System.out.println("Account is created succesfully: ");

		} catch (IOException ex) {
			System.out.println("Exception is: "+ex);
			ex.printStackTrace();
		} 
	}
      public void userAccount(int num) {
    	  JSONParser parser=null;
    	  JSONObject object=null;
    	  
    	  try {
	    	
    		  fileReader=new FileReader(file);
			  parser=new JSONParser();
			  object=(JSONObject) parser.parse(fileReader);
			  Scanner  scanner=new Scanner(System.in);

			  System.out.println("Enter User Name: ");
			  userName=scanner.nextLine();
			
			  if(object.get("Name").equals(userName)) {
						
				System.out.println("Enter share symbol want to buy  [!,@,#]: ");
				String symbol=scanner.next();
				System.out.println("For buying shares pres -b or  For selling shares press- s");
				String choice=scanner.next().toLowerCase();
				
				if(choice.equals("b")) {
					System.out.println("Enter your amount to buy shares: ");
					int amount=scanner.nextInt();
					//calling buy method
					buy(amount,symbol);
				} else { 
					//calling sell method
					  sell(symbol);
				}
				
			 } else {
				System.out.println("Enter wrong choice: ");
			 }
		
					
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
}
public class StockCommercialDataProcess {
	
	public static void main(String []args) {
		
		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/StcokAccountsFile.json");
		
		StockAccount1 stockAccount=new StockAccount1(file);
		Scanner scanner=new Scanner(System.in);
		try {
				System.out.println("You want a create account press \"y\" if you already have a account press \"n\": " );
				String accountChoice=scanner.next().toLowerCase();
				
				if(accountChoice.equals("y")) {
					System.out.println("Enter your name: ");
					String name=scanner.next();
					
					System.out.println("Add balance to your account : ");
					double balance=scanner.nextDouble();
					stockAccount.createAccount(name,balance);
					stockAccount.userAccount(0);
				}
				else{
				    	stockAccount.userAccount(0);
			    	}
				
				System.out.println("You want know the total account balance in your account press \"y\" if you don't want press  \"n\":  " );
				String balanceChoice=scanner.next().toLowerCase();
				if(balanceChoice.equals("y")){
					stockAccount.valueOf();
				}
				System.out.println("User Details is: ");
				stockAccount.printReport();
				
				
		} catch(Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}
	
}
