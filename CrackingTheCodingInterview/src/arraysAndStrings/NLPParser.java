package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NLPParser {

	class ListNode {
		String value;
		ListNode parent;
		List<ListNode> al = new ArrayList<>();
	}

	public static void main(String[] args) {
		
	
		String input = "(NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages))))";

		String[] array = (input.split(" "));
		Stack<String> s = new Stack();
		int count =0;
		for (String string : array) {
			System.out.println(string);

			if (string.contains("(")) {
				s.push(string);
				
			}
			
			else if (string.contains(")")){
				for(int j=0;j<string.length();j++){
					if(string.charAt(j)== ')'){
						count++;
					}
				}
				
			}
		}
	}

}
