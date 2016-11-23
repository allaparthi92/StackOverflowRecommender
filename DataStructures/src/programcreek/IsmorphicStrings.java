package programcreek;

import java.util.HashMap;

public class IsmorphicStrings {
	
	public static void main(String args[]){
		String S = "";
		String T = "bat";
		System.out.println(IsIsmorphic(S,T));
	}

	private static boolean IsIsmorphic(String s, String t) {
		boolean result = true;
		if(s.length()==0 && t.length()==0)
			return true;
		
		if(s.length()!=t.length())
			return false;
		HashMap<Character,Character> hm = new HashMap<Character,Character>();
		
		for(int i=0;i<s.length();i++){
			if(hm.containsKey(s.charAt(i))){
				if(hm.get(s.charAt(i)).equals(t.charAt(i))){
					result = result && true;
				}
				else
					return false;
			}
			else if(hm.containsValue(t.charAt(i))){
				return false;
			}else
				hm.put(s.charAt(i), t.charAt(i));
			
		}
		
		return result;
	}
}
