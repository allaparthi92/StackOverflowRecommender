import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class MinStack {
	
	 public ArrayList<Integer> prevSmaller(ArrayList<Integer> a) {
	        
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        
	        Stack<Integer> s = new Stack();
	        
	        if(a==null)
	            return result;
	        
	        result.add(-1);
	        
	        for(int i=0;i<a.size();i++){
	           
	            if(s.isEmpty()){
	                s.push(a.get(i));
	                continue;
	            }
	           while(!s.isEmpty()){
	               
	              if(s.peek() < a.get(i)){
	                  result.add(s.peek());
	                  break;
	                  
	              }
	                else{
	                    int x = s.pop();
	                  
	                }
	           }
	           
	           if(s.isEmpty()){
	               result.add(-1);
	           }
	           
	        
	          s.push(a.get(i));
	        }
	        
	        return result;
	    }
	 public static void main(String args[]){
		 ArrayList<Integer> x = new  ArrayList<Integer>();
		 x.add(34);
		 x.add(35);
		 x.add(27);
		 x.add(42);
		 x.add(5);
		 x.add(28);
		 x.add(39);
		 x.add(20);
		 x.add(28);
	 }
}