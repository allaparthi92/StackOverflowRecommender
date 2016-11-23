
import java.util.Stack;

public class Testing {

	public static void main(String[] args) {

		String input = "(NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages)))) (";
		System.out.println(solution(input));
	}

	public static String solution(String input) {
		StringBuilder result = new StringBuilder();
		String[] array = (input.split(" "));
		Stack<String> stack = new Stack<>();
		int count = 0;
		for (String string : array) {
			if (string.contains("(")) {
				stack.push(string);
			} else if (string.contains(")")) {
				String y = string.replace(")", "");
				result.append(y + " ");
				for (int j = 0; j < string.length(); j++) {
					if (string.charAt(j) == ')') {
						count++;
					}
				}
				while (count > 0) {
					count--;
					stack.pop();
				}

			}
		}
		while(stack.isEmpty()){
			return result.substring(0, result.length() - 1);
		}
		return "Invalid Parse Tree";
	}

}