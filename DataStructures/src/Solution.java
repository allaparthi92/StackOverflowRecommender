import java.util.HashSet;
import java.util.Set;

class Solution{
	
	public static int longestDuplicate(String s){
		if(s==null || s.length()==0)
	        return 0;
	 
		Set<Character> hm = new HashSet<Character>();
		int max = Integer.MIN_VALUE;
		int start =0;
		for(int i=0;i<s.length();i++){
			if(!hm.contains(s.charAt(i))){
				hm.add(s.charAt(i));
			}
			else{
				int size = hm.size();
				max = Math.max(max, size);
				
				while(start<i&&s.charAt(start)!=s.charAt(i)){
	                hm.remove(s.charAt(start));
	                start++;
	            }
				
			}
		}
		max = Math.max(max, hm.size());
		return max;
	}
	
	public static void main(String args[]){
		System.out.println(longestDuplicate("eabcadf"));
	}
}