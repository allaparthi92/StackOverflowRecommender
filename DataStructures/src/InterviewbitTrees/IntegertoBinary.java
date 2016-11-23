package InterviewbitTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IntegertoBinary {

	public static String integertoBinary(int a) {
		StringBuilder result = new StringBuilder();
		if (a == 0)
			return "0";
		while (a > 1) {
			int rem = a % 2;
			a = a / 2;
			result.insert(0, rem);
		}
		result.insert(0, a);
		return result.toString();
	}

	public static ArrayList<Integer> sieve(int a) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean flag = true;
		for(int i=2;i<=a;i++){
			flag = true;
			int upperlimit =  (int)(Math.sqrt(i));
			for(int j=2;j<= upperlimit;j++){
				if(i%j==0){
					flag = flag && false;
					break;
				}
			}if(flag){
				result.add(i);
			}		
		}
			
		return result;
	}
	
	public static ArrayList<Integer> primesum(int a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		
		 ArrayList< ArrayList<Integer>> mainresult = new ArrayList< ArrayList<Integer>>();
		 result = sieve(a);
		 Integer i=0;
		 Integer j= result.size()-1;
		 while(i< result.size() && j >=0){
			 if(result.get(i)+ result.get(j) < a){
				 i++;
			 }
			 else if(result.get(i)+ result.get(j) > a){
				 j--;
			 }
			 
			 else{
				 ArrayList<Integer> subresult = new ArrayList<Integer>();
				 subresult.add(result.get(i));
				 subresult.add(result.get(j));
			
				 mainresult.add(subresult);
				break;
			 }
		 }
		
		
		 return mainresult.get(0);
    }
	
	public int isPrime(int a) {
		if(a < 2)
			return 0;
		else if(a==2)
			return 1;
		else if(a%2==0)
			return 0;
		int upperlimit =  (int)(Math.sqrt(a));
		for(int j=3;j<= upperlimit;j= j= j+2){
			if(a%j==0)
				return 0;
		}
		return 1;
	}
	public static ArrayList<Integer> allFactors(int a) {
		 int upperlimit = (int)(Math.sqrt(a));
	    ArrayList<Integer> factors = new ArrayList<Integer>();
	    for(int i=1;i <= upperlimit; i+= 1){
	        if(a%i == 0){
	            factors.add(i);
	            if(i != a/i){
	                factors.add(a/i);
	            }
	        }
	    }
	    Collections.sort(factors);
	    System.out.println(factors);
	    return factors;
	}
	 
	public int gcd(int a, int b) {
	     ArrayList<Integer> result1 = new ArrayList<Integer>();
	      ArrayList<Integer> result2 = new ArrayList<Integer>();
	      if(a == b)
	        return a;
	        if( a > b){
	            result1 = allFactors(a);
	            result2 = allFactors(b);
	        }
	        else{
	             result1 = allFactors(b);
	            result2 = allFactors(a);
	        }
	      
	        
	    for(int i=result2.size()-1; i >=0 ;i--){
	        if(result1.contains(result2.get(i)))
	            return result2.get(i);
	    }
	    return 0;
	}
	public static int titleToNumber(String a) {
		int sum =0;
		for(int i=0;i<a.length();i++){
			int x = a.charAt(i)- 'A' + 1;
			sum = sum * 26 + x;
		}
		return sum;
	}
	public static String convertToTitle(int a) {

	StringBuilder result = new StringBuilder();
	if (a == 0)
		return "0";
	while (a > 25) {
		int rem = a % 26;
		char ch = (char)(rem - 1 + 'A');
		a = a / 26;
		result.insert(0, ch);
	}
	result.insert(0, (char)(a - 1 + 'A'));
	return result.toString();
	}
	
	public static boolean isPalindrome(int a) {
		
		int rem =0;
	
		int x = a;
		while(a > 0){
			int val = a%10;
			a= a/10;
			rem = rem *10 + val;
		}
		if(x==rem)
			return true;
		else
			return false;
	}
	
	public static int reverse(int a) {
	 int max = Integer.MAX_VALUE;
	 int min = Integer.MIN_VALUE;
		long rem =0;
		int x = a;
		if(a < 0)
			a = a* -1;
	
		while(a > 0){
			int val = a%10;
			a= a/10;
			
				rem = rem *10 + val;
			
			
		}
		if((int)rem > max)
			return 0;
		if(x < 0)
			return (int) ((int)-1*rem);
		else
			return (int) (rem);
	}
	
	public static int trailingZeroes(int n) {
		  int number = 0;
		    while(n!=0){
		        number += n/5;
		        n /=5;
		    }
		    return number;
	}
	
	public static void arrange(ArrayList<Integer> a) {
		   ArrayList<Integer>  b = new ArrayList<Integer>(a);
			  for(int i=0;i<a.size();i++){
				        
						a.set(i, b.get(a.get(i)));
					
				}
		System.out.println(a);
	}
	
	  public static int findRank(String A) {
		  
	        int length = A.length();
	        long strFactorial = factorial(length);
	        long rank = 1;
	        for(int i = 0; i < length; i++){
	            strFactorial /= length - i;
	            rank += findSmallerInRight(A, i, length - 1) * strFactorial;
	        }
	        System.out.println("Rank : "+ Integer.MAX_VALUE);
	        rank %= 1000003;
	        return (int)rank;
	    }
	    
	    public static long factorial(int n){
	        return n <= 1? 1: (n * factorial(n - 1));
	    }
	    public static int findSmallerInRight(String A, int low, int high){
	        int countRight = 0;
	        for(int i = low + 1; i <= high; i++){
	            if(A.charAt(i) < A.charAt(low))
	                countRight++;
	        }
	        return countRight;
	    }
	    
	  @SuppressWarnings("rawtypes")
	public static int findRankRepeated(String A) {
	        
	        int length = A.length();
	        long strFactorial = factorial(length);
	        long rank = 1;
	        System.out.println("strFactorial: " + strFactorial);
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        for(int i = 0; i < length; i++){
	            if(!map.containsKey(A.charAt(i)))
	                map.put(A.charAt(i),1);
	            else
	                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);                            
	        }
	        
	        long repCharFactorial = 1;
	        Iterator it = map.entrySet().iterator();
	        while (it.hasNext()) {
	            Map.Entry pair = (Map.Entry)it.next();
	            repCharFactorial *= factorial((int)pair.getValue());
	            System.out.println(pair.getKey() + " = " + pair.getValue());
	            it.remove(); // avoids a ConcurrentModificationException
	        }
	        
	        System.out.println("repCharFactorial: " + repCharFactorial);
	        //strFactorial = strFactorial / repCharFactorial;
	        System.out.println("strFactorial: " + strFactorial);
	        
	        for(int i = 0; i < length; i++){
	            System.out.println("For i = " + i);
	            
	            if((i+1) <= length -1 && A.charAt(i) == A.charAt(i+1))
	                continue;
	            
	            strFactorial /= length - i;
	            System.out.println("\t strFactorial: " + strFactorial);
	            System.out.println("\t countRight: " + (findSmallerInRight(A, i, length - 1)));
	            rank += (findSmallerInRight(A, i, length - 1) * strFactorial);
	        }
	        rank = rank/repCharFactorial;
	        rank = rank % 1000003;
	        return (int)rank;
	    }
	    
	  public static long rankPerm(String perm) {
		    long rank = 1;
		    long suffixPermCount = 1;
		    java.util.Map<Character, Integer> charCounts =
		        new java.util.HashMap<Character, Integer>();
		    for (int i = perm.length() - 1; i > -1; i--) {
		        char x = perm.charAt(i);
		        int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
		        charCounts.put(x, xCount);
		        for (java.util.Map.Entry<Character, Integer> e : charCounts.entrySet()) {
		            if (e.getKey() < x) {
		                rank += suffixPermCount * e.getValue() / xCount;
		            }
		        }
		        suffixPermCount *= perm.length() - i;
		        suffixPermCount /= xCount;
		    }
		    return rank;
		}
	public static void main(String[] args) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(4);
		result.add(0);
		result.add(2);
		result.add(1);
		result.add(3);
		
		findRankRepeated("SSTRING");
	}

}
