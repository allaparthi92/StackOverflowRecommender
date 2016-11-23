package arraysAndStrings;

public class StringUniqueCharacters {

	public static boolean UniqueCharacters(String input) {
		if (null == input || input.length() == 0)
			return true;
		input = input.toLowerCase();
		int result = 0;
		for (int i = 0; i < input.length(); i++) {

			int diff = input.charAt(i)-'a';
			
			if((result& (1<<diff)) > 0){
				return false;
			}
			
			result= result | diff;
			
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(UniqueCharacters("bhanaaaaaau"));
	}

}
