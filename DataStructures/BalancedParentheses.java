
/**
 * @author Hemanth
 * Desc -> Take an Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) 
 * where parentheses are used to order the performance of operations.
 *  Ensure parentheses must appear in a balanced fashion.
 *  
 * I/P -> read in Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) 
 * 
 * O/P -> True or False to Show Arithmetic Expression is balanced or not.
 *
 */

package com.bridgeit.datastrucers.Programs;

import java.util.Scanner;
import java.util.Stack;

class ParenthesesStack{
	
	String userArithmeticExpression;
	Stack<Character> stack=new Stack<Character>();
	public ParenthesesStack(String userArithmeticExpression) {
		this.userArithmeticExpression=userArithmeticExpression;
	}
	/**
	 * 
	 * this method for traverse over the expression 
	 * and if "(" encounter push into the stack
	 * if ")" encounter pop from the stack
	 * 
	 */
	public void parenthesesChecking(){
		try{
			
			for(int i=0;i<userArithmeticExpression.length();i++){
				
				if(userArithmeticExpression.charAt(i)=='('){
					
					stack.push(userArithmeticExpression.charAt(i));
					
				} else 	if(userArithmeticExpression.charAt(i)==')'){
					if (stack.size()>0){
					     stack.pop();
					}else {
						System.out.println("Arithmetic Expression is not Balanced");
						System.exit(0);
					}
					
				}
			}
		}catch(Exception ex){
				
				System.out.println("The \" "+ex+" \" Exception is raised");
				ex.printStackTrace();
			}
	}
	
	/**
	 * this method for checking stack is empty or not if stack is empty
	 * number of "(" and ")" are equal means expression have balanced parentheses
	 * else expression have unbalanced parentheses
	 */
	public void parenthesesBalancedChecking() {
		
		if(stack.isEmpty()==true){
			System.out.println("Arithmetic Expression is Balanced");
		}
		else{
			System.out.println("Arithmetic Expression is not Balanced");
		}
		
	}
	
}

public class BalancedParentheses {
	
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		try{
			System.out.println("Enter your Arithmetic Expression: ");
		    String userArithmeticExpression=scanner.nextLine();
		    
		    ParenthesesStack parenthesesStack=new ParenthesesStack(userArithmeticExpression);
		    parenthesesStack.parenthesesChecking();
		    parenthesesStack.parenthesesBalancedChecking();
	       }catch(Exception ex){
	   		
	   		System.out.println("The \" "+ex+" \" Exception is raised");
	   		ex.printStackTrace();
	   	}finally {
	   		scanner.close();
	   	}
	}

}
