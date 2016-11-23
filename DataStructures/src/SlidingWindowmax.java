import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import algorithms.LinkedList;


public class SlidingWindowmax {
	
	
	  public static ArrayList<Integer> maxSlidingWindow(int[] a, int k) {
	        
	 
				int max = Integer.MIN_VALUE;
				int sum =0;
				Queue<Integer> q = new java.util.LinkedList<Integer>();
				ArrayList<Integer> result = new ArrayList<Integer>();
				if(a==null)
					return result;
				
				for(int i=0;i<a.length;i++){
					if(q.size()==3){
							int max1 = maxminum(q);
							q.poll();
							max = max1;
							result.add(max);
						}
							
					q.offer(a[i]);
					
				}
				if(q.size()==3){
					int max1 = maxminum(q);
					result.add(max1);
				}
				return result;
		}
	  
		public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
			
			int max = Integer.MIN_VALUE;
			int sum =0;
			Queue<Integer> q = new java.util.LinkedList<Integer>();
			ArrayList<Integer> result = new ArrayList<Integer>();
			if(a==null)
				return result;
			if(b > a.size()){
				int max2 = a.get(0);
				for(int j=1;j<a.size();j++){
					if(a.get(j) > max2)
						max2 = a.get(j);
				}
				result.add(max2);
				return result;
			}
			for(int i=0;i<a.size();i++){
				if(q.size()==3){
						int max1 = maxminum(q);
						q.poll();
						max = max1;
						result.add(max);
					}
						
				q.offer(a.get(i));
				
			}
			if(q.size()==3){
				int max1 = maxminum(q);
				result.add(max1);
			}
			return result;
		}
	  
	  static int maxminum(Queue q){
		  
		  Object[] z = new Object[q.size()];
			z = q.toArray();
			int max1 = (int) z[0];
			for(int j=1;j<q.size();j++){
				if((int)z[j] > max1){
					max1 = (int)z[j]; 
				}
			}
		return max1;
	
		  
	  }
	  
	  
	  public static ArrayList<Integer> wave(ArrayList<Integer> a) {
		    ArrayList<Integer> result = new  ArrayList<Integer>();
		    Collections.sort(a);
		    if(a==null || a.size()==1){
		    	return a;
		    }
		    for(int i=0;i<a.size()-1;i=i+2){
		        int temp = a.get(i);
		        a.set(i,a.get(i+1));
		        a.set(i+1, temp);
		        
		    }
		    return a;
	  }
	  public static ArrayList<ArrayList<Integer>> generate(int a) {
		  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		  ArrayList<Integer> sub = new ArrayList<Integer>();
		  for(int i=1;i<=a;i++){
		  if(i==1){
			  sub.add(1);
			  result.add(sub);		  
		  }
		  else if(i==2){
			  sub = new ArrayList<Integer>();
			  sub.add(1);
			  sub.add(1);
			  result.add(sub);
		  }
		  if(i>2){
			  	sub = new ArrayList<Integer>();
			  	sub.add(1);
			  	 ArrayList<Integer> x = result.get(i-2);
			  	 for(int j=0;j<x.size()-1;j++){
			  		int y = x.get(j) + x.get(j+1);
			  		sub.add(y);
			  	 }
			  	 sub.add(1);
			  	 result.add(sub);
			  }
		  }
		  return result;
	  
		}
	  
	  public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		  
		  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		  
		  int n =0;
		  int j=0;
		  int k=0;
		  int m =0;
		  int p=0;
		  int [][] b = new int [a][a];
		  for(int i=0;i<=a-1;i++){
			  
			  for( j=i ; j< a-i ;j++){
				  n = n+1;
				  b[i][j] = n;
				  System.out.println(b[i][j]);
			  }
			  
			  for(k= i+1 ; k < a-i ;k++){
				  n= n+1;
				  b[k][j-1] = n; 
				  System.out.println(b[k][j-1]);
			  }
			  
			  for( m= j-1 ; m>i ;m--){
				  n= n+1;
				  b[k-1][m-1] = n; 
				  System.out.println(b[k-1][m-1]);
			  }
			  
			  for(p=k-2;p>i;p--){
				  n= n+1;
				  b[p][m]= n;
				  System.out.println(b[p][m]);
			  }
			 
		  }
		  for(int i=0;i<a;i++){
			  ArrayList<Integer> sub = new ArrayList<Integer>();
			  for(int q =0;q <a;q++){
				  sub.add(b[i][q]);
			  }
			  result.add(sub);
		  }
		return result;
		}
	  
	  public static ArrayList<Integer> spiralOrder(int [][] matrix) {
		  List<Integer> res = new ArrayList<>();
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
	        	return (ArrayList<Integer>) res;
	        
	        int m = matrix.length, n = matrix[0].length;
	        for (int i = 0; i <= Math.min(matrix.length, matrix[0].length) / 2 
	                        && m > 0 && n > 0; i++) {
	            // up row
	            for (int j = i; j < n + i; j++) {
	                res.add(matrix[i][j]);
	            }
	            // right column
	            for (int j = i+1; j < i+m; j++) {
	                res.add(matrix[j][i+n-1]);
	            }
	            
	            // bottom row
	            for (int j = i+n-2; m > 1 && j >= i; j--) {
	                res.add(matrix[i+m-1][j]);
	            }
	            
	            // left col
	            for (int j = i+m-2; n > 1 && j > i; j--) {
	                res.add(matrix[j][i]);
	            }
	            
	            
	            m -= 2;
	            n -= 2;
	        }
	        
	        return (ArrayList<Integer>) res;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> result = new  ArrayList<Integer>();
		 result.add(1);
//		 result.add(1);
//		 result.add(1);
//	
		 a.add(result);
		result = new  ArrayList<Integer>();
		 result.add(2);
//		 result.add(1);
//		 result.add(1);
		 a.add(result);
		 result = new  ArrayList<Integer>();
		 result.add(3);
//		 result.add(1);
//		 result.add(1);
		 a.add(result);
			
	}

}
