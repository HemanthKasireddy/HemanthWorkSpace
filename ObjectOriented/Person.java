import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Person {
	File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/PersonDetails.json");
	Scanner scanner=null;
	FileWriter fileWriter=null;
	FileReader fileReader=null;
	
	public void addPerson() {
		scanner=new Scanner(System.in);
		try {
		System.out.println("Enter Your First Name: ");
		String userFirstName=scanner.nextLine();
		
		System.out.println("Enter your Last Name: ");
		String userLastName=scanner.nextLine();
		
		System.out.println("Enter your Address: ");
		String userAddress=scanner.nextLine();
		
		System.out.println("Enter your City: ");
		String userCity=scanner.nextLine();
		
		System.out.println("Enter your State: ");
		String userState=scanner.nextLine();
		
		System.out.println("Enter your ZIP: ");
		int userZIP=scanner.nextInt();
		
		System.out.println("Enter your Mobile No: ");
		long userMobileNumber=scanner.nextLong();
		
		fileReader=new FileReader(file);
		JSONParser parser=new JSONParser();
		JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("FirstName",userFirstName);
		jsonObject.put("LastName", userLastName);
		jsonObject.put("Address", userAddress);
		jsonObject.put("City", userCity);
		jsonObject.put("State", userState);
		jsonObject.put("Zip", userZIP);
		jsonObject.put("MobileNumber", userMobileNumber);
		jsonArray.add(jsonObject);
		try {
			fileWriter=new FileWriter(file);
			fileWriter.write(JSONValue.toJSONString(jsonArray));
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void editPerson() {
		
		scanner=new Scanner(System.in);
		System.out.println("Enter name you want edit: ");
		String userEntry=scanner.nextLine();
		try {
			fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
			Iterator iterator=jsonArray.iterator();
			
			while(iterator.hasNext()) {
				
	        int key=(int) iterator.next();
			JSONObject jsonObject= (JSONObject) jsonArray.get(key);
			if(jsonObject.get("FirstName").equals(userEntry)) {
				System.out.println("Select what you want to edit: \n 1. Address \n2. City \n 3. State \n 4. ZIP \n 5. Mobile Number \n 6. Edit All ");
				int choice=scanner.nextInt();
				
				switch(choice){
					
					case 1:	 System.out.println("Enter your Address: ");
							 String userAddress=scanner.next();
								
							 jsonObject.remove("Address");
							 jsonObject.put("Address", userAddress);
								
								break;
					
					case 2 : System.out.println("Enter your City: ");
							 String userCity=scanner.nextLine();
							 jsonObject.remove("City");
							 jsonObject.put("City", userCity);

							 break;
							 
					case 3 : System.out.println("Enter your State: ");
							 String userState=scanner.nextLine();
							 jsonObject.remove("State");
							 jsonObject.put("State", userState);
							 break;
							 
					case 4 : System.out.println("Enter your ZIP: ");
							 int userZIP=scanner.nextInt();
							 jsonObject.remove("Zip");
							 jsonObject.put("Zip", userZIP);

							 break;
							 
					case 5 : System.out.println("Enter your Mobile No: ");
							 long userMobileNumber=scanner.nextLong();
							 jsonObject.remove("MobileNumber");
							 jsonObject.put("MobileNumber", userMobileNumber);

							 break;
							 
					case 6 : System.out.println("Enter your Address: ");
							 String userAddress1=scanner.nextLine();
					
							 System.out.println("Enter your City: ");
							 String userCity1=scanner.nextLine();
					
							 System.out.println("Enter your State: ");
							 String userState1=scanner.nextLine();
					
							 System.out.println("Enter your ZIP: ");
							 int userZIP1=scanner.nextInt();
					
							 System.out.println("Enter your Mobile No: ");
							 long userMobileNumber1=scanner.nextLong();	
							 
							 jsonObject.put("Address", userAddress1);
							 jsonObject.put("City", userCity1);
							 jsonObject.put("State", userState1);
							 jsonObject.put("Zip", userZIP1);
							 jsonObject.put("MobileNumber", userMobileNumber1);
							 
							 break;
							 
					default:
						System.out.println("Wrong choice: ");
				}
				jsonArray.remove(key);
				jsonArray.add(jsonObject);
				fileWriter=new FileWriter(file);
				fileWriter.write(JSONValue.toJSONString(jsonArray));
				fileWriter.flush();
				fileWriter.close();
				System.out.println("Edited");
			} else {
				System.out.println("User does not exist");
			}
			}
		} catch ( IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deletePerson() {
		
		scanner=new Scanner(System.in);
		System.out.println("Enter name you want delete: ");
		String userEntry=scanner.nextLine();
		try {
			fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
			Iterator iterator=jsonArray.iterator();
			
			while(iterator.hasNext()) {
				
				int key=(int) iterator.next();
				JSONObject jsonObject= (JSONObject) jsonArray.get(key);
				if(jsonObject.get("FirstName").equals(userEntry)) {
					jsonArray.remove(0);
					//	jsonArray.add(jsonObject);
					fileWriter=new FileWriter(file);
					fileWriter.write(JSONValue.toJSONString(jsonArray));
					fileWriter.flush();
					fileWriter.close();
					System.out.println("Deleted");
				} else {
					System.out.println("User not exist: ");
				}
			}
		} catch ( IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void sortDetails() {
		// TODO Auto-generated method stub
		
	}

	public void personDetails() {
		
		try {
			fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
			Iterator iterator=jsonArray.iterator();
			
			while(iterator.hasNext()) {
				
	        int key=(int) iterator.next();
			JSONObject jsonObject= (JSONObject) jsonArray.get(key);
			Iterator iterator1= jsonObject.iterator();
			}
		} catch ( IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
