package programcreek;

import java.util.HashMap;

public class Anagrams {
	static boolean anagrams(String s,String t){
		
		if(s.length()!=t.length())
			return false;
			
		if(s.length() == 0 || t.length()==0)
				
			return true;
		HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			if(hm.containsKey(s.charAt(i)))
				hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
			else
				hm.put(s.charAt(i),1);
		}
		
		for(int i=0;i<t.length();i++){
			if(hm.containsKey(t.charAt(i))){
				if(hm.get(t.charAt(i))==1)
					hm.remove(t.charAt(i));
				else
					hm.put(t.charAt(i), hm.get(t.charAt(i))-1);
			}
			else
				return false;
		}
		
		if(hm.size()!=0){
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
	
		System.out.println(anagrams("cat", "tac"));
	}

}
