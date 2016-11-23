import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class MaxSubArray {

	public static void main(String[] args) {
	
		
			int arr[] = {1, 0, 0, 1, 0, 0, 1, 0};
			int sum=0,maxsum=0,num=0;
			int startIndex=0,stopIndex=0,prevIndex=0;
			
			for(int i=0;i<arr.length;i++){
				if(arr[i] == 1){
					num = -1;
				}else if(arr[i] == 0){
					num = 1;
				}
				sum = sum + num;
				if(maxsum<sum){
					maxsum = sum;
					prevIndex = startIndex;
					stopIndex = i;
				}else if(sum<0){
					sum = 0;
					startIndex = i+1;
				}
			}
			System.out.println(prevIndex+1+"--"+stopIndex+1);
			for(int j=prevIndex;j<=stopIndex;j++){
				System.out.print(" "+arr[j]);
			}
			System.out.println(getRow1(2));
	}

	private static int MaxSubArray(int[] a) {
		
		int end = a.length;
		int sum =a[0];
		int currmax = a[0];
		for(int i=1;i<end;i++){	
			currmax =  Math.max(currmax + a[i], a[i]);
			sum = Math.max(sum,currmax);
		}
		System.out.println(sum);
		
		return sum;
		
		
	}
	
	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    
	    int carry = 1;
	    
	    for(int i= a.size()-1 ; i>=0 ; i--){
	    	int sum = carry + a.get(i);
	    	
	    	if(sum > 9){
	    		a.set(i, 0);
	    		carry =1;
	    	}
	    	else{
	    		a.set(i, sum);
	    		carry =0;
	    	}
	    	
	    }
	    if(carry == 1){
    		a.add(1);
	    Collections.reverse(a);
    }
	 while(a.get(0)==0){
		 a.remove(0);
	 }
		return a;
	}
	
	static int getOnes(String x){
		
		int count =0;
		for(int i=0;i<x.length();i++){
			if(x.charAt(i)=='1')
				count++;
		}
		return count;
		
	}
	
	static String getString(char[] x){
		
		StringBuilder count = new StringBuilder();
		for(int i=0;i<x.length;i++){
			count.append(x[i]);
		}
		return count.toString();
		
	}
	 public static ArrayList<Integer> flip(String A) {
		 
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(0);
		int j=0;
		char[] x = A.toCharArray();
		int max = getOnes(A);
		
		if(max == x.length-1){
			for(j=0;j<x.length;j++){
				
				if(x[j]== '0'){
					result.set(0, j+1);
					result.set(1, j+1);
				}
			}
			return result;
		}
			
		
		
		for( int i=0;i<x.length;i++){
			 x = A.toCharArray();
			for(j=0;j<=i;j++){
			
				if(x[j]== '0')
					x[j] = '1';	
				else
					x[j] = '0';
			
			}
			 String str = getString(x);
			int z = getOnes(str);
			if( z > max ){
				max = z;
				result.set(0, i+1);
				result.set(1, j);
			}
		}
		while(result.get(0)== 0){
		    result.remove(0);
		}
		 System.out.println(result.get(0)+"---"+result.get(1));
		return result;
	    }
	 
		public static ArrayList<Integer> getRow(int rowIndex) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			
		    long c = 1;
		    for (int j = 0; j <= rowIndex; j++) {
		      result.add((int) c);
		      c *= rowIndex - j;
		      c /= j + 1;
		    }
		    return result;
		    
		}
		
		public static ArrayList<Integer> getRow1(int rowIndex) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			
		   result.add(5);
		   result.add(2);
		   result.remove(new Integer(5));
		   System.out.println(result);
		    return result;
		    
		}
}
