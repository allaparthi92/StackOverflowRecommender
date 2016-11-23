package geeksforgeeks;

public class MissingNumber {

	static int getMissingNo(int a[], int n) {
		int i;
		int x1 = 1;
		for (i = 2; i <= n; i++)
			x1 = x1 ^ i;

		for (int j = 0; j < a.length; j++) {
			x1 = x1 ^ a[j];
		}

		return (x1);
	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 4, 5, 6 };
		int miss = getMissingNo(a, 6);
		System.out.println(miss);

	}
}
