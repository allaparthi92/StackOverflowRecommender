package programcreek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("hot");s.add("dot");s.add("dog");s.add("lot");s.add("log");
		Ladder(s,"hit","cog");
	}

	private static ArrayList<ArrayList<String>> Ladder(List<String> s,String begin, String end) {
		ArrayList<ArrayList<String>>  al = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new  ArrayList<String>(); 
		ArrayList<ArrayList<String>>  sub = new ArrayList<ArrayList<String>>();
		s.add(end);
		Queue<String> q = new LinkedList<String>();
		q.offer(begin);
		int level =0;
		list.add(begin);
		al.add(list);
		
		while(!q.isEmpty()){
		
			int size = q.size();
			while(size-- > 0){
			
				String word = q.poll();
				if(word.equals(end)){
					return al;
				}
				char[] chars = word.toCharArray();
				for(int i=0;i<word.length();i++){
					for(int c=0; c<26;c++){
						if((char)('a'+c) != word.charAt(i)){
							chars[i] = (char)('a'+c);
							String newWord = new String(chars);
							if(s.contains(newWord)){
								s.remove(newWord);
								q.offer(newWord);
								for(ArrayList<String> a : al){
									
								}
								
							}
							
							chars[i] = word.charAt(i);
						}
					}
					
				}
			}
		
			level++;
			al.clear();
			al.addAll(sub);
			sub.clear();
		}
	
		
		return al;
	}
	
}

