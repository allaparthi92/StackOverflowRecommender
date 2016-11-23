package amazon;

public class SumofNumbersInString {

	public static void main(String[] args) {

		String x = "11aa22bb33dd44";

		int finalsum = 0;
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < x.length(); i++) {

			if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
				temp.append(x.charAt(i));
			} else {

				if (temp.length() > 0) {
					int y = Integer.parseInt(temp.toString());
					finalsum = finalsum + y;
					temp = new StringBuilder();
				}
			}
		}
		finalsum  = finalsum + Integer.parseInt(temp.toString());
		System.out.println(finalsum);
	}

}
