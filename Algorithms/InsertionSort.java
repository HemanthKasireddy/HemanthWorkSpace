
public class InsertionSort {
	
	public static void main(String[] args){
		//int [] unSortedArray={1,5,0,7,6,14,25,9,16,3,27,8,4,12,30};
		String []unSortedArray={"hemanth","sunny","kasireddy","reddy","Mr.","Hi"};
		String[] sortedArray=UtilFunctions.insertionSortForStrings(unSortedArray);
		System.out.print("The sorted array is: ");
		for(String i:sortedArray)
			System.out.print(i+"  ");
	}

}
