package LinkedLists;

public class Pattern {

	public static void printPattern(int n) {
		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}

		for (int i = 5; i >= 1; i--) {

			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}

	}

	public static String maskNumber(String s) {

		StringBuilder maskedString = new StringBuilder();
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			count++;
			if (count <= 4) {
				maskedString.insert(0, s.charAt(i));
			} else {
				maskedString.insert(0, '#');

			}
		}

		return maskedString.toString();

	}

	public static void printOddNumber(String s) {

		String input[] = s.split(",");

		int x = Integer.parseInt(input[0]);
		for (int i = 1; i < input.length; i++) {
			int value = Integer.parseInt(input[i]);
			x = x ^ value;
		}
		System.out.println(x);

	}

	public static String maskCardNumber(String cardNumber, String mask) {

		// format the number
		int index = 0;
		StringBuilder maskedNumber = new StringBuilder();
		for (int i = 0; i < mask.length(); i++) {
			char c = mask.charAt(i);
			if (c == '#') {
				maskedNumber.append(cardNumber.charAt(index));
				index++;
			} else if (c == 'x') {
				maskedNumber.append(c);
				index++;
			} else {
				maskedNumber.append(c);
			}
		}

		// return the masked number
		return maskedNumber.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printOddNumber("20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5");

	}

}
