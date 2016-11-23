package geeksforgeeks;

public class TwoRepeatingNumbers {

	public static void twoRepeatingNumbers(int a[]) {

		for (int i = 0; i < a.length; i++) {

			if (a[Math.abs(a[i]) - 1] < 0) {
				System.out.println(Math.abs(a[i]));
			} else {
				a[Math.abs(a[i]) - 1] = -1 * a[Math.abs(a[i]) - 1];
			}

		}
	}

	public static void main(String[] args) {
		int arr[] = { 4, 2, 4, 5, 2, 3, 1 };
		twoRepeatingNumbers(arr);
	}

}
