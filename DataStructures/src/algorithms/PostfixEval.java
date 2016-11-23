package algorithms;

import java.util.Stack;

public class PostfixEval{
	
	boolean Isnumber(char ch){
		if(ch >= '0' && ch<= '9')
			return true;
		return false;
		
	}
	int EvalOperands(int a, int b,char ch){
		switch(ch){
		case '+' : return (a+b);
		case '-' : return (b-a);
		case '*' : return (b*a);
		case '/' : return (b/a);
		case '^' : return (b^a);
		}
		return -1;
	}
	void PostfixEval(String str){
		
		Stack s = new Stack();
		
		for(int i=0;i<str.length();i++){
			
			if(Isnumber(str.charAt(i))){
				s.push(str.charAt(i));
			}
			else 
				{
				int a = Integer.parseInt(s.pop().toString()) ;
				int b = Integer.parseInt(s.pop().toString());
				int c = EvalOperands(a, b, str.charAt(i));
				s.push(c);
			}
		
		}
		System.out.println((int)s.peek());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostfixEval obj= new PostfixEval();
		obj.PostfixEval("231*+9-");
	}

}
