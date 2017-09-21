import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataManagementHomeNeeds {
	public static void main(String [] args){
		File file =new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/HomeNeeds");
		writeOnFile(file);
		readOnFile(file);
    
	}

	private static void readOnFile(File file) {
	
		try {
			
				FileReader fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONObject json=(JSONObject)parser.parse(fileReader);
		
				Iterator iterator = json.keySet().iterator(); 
				
				while(iterator.hasNext()) {
					
				    String outerKey = (String) iterator.next();
					JSONObject jsonObject=(JSONObject)json.get(outerKey);
					
					Iterator iterator1 = jsonObject.keySet().iterator(); 
					
					while(iterator1.hasNext()) {
						
						String key=(String) iterator1.next();
						System.out.println(key+" : "+jsonObject.get(key));
						
					 }
					System.out.println();
					System.out.println("The Toatal cost of "+jsonObject.get("Name")+" is: "
					+ Integer.parseInt(jsonObject.get("Price").toString()) *
					  Integer.parseInt(jsonObject.get("Weight").toString())  );
					System.out.println("*****************************************");

				 }
			
			} catch (IOException | ParseException e) {
					e.printStackTrace();
		     }
	}

	private static void writeOnFile(File file) {
		try {
				FileWriter fileWriter=new FileWriter(file);
				
				JSONObject products=new JSONObject();
				
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("Name", "Sona Masuri");
				jsonObject.put("Weight", 50);
				jsonObject.put("Price", 55);
				//JSONObject riceObject=new JSONObject();
				//riceObject.put("Rice", jsonObject);
				
				JSONObject jsonObject1=new JSONObject();
				jsonObject1.put("Name", "wheat101");
				jsonObject1.put("Weight", 50);
				jsonObject1.put("Price", 45);
				
				JSONObject jsonObject2=new JSONObject();
				jsonObject2.put("Name", "Moong dal");
				jsonObject2.put("Weight", 50);
				jsonObject2.put("Price", 150);
				
				
				products.put("Rice", jsonObject);
				products.put("Wheat", jsonObject1);
				products.put("Pulses", jsonObject2);
				//System.out.println(products);
				fileWriter.write(JSONValue.toJSONString(products));
				fileWriter.flush();
				fileWriter.close();
				
			
			//	System.out.println(JSONValue.toJSONString(products));
		} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
}
