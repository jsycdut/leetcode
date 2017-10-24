import java.util.Stack;
import java.util.Scanner;

public class ValidBrackets{
	/*
	 *to validate the given string is valid or not
         *valid brackets (){[][()]}
	 *invalid brackets ([)
         *simply using the stack to validate the string
	 *when you come into a left bracket, push it into the stack
	 *a right bracket, pop it out.
	 *if the brackets is valid, the stack will be empty after you traverse the whole sequence
	 */
	public boolean isValid(String s){
		int length = s.length();
		int i = 0;
		Stack<Character> stack = new Stack<>();
		while(i < length){
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
				stack.push(s.charAt(i));
				i++;
				continue;
			}
			if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '('){
				stack.pop();
				i++;
				continue;
			}else{
				stack.push(s.charAt(i));
			}
			if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '['){
				stack.pop();
				i++;
				continue;
			}else{
				stack.push(s.charAt(i));
			}
			if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{'){
				stack.pop();
				i++;
				continue;
			}else{
				stack.push(s.charAt(i));
			}		
			i++;
			continue;
		}
		return stack.empty();
	}
	public boolean validateBrackets(String s){
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		int i = 0;
		while(i < length){
			switch(s.charAt(i)){
				case '(':
					stack.push(s.charAt(i));
					break;
				case '[':
					stack.push(s.charAt(i));
					break;
				case '{':
					stack.push(s.charAt(i));
					break;
				case ')':
					if(!stack.empty() && stack.peek() == '('){
						stack.pop();
					}else{
						stack.push(s.charAt(i));
					}
					break;
			  	case ']':
					if(!stack.empty() && stack.peek() == '['){
						stack.pop();
					}else{
						stack.push(s.charAt(i));
					}
					break;
				case '}':
					if(!stack.empty() && stack.peek() == '{'){
						stack.pop();
					}else{
						stack.push(s.charAt(i));
					}
					break;
				default:
					stack.push(s.charAt(i));
					break;
			}
			i++;
		}
		return stack.empty();
	}
	/*
	 *you should use ctrl + c to stop this program
	 */
	public static void main(String[] args){
		ValidBrackets v = new ValidBrackets();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String s = sc.nextLine();
		 	System.out.println(v.validateBrackets(s));
		 	System.out.println(v.isValid(s));
		}
	}
}
