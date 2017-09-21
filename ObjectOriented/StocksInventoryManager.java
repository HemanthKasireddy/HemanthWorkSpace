import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class InventoryManagerStockPortfolio {
	JSONObject stockJsonObject=new JSONObject();
	File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/InventoryManagerStock.json");
	int stcokNumber=1;
	public void creatingStocks(String shareName, String numberOfShares, String sharePrice) {
		JSONObject shareObject=new JSONObject();
		shareObject.put("shareName", shareName);
		shareObject.put("numberOfShares", numberOfShares);
		shareObject.put("sharePrice", sharePrice);
		stockJsonObject.put("Stock"+stcokNumber,shareObject );
		stcokNumber++;
	}
	public void writeOnFile() {
		try {
				FileWriter fileWriter=new FileWriter(file);
				fileWriter.write(JSONValue.toJSONString(stockJsonObject));
				fileWriter.flush();
				fileWriter.close();
		} catch(Exception ex) {
			System.out.println(ex);
		} 
	}
	public void valueOfEachStock() {
		try {
			
			FileReader fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONObject json=(JSONObject)parser.parse(fileReader);
	
			Iterator iterator = json.keySet().iterator(); 
			
			while(iterator.hasNext()) {
				
			    String outerKey = (String) iterator.next();
				JSONObject jsonObject=(JSONObject)json.get(outerKey);
				
				Iterator iterator1 = jsonObject.keySet().iterator(); 
				System.out.println("*****************************************");

				while(iterator1.hasNext()) {
					
					String key=(String) iterator1.next();
					System.out.println(key+" : "+jsonObject.get(key));
					
				}
				System.out.println("The Toatal cost of "+jsonObject.get("shareName")+" is: "
						+ Integer.parseInt(jsonObject.get("numberOfShares").toString()) *
						  Integer.parseInt(jsonObject.get("sharePrice").toString())  );
						//System.out.println("*****************************************");

					 
			}
		} catch (IOException | ParseException e) {
						e.printStackTrace();
	     }
		
	}

	public void valueOfTotalStock() {
		try {
			
				FileReader fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONObject json=(JSONObject)parser.parse(fileReader);
				int total=0;
				Iterator iterator = json.keySet().iterator(); 
			
				while(iterator.hasNext()) {
				
					String outerKey = (String) iterator.next();
					JSONObject jsonObject=(JSONObject)json.get(outerKey);				
					total=total+ Integer.parseInt(jsonObject.get("numberOfShares").toString()) *
						  Integer.parseInt(jsonObject.get("sharePrice").toString())  ;
						
				}
				System.out.println("*****************************************");
				System.out.println("The Total Stock price is : "+total);
		} catch (IOException | ParseException e) {
						
			e.printStackTrace();
	     }
		
	}
	
}

public class StocksInventoryManager {
	public static void main(String []args) {
		System.out.println("Enter Number of Stacks you want: ");
		Scanner scanner=new Scanner(System.in);
	     try {	
				int  numberOfStocks=scanner.nextInt();
				InventoryManagerStockPortfolio inventoryManagerStockPortfolio=new InventoryManagerStockPortfolio();
				for(int i=0;i<numberOfStocks;i++) {
					System.out.print("Enter share name: ");
					String shareName=scanner.next();
					System.out.print("Enter Number of Shares you want: ");
					String numberOfShares=scanner.next();
					System.out.print("Enter number the Share price: ");
					String sharePrice=scanner.next();
					
					inventoryManagerStockPortfolio.creatingStocks(shareName,numberOfShares,sharePrice);
				}
				inventoryManagerStockPortfolio.writeOnFile();
				inventoryManagerStockPortfolio.valueOfEachStock();
				inventoryManagerStockPortfolio.valueOfTotalStock();
		 } catch(Exception ex) {
			System.out.println(ex);
		 } finally {
			scanner.close();
	      }
	}
}
