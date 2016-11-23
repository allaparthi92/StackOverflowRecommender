package programcreek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	static int LongestConsecutiveSequence(int a[]){
		Set<Integer> s = new HashSet<Integer>();
		int count=0; 
		int min = Integer.MIN_VALUE;
		for( int e : a)
			s.add(e);
		
		ArrayList<Integer> al = new ArrayList<Integer>(s);
		Collections.sort(al);
		System.out.println(al);
		for(int i=0;i<al.size()-1;i++){
			
			if(Math.abs(al.get(i+1)-al.get(i))==1){
				count++;
				min = count;
			}
			else{
				
				min = Math.max(min, count);
				count=0;
			}
		}
		return min+1;
	}
	public static void main(String[] args) {
	int a[]={4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
	System.out.println(LongestConsecutiveSequence(a));
	}

}
