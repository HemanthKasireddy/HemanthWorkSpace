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
	public StockAccount1(File file) {
		this.file=file;
	}
	public double valueOf() {
		try {
			fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONObject json=(JSONObject)parser.parse(fileReader);
			System.out.println("The account balance is: "+json.get("Balance"));
			} catch ( IOException | ParseException e) {
			
				e.printStackTrace();
		}		
		return 1;
	}
	
	public void buy(int amount, String symbol) {
/*		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter shares how many you want : ");
		int numberOfShares=scanner.nextInt();
*/	
		try {
			fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
			JSONParser parser=new JSONParser();
			JSONObject object=(JSONObject) parser.parse(fileReader);
			int numshare=0;
			int num=0;
			Iterator itr=object.keySet().iterator();
			JSONObject obj=null;
			while(itr.hasNext()){
				String key=(String) itr.next();
				 obj=(JSONObject)object.get(key);
				//Iterator itr1=(Iterator) obj.get(key);
				Iterator iterator1 = obj.keySet().iterator(); 
				
				while(iterator1.hasNext()) {
					
					String key1=(String) iterator1.next();
					if(obj.get(key1).equals(symbol)){
						 numshare=amount/Integer.parseInt(obj.get("SharePrice").toString());
                        num=Integer.parseInt(obj.get("NumberOfShares").toString())-numshare;
					}
					
				 }
				
			}
			System.out.println(num);
			/*obj.put("NumberOfShares", num);
			fileWriter=new FileWriter(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
			fileWriter.write(object.toJSONString());
			fileWriter.flush();*/
		} catch (  IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	public void sell(String symbol) {
		try{
		fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
		JSONParser parser1=new JSONParser();
		JSONObject object=(JSONObject) parser1.parse(fileReader);
		Scanner scanner=new Scanner(System.in);
		System.out.println("number of shares: ");
		int num1=scanner.nextInt();
		int amount=0;
		int num=0;
		Iterator itr=object.keySet().iterator();
		JSONObject obj=null;
		while(itr.hasNext()){
			String key=(String) itr.next();
			 obj=(JSONObject)object.get(key);
			//Iterator itr1=(Iterator) obj.get(key);
			Iterator iterator1 = obj.keySet().iterator(); 
			
			while(iterator1.hasNext()) {
				
				String key1=(String) iterator1.next();
				if(obj.get(key1).equals(symbol)){
					 amount=Integer.parseInt(obj.get("SharePrice").toString())*num1;
                     num=Integer.parseInt(obj.get("NumberOfShares").toString())+num1;
				}
			 }
			
		}
		System.out.println(num1);
/*
		obj.put("NumberOfShares", num1);
		fileWriter=new FileWriter(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
		fileWriter.write(object.toJSONString());*/
		
	} catch (IOException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	}

	
	
	
	public void save() {
		// TODO Auto-generated method stub
		
	}

	public void printReport() {
		// TODO Auto-generated method stub
		
	}

	public void createAccount(String name, double balance) {

	
		JSONObject json=new JSONObject();
		json.put("Nmae", name);
		json.put("Balance", balance);
		try {
			fileWriter =new FileWriter(file);
			fileWriter.write(JSONValue.toJSONString(json));
			fileWriter.flush();
			System.out.println("Account is created succesfully: ");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
      public void userAccount(int num){
		try{
			fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/AccountDetails.json"));
			JSONParser parser=new JSONParser();
			JSONObject object=(JSONObject) parser.parse(fileReader);
			System.out.println("Name: ");
			Scanner scanner=new Scanner(System.in);

			String userName=scanner.nextLine();
		//	Iterator itr=object.keySet().iterator();
			//JSONObject obj=null;
		//	while(itr.hasNext()){
				//String key=(String) itr.next();
				// obj=(JSONObject)object.get(key);
				//Iterator itr1=(Iterator) obj.get(key);
				//Iterator iterator1 = obj.keySet().iterator(); 
				
			//	while(iterator1.hasNext()) {
					
					//String key1=(String) iterator.next();
					if(object.get("Name").equals(userName)){
						System.out.println("amount");
						int amount=scanner.nextInt();
						System.out.println("symbol");
						String symbol=scanner.next();
						System.out.println("Choice buy -y sell- n");
						String choice=scanner.next().toLowerCase();
						if(choice.equals("y")){
							buy(amount,symbol);
						}else{
						      sell(symbol);
						}
					}
					
			//	 }
				
			//}
			
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			
		}
	}
	
}
public class StockCommercialDataProcess {
	
	public static void main(String []args) {
		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/StcokAccountsFile");
		StockAccount1 stockAccount=new StockAccount1(file);
		int amount=0;
		String symbol="";
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("You want a create account press \"y\" if you already have a account press \"n\": " );
		String accountChoice=scanner.next().toLowerCase();
		if(accountChoice.equals("y")) {
			System.out.println("Enter your name: ");
			String name=scanner.next();
			
			System.out.println("Add balance to your account : ");
			double balance=scanner.nextDouble();
			stockAccount.createAccount(name,balance);
		}
		else{
		    	stockAccount.userAccount(0);
	    	}
			
		System.out.println("You want know the total account balance in your account press \"y\" if you don't want press  \"n\":  " );
		String balanceChoice=scanner.next().toLowerCase();
		if(balanceChoice.equals("y")){
			stockAccount.valueOf();
		}
		
		
		//stockAccount.save();
		//stockAccount.printReport();
		
	}
	
}
