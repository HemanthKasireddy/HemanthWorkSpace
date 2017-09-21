import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class StockPortfolio {
	
	Map<String,ArrayList<String>> map=new LinkedHashMap<String,ArrayList<String>>();
	int stockNumber=0;
	public void creatingStocks( String shareName, String numberOfShares, String sharePrice) {
		try {
			  ArrayList<String> stock=new ArrayList<String>();
			  stock.add(shareName);
			  stock.add(numberOfShares);
			  stock.add(sharePrice);
			  map.put("Stock"+stockNumber, stock);
			  stockNumber++;
		} catch(Exception ex) {
			ex.getMessage();
		}
	}
	public void valueOfEachStock() {
		try {
			  for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
				 ArrayList<String> value = (ArrayList<String>) entry.getValue();
				 System.out.println("*****************************************");
				 System.out.println("Share Name: "+value.get(0));
				 System.out.println("Number of shares are: "+value.get(1));
				 System.out.println("Share Price is: "+value.get(2));
				 System.out.println();
				 System.out.println(value.get(0)+" Stock value is: "+Integer.parseInt(value.get(1).toString())*Integer.parseInt(value.get(2).toString()));

			  }
		 } catch(Exception ex) {
			System.out.println(ex);		
		  }
	}
	public void valueOfTotalStock() {
		int total=0;
		try{
			 for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			     ArrayList<String> value = (ArrayList<String>) entry.getValue();
			     total=total+Integer.parseInt(value.get(1))*Integer.parseInt(value.get(2));
			 }
				System.out.println("*****************************************");

			System.out.println("The total Stock Price is : "+total);
		} catch(Exception ex) {
			System.out.println(ex);
		 }
	}
	
}
public class Stock {
	public static void main(String []args) {
		System.out.println("Enter Number of Stacks you want: ");
		Scanner scanner=new Scanner(System.in);
	     try {	
				int  numberOfStocks=scanner.nextInt();
				StockPortfolio StockPortfolio=new StockPortfolio();
				for(int i=0;i<numberOfStocks;i++) {
					System.out.print("Enter share name: ");
					String shareName=scanner.next();
					System.out.print("Enter Number of Shares you want: ");
					String numberOfShares=scanner.next();
					System.out.print("Enter number the Share price");
					String sharePrice=scanner.next();
					
					StockPortfolio.creatingStocks(shareName,numberOfShares,sharePrice);
				}
				StockPortfolio.valueOfEachStock();
				StockPortfolio.valueOfTotalStock();
		 } catch(Exception ex) {
			System.out.println(ex);
		 } finally {
			scanner.close();
	      }
	}
}
