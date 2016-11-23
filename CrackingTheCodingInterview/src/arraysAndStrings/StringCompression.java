package arraysAndStrings;

public class StringCompression {

	public static void stringCompression(String input) {
		StringBuilder result = new StringBuilder();
		int counter = 0;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i - 1) == input.charAt(i)) {
				counter++;
			} else {
				counter++;
				result.append(input.charAt(i - 1)).append(counter);
				counter = 0;
			}
		}

		result.append(input.charAt(input.length() - 1)).append(++counter);

		System.out.println(result);
	}

	public enum Color {
		REd, GREEN;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringCompression("aaabbccde");
	}

}
