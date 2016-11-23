package arraysAndStrings;

import java.util.HashMap;

public class PerumutationofOneorOther {
	
	public static boolean PermutationString(String a, String b){
		
		if(a.length()!= b.length()){
			return false;
		}
		
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i=0;i<a.length();i++){
			if(hm.containsKey(a.charAt(i))){
				hm.put(a.charAt(i), hm.get(a.charAt(i))+1);
			}
			else{
				hm.put(a.charAt(i),1);
			}
		}
		
		for(int i=0;i<b.length();i++){
			if(hm.containsKey(b.charAt(i))){
				hm.put(b.charAt(i), hm.get(b.charAt(i))-1);
				if(hm.get(b.charAt(i)) < 0){
					return false;
				}
			}
			else{
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(PermutationString("gods","ddog"));
	}

}
