package com.bridgeit.HemanthJava.Utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
public class Person   {
//File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/PersonDetails.json");
	File file=new File("/home/bridgeit/workspace/firoz/HemanthJava/PersonDetails.json");
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
			//JSONArray jsonArray=new JSONArray();
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
			} catch ( IOException | org.json.simple.parser.ParseException e) {
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
					
					JSONObject jsonObject= (JSONObject) iterator.next();
					
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
			} catch ( IOException | org.json.simple.parser.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		public void sortDetails() {
			try {
				fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
				Scanner scanner1=new Scanner(System.in);
				
				boolean check=true;
				do {
					System.out.println("Sort according to \n 1.First Name1 \n 2.Last Name \n 3. Address \n 4.City \n 5.State \n 6.Zip \n 7.Mobile Number  ");
					int choice=scanner1.nextInt();
					switch(choice) {
							case 1 : 
								     System.out.println("Sorting according to First Names: ");
							
									 Collections.sort(jsonArray,new NameComparator());
			
									 Iterator nameIterator=jsonArray.iterator(); 
									 
									 while(nameIterator.hasNext()) {  
										 JSONObject json=(JSONObject)nameIterator.next();  
										 System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
											   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")		
												 );
									 	}  
									 break;
									 
							 case 2 : //Last Name sorting
							         System.out.println("Sorting according to Last Names: ");

									 Collections.sort(jsonArray,new LastNameComparator());
								
									 Iterator lastNameIterator=jsonArray.iterator();  
								
									 while(lastNameIterator.hasNext()){  
									
										 JSONObject json=(JSONObject)lastNameIterator.next();  
										 System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
												   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
											);
									 }  		 
									 break;
							 case 3: // Address sorting
								 		System.out.println("Sorting according to Address : ");
					
										Collections.sort(jsonArray,new AddressComparator());
											
										Iterator addressIterator=jsonArray.iterator();  
										while(addressIterator.hasNext()){  
											JSONObject json=(JSONObject)addressIterator.next();  
											System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
														   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
												);
										}
										break;
							
						 	case 4: //City sorting
						 				System.out.println("Sorting according to City : ");
					
										Collections.sort(jsonArray,new CityComparator());
										
										Iterator cityIterator=jsonArray.iterator();  
										while(cityIterator.hasNext()){  
											JSONObject json=(JSONObject)cityIterator.next();  
											System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
														   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
												);
										}
										break;
								
							 case 5: //State Sorting
					 					System.out.println("Sorting according to State : ");
 					
										Collections.sort(jsonArray,new StateComparator());
										
										Iterator stateIterator=jsonArray.iterator();  
										while(stateIterator.hasNext()){  
											JSONObject json=(JSONObject)stateIterator.next();  
											System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
														   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
												);
										}
										break;
							 case 6: //Zip sorting
				 						System.out.println("Sorting according to Zip : ");
					
										Collections.sort(jsonArray,new ZipComparator());
										
										Iterator zipIterator=jsonArray.iterator();  
										while(zipIterator.hasNext()){  
											JSONObject json=(JSONObject)zipIterator.next();  
											System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
														   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
												);
										}
										break;
							 case 7: // Mobile number sorting
			 							System.out.println("Sorting according to Mobile number : ");
			 						
										Collections.sort(jsonArray,new MobileNumberComparator());
										
										Iterator mobileNumberIterator=jsonArray.iterator();  
										while(mobileNumberIterator.hasNext()){  
											JSONObject json=(JSONObject)mobileNumberIterator.next();  
											System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
														   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
												);
										}
										
										break;
							 default:
								 		System.out.println("Wrong Choice :");
								 		
					}
					System.out.println("you want try again press\"Y\" else press \"N\" ");
					String ch=scanner1.next().toLowerCase();
					if(ch.equals("y")) {
						check=true;
					} else {
						check=false;
					}
				}while(check);
				
			} catch ( IOException |  org.json.simple.parser.ParseException e) {
				
				e.printStackTrace();
			}
			
		}

		public void personDetails() {
			
			try {
				 System.out.println("Enter a name want to search : ");
				 Scanner scanner1=new Scanner(System.in);
				 String userName=scanner1.nextLine();
				
				 fileReader=new FileReader(file);
				 JSONParser parser=new JSONParser();
				 JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
				 Iterator iterator=jsonArray.iterator();
				
				 while(iterator.hasNext()) {
					
					 JSONObject jsonObject= (JSONObject) iterator.next();
					 if (jsonObject.get("FirstName").equals(userName)){
						 Iterator iterator1=  jsonObject.keySet().iterator();
						 while(iterator1.hasNext()) {
							 String jsonKey=(String) iterator1.next();
				    	
							 System.out.println(jsonKey+" :" +jsonObject.get(jsonKey));
						 }
					 }
				 }
			 } catch ( IOException |  org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
			
		}

}
