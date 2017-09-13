
public class MergeSort {
	
	public static void mergeStrings(String [] unSortedStringArray,int low,int mid,int high){
	
		int leftLength=mid-low+1;
	 int rightLength=high-mid;
	 int k=low;
	 //temp arrays to sore data in unSortedStringArray 
	 String []leftArray=new String[leftLength];
	 String []rightArray=new String[rightLength];
	 //copying data to arrays
	 for (int i=0; i<leftLength; ++i)
		 leftArray[i] = unSortedStringArray[low + i];
     for (int j=0; j<rightLength; ++j)
    	 rightArray[j] = unSortedStringArray[mid + 1+ j];
    
     int i=0,j=0;
     //merging temp arrays 
     while( i < leftLength && rightLength > j ){
    	 
    	 if( rightArray[j].compareTo(leftArray[i])>=0){
    		 
    		 unSortedStringArray[k]=leftArray[i];
    		 i++;
    		 
    	    }
    	     else{
    	    	 unSortedStringArray[k]=rightArray[j];
    	    	j++;
    	     }
    	 k++;
     }
     //Copy remaining elements of leftArray
     while (i < leftLength)
     {
    	 unSortedStringArray[k] = leftArray[i];
         i++;
         k++;
     }

     //Copy remaining elements of rightArray

     while (j < rightLength)
     {
    	 unSortedStringArray[k] = rightArray[j];
         j++;
         k++;
     }
    
	}
	public static void sortStrings(String[] unSortedStringArray,int low,int high){
		
		 int mid = low + (high - low) / 2;
		 
		 if(low<high){
		     //recursion algorithm
			 sortStrings(unSortedStringArray,low,mid);
			 sortStrings(unSortedStringArray,mid+1,high);
			 mergeStrings(unSortedStringArray,low,mid,high);
			
		 }
	}
public static void main(String[] args){
	String [] unSortedStringArray={"hemanth","sunny","kasireddy","Hi","reddy","Mr."};
    int low=0;
    int high=unSortedStringArray.length-1;
    if (high==1||high==0)
    	System.out.println("Array is already in sorted order");
    else
    {
    	sortStrings(unSortedStringArray,low,high);
        System.out.println("Sorted arry is : ");
    	for(String str:unSortedStringArray)
         	System.out.println(str);
    }
    
}
}
