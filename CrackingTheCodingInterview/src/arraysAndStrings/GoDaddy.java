package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GoDaddy {

	static String[] missingWords(String s, String t) {

		if (s == null || t == null) {
			return null;
		}

		String inputArray[] = s.split(" ");
		String input[] = t.split(" ");
		List<String> result = new ArrayList<String>();
		for (int i = 0, j = 0; i < inputArray.length; i++) {
			if (!inputArray[i].equals(input[j])) {
				System.out.println(inputArray[i]);
				result.add(inputArray[i]);

			} else {
				if (j >= input.length - 1) {
					j = input.length - 1;
				} else {
					j++;
				}
			}
		}

		System.out.println(result);
		return result.toArray(new String[0]);

	}

	static String[] buildSubsequences(String str) {

		char input[] = str.toCharArray();
		int pow_set_size = (int) Math.pow(2, str.length());
		String result[] = new String[pow_set_size-1];
		
		for (int counter = 0; counter < pow_set_size; counter++) {
			for (int j = 0; j < input.length; j++) {
				if ((counter & (1 << j)) == 0) {
						if (result[counter] != null) {
							result[counter] = result[counter] + input[j];
						} else {
							result[counter] = ""+input[j] ;
						}
				}
			}

		}
		System.out.println(Arrays.asList(result));
		return result;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		missingWords("I am using hackerrank to improve programming",
				"am hackerrank to improve");
		buildSubsequences("abc");

	}

}
