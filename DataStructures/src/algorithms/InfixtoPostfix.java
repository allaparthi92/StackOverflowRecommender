package algorithms;
import java.io.*;
import java.util.Stack;

public class InfixtoPostfix {
	boolean Isoperand(char ch){
		if((ch >= 'a' && ch<='z') || (ch>='A' && ch<='Z'))
			return true;
		return false;
	}
	
	int CheckPredence(char ch){
		switch (ch)
	    {
	    case '+':
	    case '-':
	        return 1;
	 
	    case '*':
	    case '/':
	        return 2;
	 
	    case '^':
	        return 3;
	    }
	    return -1;
	}
	void InfixtoPostfix(String str){
		Stack s = new Stack();
		
		for(int i=0;i<str.length();i++){
			if(Isoperand(str.charAt(i))){
				System.out.print(str.charAt(i));
			}
			
			else if(str.charAt(i)== '('){
					s.push(str.charAt(i));
				}
				
				else if(str.charAt(i)== ')'){
					
					while(!s.isEmpty() && (char) s.peek() != '('){
						char c = (char) s.pop();
						System.out.print(c);
				
					}
					s.pop();
				}
		
				else{
					while(!s.isEmpty() && (CheckPredence(str.charAt(i)) <= CheckPredence((char)s.peek()))){
						char c = (char) s.pop();
						System.out.print(c);
					}
					s.push(str.charAt(i));
				}
		}
			while(!s.isEmpty() ){
				char c = (char) s.pop();
				System.out.print(c);
			
		}
			}
			
				
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixtoPostfix obj = new InfixtoPostfix();
		obj.InfixtoPostfix("a+b*(c^d-e)^(f+g*h)-i");
	}

}
