package arraysAndStrings;

import java.util.Arrays;

public class NonRepeatingCharatcter {
	
	public static int nonRepeatingCharacter(String s){
		
		if(s==null||s.length()==0){
			return -1;
		}
		if(s.length()==1){
			return 0;
		}
		
		int index[] = new int[26];
	
	
		
		for(int i=0;i<s.length();i++){
			
			int offset = s.charAt(i)-'a';
			
			if(index[offset] == 0){
				index[offset] = i;
			}
			else if(index[offset] > 0){
				index[offset] = -1;
			}		
		}
		
		int res=Integer.MAX_VALUE;
		System.out.println(Arrays.toString(index));
		for(int i=0;i<26;i++){
		    	int offset = s.charAt(i)-'a';
			if(index[offset] >= 0){
			    return index[offset];
			}
		}
		
		return -1;
	}
   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nonRepeatingCharacter("loveleetcode"));
	}

}
