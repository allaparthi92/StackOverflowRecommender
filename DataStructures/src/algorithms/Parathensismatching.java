package algorithms;

import java.util.Stack;

public class Parathensismatching {

	boolean Checkparanthesis(String str){
		Stack s = new Stack();
		char x = 'a';
				boolean result = true;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='['){
				s.push(str.charAt(i));
			}
			else {
				if(!s.isEmpty())
					x = (char) s.pop();
	
			if( (str.charAt(i) == ')') && x == '('){
				s.pop();
				result = result && true;
			}
			else if( (str.charAt(i) == '}') && x == '{'){
				s.pop();
				result = result && true;
			}
			else if( (str.charAt(i) == ']') && x == '['){
				s.pop();
				result = result && true;
			}
			else{
				
				
				
				return false;
			}
			}
		}
		if(s.isEmpty())
			result  = result = result && true;
		else
			result  = result = result && false;
		System.out.println(result);
		return result;
		
	}
	
	
	
	

	
	public static void main(String[] args) {
	}

}
