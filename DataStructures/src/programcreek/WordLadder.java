package programcreek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("hot");s.add("dot");s.add("dog");s.add("lot");s.add("log");
		Ladder(s,"hit","cog");
	}

	private static int Ladder(List<String> s,String begin, String end) {

		s.add(end);
		Queue<String> q = new LinkedList<String>();
		q.offer(begin);
		int level =0;
		
		while(!q.isEmpty()){
			int size = q.size();
			while(size-- > 0){
			
				String word = q.poll();
				if(word.equals(end)){
					System.out.println(level+1);
					return level+1;
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
							}
							chars[i] = word.charAt(i);
						}
					}
					
				}
			}
			level++;
		}
		
		return 0;
	}
	
}
