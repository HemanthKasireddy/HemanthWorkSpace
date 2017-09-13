import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IntegersTriplets {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter The number of elements you want: ");
		
		//Storing user input to numberOfElements
		int numberOfElements=scan.nextInt();
		
		//creating tripletsArray with size of user input choice
		int []tripletsArray=new int[numberOfElements];
		
		//Inserting user elements to triplets array
		for (int i=0;i<numberOfElements;i++) {
			
			System.out.print("Enter element you want: ");
			tripletsArray[i]=scan.nextInt();
		}
		// taking hash set to eliminate duplicate triplets in the triplets array
		//creating hash set object with type of integer list generic type
		
		HashSet<List<Integer>> ss = new HashSet<List<Integer>>();
		
		//int[]distinctTriplets=new int[3];
		
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
		
		Iterator itr = ss.iterator();
		while(itr.hasNext()){
		
			//Object a=itr.next();
			//while(itr.hasNext())	
		    System.out.println(itr.next());
	   }
	    System.out.println("triplets Count is : "+tripletsCount);
	}
}

