package InterviewbitTrees;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class StackClass {

	public static int braces(String a) {

	
		    
		    if (a == null) {
				return 0;
			}
			char prev = 'a';
			boolean flag = true;
			boolean operater = false;
			Stack<Character> s = new Stack<Character>();

			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == ')') {
					flag = true;
					
					while (flag) {
						char x = s.pop();
				        if(x=='+' || x== '/' || x== '*'|| x=='-'){
				        	operater = true;
				        }
				
						if (x == '(') {
							flag = false;
							if(prev == '(' && x == '('){
								return 1;
							}
						}
						 prev = x;
					}
					if(!operater)
						return 1;

				} else {
					s.push(a.charAt(i));
				}
			}
			
				
				
		        return 0;


		
	}
	
public static int evalRPN(ArrayList<String> a) {
		
		int result = 0;
		
		Stack<String> s = new Stack<String>();
		for(int i=0;i<a.size();i++){
			if(a.get(i)== "+" ||a.get(i)== "-" || a.get(i)== "*" || a.get(i)== "/"){
				
				int val2 = Integer.parseInt(s.pop());
				int val1 = Integer.parseInt(s.pop());
				 result = evaluate(val1,val2,a.get(i));
				 s.push(Integer.toString(result));
			}
			else{
				s.push(a.get(i));
			}
		}
		
		
		return Integer.parseInt(s.pop());
		
		
	}

	
	private static int evaluate(int val1, int val2, String string) {
		if(string == "+")
			return val1 + val2;
		else if(string == "-")
			return val2 - val1;
		else if(string == "*")
			return val1 + val2;
		else 
			return val2 / val1;
	
		
	}
	public String simplifyPath(String a) {
		String result = "";
		int index =0;
		for(int i=a.length()-1;i>=0;i--){
			if(a.charAt(i)== '.'){
				result =  a.substring(i+1, a.length()-1);
				index =i;
				break;			
			}	
		}
		
		if(result.charAt(result.length()-1)=='/' && result.length()> 1)
			return result.substring(0, result.length()-2);
		
		
		return result;

	
	}
	
	public int isValid(String a) {
		
		Stack<Character> s = new Stack<Character>();
		
		for(int i=0;i<a.length();i++){
			
			if(a.charAt(i)== ')' || a.charAt(i)== '}' || a.charAt(i)== '}'){
				if(s.isEmpty())
					return 0;
				char x = s.pop();
				if(x=='(' && a.charAt(i)== ')'){
				}
				else if(x=='{' && a.charAt(i)== '}'){
					
				}
				else if(x=='[' && a.charAt(i)== ']'){
					
				}
				else
					return 0;
					
			}
			else{
				s.push(a.charAt(i));
			}
			
		}
		if(s.isEmpty())
			return 1;
		else
			return 0;
		
		
	}
	
	public String reverseString(String a) {
	    StringBuilder result = new StringBuilder();
	    Stack<Character> s = new Stack();
	    
	    for(int i=0;i<a.length()-1;i++){
	        s.push(a.charAt(i));
	    }
	    while(!s.isEmpty()){
	        result.append(s.pop());
	    }
	    
	    return result.toString();
	}
	
	
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	     long sum =0;
	     long maxsum =0;
	     int start = 0;
	     int end = 0;
	     int startmax = 0;
	     int endmax =0;
	    if(a==null)
	        return result;
	    for(int i=0;i<a.size();i++){
	        if(a.get(i) < 0 ){
	        	if(sum > maxsum){
	        		maxsum = sum;
	        		sum =0;
	        		endmax = i-1;	
	        		startmax = start;
	        		
	        	}
	        	else if(sum == maxsum){
	        		if(start-i-1 > endmax - startmax){
	        			startmax = start;
	        			endmax = i-1;
	        		}
	        	}
	       
	        	else{
	        		start = i+1;
	        		sum =0;
	        	}
	        
	            
	        }
	        else{
	       
	        	sum = sum + a.get(i);
	            result.add(a.get(i));
	            
	        }
	    }
	    
	  return result;
	}
	
	public int repeatedNumber(final List<Integer> a) {
	    
	    HashSet<Integer> h = new HashSet<Integer>();
	    
	    for(Integer x : a){
	        if(h.contains(x))
	            return x;
	        else
	            h.add(x);
	    }
	    
	    return -1;
	}
	
	public int firstMissingPositive1(ArrayList<Integer> A) {

        int i = 0;
        while(i < A.size()){
            if(A.get(i) == i+1 || A.get(i) <= 0 || A.get(i) > A.size()) i++;
            else if(A.get(A.get(i)-1) != A.get(i)) swap(A, i, A.get(i)-1);
            else i++;
        }
        i = 0;
        while(i < A.size() && A.get(i) == i+1) i++;
        return i+1;
    }
    
    public void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }
    
    
    public int trap(final List<Integer> a) {
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    
    	for(int i=0;i<a.size();i++){
    		
    	
    		
    	}
		return 0;
	}
	
	
	public int firstMissingPositive(ArrayList<Integer> a) {
		
		for(int i=1; i<=a.size()-1 ; i++){
			if(!a.contains(i))
				return i;
				
		}
			
		return 1;
		
		
	}
	public static  ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		
		    int l = A.size();
		    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        for (int d = 0; d < 2 * l - 1; ++d) {
	    	   
		        ArrayList<Integer> row = new ArrayList<Integer>();
		        for(int i=0;i<=d;i++)
		        {
		            if(i<l && d-i<l)
		             row.add(A.get(i).get(d-i));
		        }
		        res.add(row);
	        }
	        return res;
		}
		 
	
	public static String largestNumber(final ArrayList<Integer> a) {
		String result = new String();
		
		if(a==null)
			return null;
		result = result +(a.get(0));
		for(int i=1;i<a.size();i++){
			String result1 = result +(a.get(i));
			long x =  Long.parseUnsignedLong(result1);
			String result2 = (a.get(i))+ result;
			long y =  Long.parseUnsignedLong(result2);
			
			if(x>=y){
				result = result1;
			}else{
				result = result2;
			}
			
		}
		
		return result;
		
	}
	public String largestNumber(final List<Integer> a) {
		 
		  if (a == null || a.size() == 0) return "";
	        String[] strs = new String[a.size()];
	        for (int i = 0; i < a.size(); i++) {
	            strs[i] = a.get(i)+"";
	        }
	        Arrays.sort(strs, new Comparator<String>() {
	            @Override
	            public int compare(String i, String j) {
	                String s1 = i+j;
	                String s2 = j+i;
	                return s1.compareTo(s2);
	            }
	        });
	        if (strs[strs.length-1].charAt(0) == '0') return "0";
	        StringBuilder res = new StringBuilder();
	        for (int i = 0; i < strs.length; i++) {
	            res.insert(0,strs[i]);
	        }
	        return res.toString();
	}
	
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		Set<Integer> x = new HashSet<Integer>();
		Set<Integer> y = new HashSet<Integer>();
		for(int i=0;i<a.size();i++){
			for(int j=0;j<a.get(0).size();j++){
				if(a.get(i).get(j) == 0){
					x.add(i);
					y.add(j);
				}
			}
		}
		
		for(int i=0;i<a.size();i++){
			if(x.contains(i)){
				for(int j=0;j<a.size();j++)
					a.get(i).set(j, 0);
			}
		}
		for(int j=0;j<a.size();j++){
			if(y.contains(j)){
				for(int i=0;i<a.size();j++)
					a.get(i).set(j, 0);
			}					
			}
		}
	
	public static int maximumGap(final List<Integer> a) {
	    
	    if(a.size()< 1)
			return -1;
		if(a.size()== 1)
			return 0;
		int maxGap = Integer.MIN_VALUE;
		
		boolean flag = false;
		int max = a.get(0);
		for(int i=0;i<a.size();i++){
			for(int j=i+1;j<a.size();j++){
				if((long)a.get(i) <= (long)a.get(j)){
					int gap = j-i;
					flag = true;
					maxGap = Math.max(gap, maxGap);
				}
				max = Math.max(max, a.get(j));
			}
		}
		
		if(flag)
			return maxGap;
		else if(max == a.get(0))
			return 0;
		else
			return -1;
	}
	
	public static int maximumGap1(final List<Integer> a) {
		 
		    
		 int maxDiff;
	        int i, j;
	 
	        int RMax[] = new int[a.size()];
	        int LMin[] = new int[a.size()];
	 
	        /* Construct LMin[] such that LMin[i] stores the minimum value
	           from (arr[0], arr[1], ... arr[i]) */
	        LMin[0] = a.get(0);
	        for (i = 1; i < a.size(); ++i)
	            LMin[i] = Math.min(a.get(i), LMin[i - 1]);
	 
	        /* Construct RMax[] such that RMax[j] stores the maximum value
	           from (arr[j], arr[j+1], ..arr[n-1]) */
	        RMax[a.size() - 1] = a.get(a.size()-1);
	        for (j = a.size() - 2; j >= 0; --j)
	            RMax[j] = Math.max(a.get(j), RMax[j + 1]);
	 
	        /* Traverse both arrays from left to right to find optimum j - i
	           This process is similar to merge() of MergeSort */
	        i = 0; j = 0; maxDiff = -1;
	        while (j <   a.size() && i < a.size()) 
	        {
	            if (LMin[i] < RMax[j]) 
	            {
	                maxDiff = Math.max(maxDiff, j - i);
	                j = j + 1;
	            } 
	            else
	                i = i + 1;
	        }
	 
	        return maxDiff;
		    
	}

	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
	
		a.add(2);
		a.add(1);
		a.add(0);
	
		
		System.out.println(maximumGap1(a));
	}

}
