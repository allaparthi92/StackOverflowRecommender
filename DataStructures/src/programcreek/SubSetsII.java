package programcreek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubSetsII {

	public static ArrayList<ArrayList<Integer>> SubSetsduplicates(int a[]){
		int n = a.length;
		Arrays.sort(a);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<>();
		if(n<0)
			throw new IllegalArgumentException("wrong input");
		else
		{
			result.add(temp);
			ArrayList<ArrayList<Integer>> temp1 = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<n;i++){
				
				for(ArrayList al :result){
					ArrayList x = new ArrayList<Integer>();
					x.addAll(al);
					x.add(a[i]);
					temp1.add(x);
				}
				
				result.addAll(temp1);
			}
			Set s = new HashSet();
			s.addAll(temp1);
			result.clear();
			result.addAll(s);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		
		int a[] = {1,4,2};
		System.out.println(SubSetsduplicates(a));
	}

}
