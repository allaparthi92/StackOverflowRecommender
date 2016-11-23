package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LRU {

	LinkedList<Integer> list = new LinkedList<Integer>();
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	int capacity;
	int size = 0;

	public LRU(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!list.contains(key)) {
			return -1;
		} else {
			list.remove(new Integer(key));
			list.addFirst(new Integer(key));
			return hm.get(key);
		}
	}

	public void set(int key, int value) {

		if (size == capacity) {

			int val = list.removeLast();
			hm.remove(val);
			size--;

		}
		if (list.contains(new Integer(key))) {
			list.remove((key));
		}
		list.addFirst(key);
		hm.put(key, value);
		size++;
	}

	public static void main(String args[]) {
		LRU sol2 = new LRU(1);
		sol2.set(2, 1);
//		System.out.println(sol2.get(2));
//		sol2.set(3, 2);
//		System.out.println(sol2.get(2));
//		System.out.println(sol2.get(3));
//		System.out.println(colorful(263));
		colorful(23);
	}
	
	public static int PowerSet(int a) {
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		ArrayList<Integer>  list = new ArrayList<>();
		String str = String.valueOf(a);
		        int n = str.length();
		 
		      
		        for (int i = 1; i < (1<<n); i++)
		        {
		        	int prod =1;
		            for (int j = 0; j < n; j++){
		 
		                
		                if ((i & (1 << j)) > 0){
		                	prod = prod * Integer.parseInt(str.charAt(j)+"");
		                }
		                
		            }
		            
		                 if(list.contains(prod)){
		                	 return 0;
		                 }
		                 else{
		                	 list.add(prod);
		                 }
		          
		        }
		return 1;
	}
	
	public static int colorful(int a) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		ArrayList<String>  list = new ArrayList<>();
		ArrayList<Integer>  plist = new ArrayList<>();
		String str = String.valueOf(a);
		        int n = str.length();
		     for(int i=1;i<=n;i++){
		    	 
		    	 for(int j=0;j<=n-i;j++){
		    		 list.add(str.substring(j, j+i)) ;
		    	 }
		     }
		     System.out.println(list);
		for(String x : list){
			int prod =1;
			for(int i=0; i< x.length();i++){
				prod*=Integer.parseInt(x.charAt(i)+"");
			}
			  if(plist.contains(prod)){
             	 return 0;
              }
              else{
            	  plist.add(prod);
              }
		}
		return 1;
		
	}
	
	 public ArrayList<Integer> lszero(ArrayList<Integer> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int start =0;
		 int end = 0;
		 for(int i=0;i<a.size();i++){ 
			 int sum = 0;
			 for(int j=i;j<a.size();j++){
				 sum+=a.get(j);
				 if(sum ==0 && ((j-i) > (end - start))){
					 end = j;
					 start =i;
				 }
			 }
			 
		 }
		 
		 for(int i= start ; i <=end;i++){
			 result.add(a.get(i));
		 }
		return a;
	    }
	 
	 public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		 
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 HashMap<Integer,Integer> hm = new HashMap<>();
		 int start =-1;
		 int end =-1;
		 for(int i=0;i< a.size();i++){
			 int diff = b-a.get(i) ;
			
			 if(hm.containsKey(diff)){
				 end = i;
				 start = a.get(diff);
				 result.add(start);
				 result.add(end);
				 break;
			 }
			 else{
				 hm.put(a.get(i), i);
			 }
		 }
		return result;
		 
		}
	
}
