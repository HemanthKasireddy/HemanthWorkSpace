import java.util.Scanner;
public class StringAnagramDetection  {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the  first String for checiking anagram");
		
		String str1=scan.nextLine();
		System.out.println("Enter the second String for checiking anagram");

		String str2=scan.nextLine();
		// calling parent class method
		boolean check=UtilFunctions.checkStringIsAnagram(str1,str2);
		if (check==true)
			System.out.println("Given strings are \"Anagrams\"");
		else
			System.out.println("Given strings are \"Not a anagrams\"");
		scan.close();
	}

}
