package programcreek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets {

	public static List<Set> subsets(int n){
		List<Set> al = new ArrayList<Set>();
		Set s = new HashSet<Integer>();
		
		if(n<0){
			throw new IllegalArgumentException("input cannot be negative");
			
		}
		else{
			
				al.add(s);
			
			for(int i=1;i<=n;i++){
				List<Set> al1 = new ArrayList<Set>();
					for(Set a : al){
						Set ss = new HashSet<Integer>();
						ss.addAll(a);
						ss.add(i);
						al1.add(ss);
					}
					
					al.addAll(al1);
				}
				
		}
		return al;
		
	}
	public static void main(String[] args) {
		
		System.out.println(subsets(3));
	}

}
